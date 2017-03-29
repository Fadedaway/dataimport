package com.fengyun.data.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.SizeLimitExceededException;
import javax.servlet.http.HttpServletRequest;

import com.fengyun.data.service.ImportPartyInfoService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.spi.LoggerFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fengyun.data.entity.ExcelAgentVO;
import com.fengyun.data.entity.ReqResult;
import com.fengyun.utils.JFile;
import com.fengyun.utils.UploadUtils;

@Controller
@RequestMapping("/partyInfo")
public class ImprotPartyInfoController {
	
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ImprotPartyInfoController.class);

	@Autowired
	private ImportPartyInfoService importPartyInfoService;

	@RequestMapping("/importPartyInfoFile")
	@ResponseBody
	public ReqResult<?> importPartyInfoFile(HttpServletRequest request){
		String path = "image";
        MultipartHttpServletRequest multipartHttpServletRequest = null;
        try {
            multipartHttpServletRequest = UploadUtils.createMultipartHttpServletRequest(request);
            path = StringUtils.defaultIfBlank(multipartHttpServletRequest.getParameter("file"), path);
        } catch (MaxUploadSizeExceededException e) {
            LOGGER.error("上传附件大于20M", e);
            return ReqResult.failure("上传附件大于20M");
        } catch (SizeLimitExceededException e) {
            LOGGER.error("上传附件大于20M", e);
            return ReqResult.failure("上传附件大于20M");
        }
        MultipartFile file = multipartHttpServletRequest.getFile("file");
        if (file == null) {
            return ReqResult.failure("请先上传文件");
        }

        try{
            JFile jFile = UploadUtils.tranFile(file, path);
            List<ExcelAgentVO> excelAgentVO = importJFile(jFile);
            //TODO 将数据转存数据库
            importPartyInfoService.saveAgentInfo(excelAgentVO);
            LOGGER.info(">>>>>>>>>>>>>>>>> 向AgentInfo 中导入数据完成！");

            return ReqResult.success("成功");
        }catch(Exception e){
            LOGGER.error(e.getMessage(), e);
            return ReqResult.failure(e.getMessage());
        }
	}
	
	private List<ExcelAgentVO> importJFile(JFile jFile) {
        List<ExcelAgentVO> excelAgentVOs = null;

        try {
            String type = jFile.getFileExtension();
            if("xls,xlsx".contains(type.toLowerCase())){
                if (jFile.contentLength() <= 10* 1024 * 1024 + 1000) {
                	excelAgentVOs = analyzeExcel(jFile);
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return excelAgentVOs;
    }

    private List<ExcelAgentVO> analyzeExcel(JFile jFile) throws Exception{
        POIFSFileSystem fs = new POIFSFileSystem(new ByteArrayInputStream(jFile.getFileContent()));
        List<ExcelAgentVO> list = new ArrayList<ExcelAgentVO>();
        // 创建工作簿
        @SuppressWarnings("resource")
        HSSFWorkbook workBook = new HSSFWorkbook(fs);
        HSSFSheet sheet = workBook.getSheetAt(0);
        int rows = sheet.getPhysicalNumberOfRows(); // 获得行数

        if (rows > 0) {
            for (int i = 1; i < rows; i++) {
                try {
                    HSSFRow row = sheet.getRow(i);
                    if(row != null){
                        String name = getCellValue(row.getCell(1));
                        String number = getCellValue(row.getCell(2));
                        String company = getCellValue(row.getCell(3));
                        String mobile = getCellValue(row.getCell(4));

                        ExcelAgentVO excelAgentVO = new ExcelAgentVO();
                        excelAgentVO.setName(name);
                        excelAgentVO.setNumber(number);
                        excelAgentVO.setCompany(company);
                        excelAgentVO.setMobile(mobile);
                        list.add(excelAgentVO);
                    }
                } catch (Exception e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
        return list;
    }

    private String getCellValue(HSSFCell cell) {
        if (cell != null) {
            if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                return String.valueOf((long) cell.getNumericCellValue()).trim();
            }else{
                return cell.toString().trim();
            }
        }
        return null;
    }
}
