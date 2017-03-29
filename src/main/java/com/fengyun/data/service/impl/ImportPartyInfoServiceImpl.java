package com.fengyun.data.service.impl;

import com.fengyun.data.entity.AgentInfo;
import com.fengyun.data.entity.ExcelAgentVO;
import com.fengyun.data.repository.AgentInfoRepo;
import com.fengyun.data.service.ImportPartyInfoService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/28.
 */
@Service
@Transactional
public class ImportPartyInfoServiceImpl implements ImportPartyInfoService{

    private static final Logger logger = LoggerFactory.getLogger(ImportPartyInfoServiceImpl.class);

    @Autowired
    private AgentInfoRepo agentInfoRepo;

    @Override
    public void saveAgentInfo(List<ExcelAgentVO> excelAgentVOs) {

        logger.info(">>>>>>>>>>>>>>>>> 开始向AgentInfo 中导入数据，数据量： "+ (null==excelAgentVOs?0:excelAgentVOs.size()));
        for (ExcelAgentVO excelAgentVO : excelAgentVOs){
            AgentInfo agentInfo = new AgentInfo();

            agentInfo.setNumber(excelAgentVO.getNumber());
            agentInfo.setAgencyName(excelAgentVO.getCompany());
            agentInfo.setName(excelAgentVO.getName());
            if (StringUtils.isNotBlank(excelAgentVO.getMobile())){
                agentInfo.setMobile(excelAgentVO.getMobile());
            }
            agentInfo.setProvince("1510");
            agentInfo.setCity("151005");
            agentInfo.setType("0");

            agentInfo.setSaasCode("super");
            agentInfo.setIsAvailable(1);
            agentInfo.setCreateDate(new Date());
            agentInfo.setModifyDate(new Date());
            agentInfo.setVersion(0);

            agentInfoRepo.save(agentInfo);
        }

    }
}
