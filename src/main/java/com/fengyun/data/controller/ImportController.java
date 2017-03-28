package com.fengyun.data.controller;

import com.fengyun.data.entity.*;
import com.fengyun.utils.JFile;
import com.fengyun.utils.UploadUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.naming.SizeLimitExceededException;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/3/28.
 */
@Controller
@RequestMapping(value = "/import")
public class ImportController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImportController.class);

    @RequestMapping(value = "/importExcelToDB")
    @ResponseBody
    public ReqResult<?> importExcelToDB(HttpServletRequest request){
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
            List<ExcelPartyVO> excelPartyVOs = importJFile(jFile);
//            if(excelPartyVOs != null){
//                for(ExcelPartyVO excelPartyVO:excelPartyVOs){
//                    //PartyPersonTest表
//                    PartyPersonTest partyPerson = new ExcelPartyVO();
//                    UUID pid = UUID.randomUUID();
//                    personId = pid.toString();
//                    partyPerson.setId(personId);
//                    partyPerson.setAddress(excelPartyVO.getOccupation());//地址
//                    partyPerson.setEducation(excelPartyVO.getDegree());//学位
//                    partyPerson.setMobilePhone(excelPartyVO.getMobile());//手机
//                    partyPerson.setCreateDate(new Date());
//                    partyPerson.setModifyDate(new Date());
//                    partyPerson.setIsAvailable(1);
//                    partyPerson.setVersion(0);
//
//                    //PartyTest表
//                    PartyTest party = new PartyTest();
//                    UUID ppid = UUID.randomUUID();
//                    partyId = ppid.toString();
//                    party.setId(partyId);
//                    party.setPartyType("JC");
//                    party.setName(excelPartyVO.getName());
//                    party.setApproved("2");
//                    party.setPartyPersonId(personId);
//                    party.setLoginName(excelPartyVO.getName());
//                    party.setSource("JYW");
//                    party.setCreateDate(new Date());
//                    party.setModifyDate(new Date());
//                    party.setIsAvailable(1);
//                    party.setVersion(0);
//                    party.setRank("P");
//                    party.setPasswordLogin(excelPartyVO.getPassword());
//
//                    PartyAgentTest partyAgent = new PartyAgentTest();
//                    UUID paid = UUID.randomUUID();
//                    agentId = paid.toString();
//                    partyAgent.setId(agentId);
//                    partyAgent.setPartyId(partyId);
//
//
//
//
//
//
//
//
//
//
//                }
//            }

            //TODO 将数据转存数据库
            return ReqResult.success("成功");
        }catch(Exception e){
            LOGGER.error(e.getMessage(), e);
            return ReqResult.failure(e.getMessage());
        }
    }

    private List<ExcelPartyVO> importJFile(JFile jFile) {
        List<ExcelPartyVO> excelPartyVOs = null;

        try {
            String type = jFile.getFileExtension();
            if("xls,xlsx".contains(type.toLowerCase())){
                if (jFile.contentLength() <= 10* 1024 * 1024 + 1000) {
                    excelPartyVOs = analyzeExcel(jFile);
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return excelPartyVOs;
    }

    private List<ExcelPartyVO> analyzeExcel(JFile jFile) throws Exception{
        POIFSFileSystem fs = new POIFSFileSystem(new ByteArrayInputStream(jFile.getFileContent()));
        List<ExcelPartyVO> list = new ArrayList<ExcelPartyVO>();
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
                        String password = getCellValue(row.getCell(4));
                        String mobile = getCellValue(row.getCell(5));
                        String degree = getCellValue(row.getCell(7));
                        String occupation = getCellValue(row.getCell(8));
                        String address = getCellValue(row.getCell(9));


                        ExcelPartyVO excelPartyVO = new ExcelPartyVO();
                        excelPartyVO.setName(name);
                        excelPartyVO.setNumber(number);
                        excelPartyVO.setCompany(company);
                        if (StringUtils.isNotBlank(password)){
                            excelPartyVO.setPassword(UploadUtils.MD5(password));
                        }
                        excelPartyVO.setMobile(mobile);
                        excelPartyVO.setDegree(degree);
                        excelPartyVO.setOccupation(occupation);
                        excelPartyVO.setAddress(address);
                        excelPartyVO.setProvince("1510");
                        excelPartyVO.setCity("151005");
                        list.add(excelPartyVO);
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
