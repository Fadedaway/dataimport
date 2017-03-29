package com.fengyun.data.service.impl;

import com.fengyun.data.repository.LoginPartyRepo;
import com.fengyun.data.repository.PartyAgentRepo;
import com.fengyun.data.repository.PartyPersonRepo;
import com.fengyun.data.repository.PartySaascodeRepo;
import com.fengyun.data.entity.ExcelPartyVO;
import com.fengyun.data.entity.LoginParty;
import com.fengyun.data.entity.PartyPerson;
import com.fengyun.data.entity.PartySaasCode;
import com.fengyun.data.entity.UserAgentManage;
import com.fengyun.data.service.LoginPartyService;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/3/28.
 */
@Service
@Transactional
public class LoginPartyServiceImpl implements LoginPartyService {

    private static final Logger logger = LoggerFactory.getLogger(LoginPartyServiceImpl.class);

    @Autowired
    private LoginPartyRepo loginPartyRepo;
    
    @Autowired
    private PartyPersonRepo partyPersonRepo;
    
    @Autowired
    private PartyAgentRepo partyAgentRepo;
    
    @Autowired
    private PartySaascodeRepo partySaascodeRepo;

    
	public List<LoginParty> getAllLoginParty() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saves(List<ExcelPartyVO> excelPartyVOs) {
		 if(excelPartyVOs != null){
             for(ExcelPartyVO excelPartyVO:excelPartyVOs){
                 //PartyPersonTest表
                 PartyPerson partyPerson = new PartyPerson();
                 partyPerson.setAddress(excelPartyVO.getAddress());//地址
                 partyPerson.setMobilePhone(excelPartyVO.getMobile());//手机
                 partyPerson.setCreateDate(new Date());
                 partyPerson.setModifyDate(new Date());
                 partyPerson.setIsAvailable(1);
                 partyPerson.setVersion(0);
                 partyPerson.setXueli(excelPartyVO.getDegree());
                 if(StringUtils.isNotBlank(excelPartyVO.getDegree())){
                	 switch(excelPartyVO.getDegree()){
                	 case "MBA":partyPerson.setEducation("03");break;
                	 case "本  科":partyPerson.setEducation("02");break;
                	 case "本科":partyPerson.setEducation("02");break;
                	 case "本科在读":partyPerson.setEducation("04");break;
                	 case "博士":partyPerson.setEducation("03");break;
                	 case "博士研究生":partyPerson.setEducation("03");break;
                	 case "初中":partyPerson.setEducation("04");break;
                	 case "大 专":partyPerson.setEducation("01");break;
                	 case "大本":partyPerson.setEducation("02");break;
                	 case "大普":partyPerson.setEducation("02");break;
                	 case "大学":partyPerson.setEducation("02");break;
                	 case "大学专科":partyPerson.setEducation("01");break;
                	 case "大专":partyPerson.setEducation("01");break;
                	 case "高中":partyPerson.setEducation("04");break;
                	 case "工学博士":partyPerson.setEducation("03");break;
                	 case "工学硕士":partyPerson.setEducation("03");break;
                	 case "科技主管":partyPerson.setEducation("04");break;
                	 case "双大专":partyPerson.setEducation("01");break;
                	 case "硕士":partyPerson.setEducation("03");break;
                	 case "硕士研究":partyPerson.setEducation("03");break;
                	 case "硕士研究生":partyPerson.setEducation("03");break;
                	 case "硕士在读":partyPerson.setEducation("03");break;
                	 case "学士":partyPerson.setEducation("02");break;
                	 case "研究生":partyPerson.setEducation("03");break;
                	 case "研究生在读":partyPerson.setEducation("03");break;
                	 case "中专":partyPerson.setEducation("04");break;
                	 case "专科":partyPerson.setEducation("01");break;
                	 default : partyPerson.setEducation("04"); break;
                	 
                	 }
                 }
                 
                 partyPersonRepo.save(partyPerson);
                 
                 
                 //PartyTest表
                 LoginParty party = new LoginParty();
                 party.setPartyType("JC");
                 party.setName(excelPartyVO.getName());
                 party.setApproved("2");
                 party.setPartyPersonId(partyPerson.getId());
                 party.setLoginName(excelPartyVO.getName());
                 party.setSource("JYW");
                 party.setCreateDate(new Date());
                 party.setModifyDate(new Date());
                 party.setIsAvailable(1);
                 party.setVersion(0);
                 party.setRank("P");
                 party.setPasswordLogin(excelPartyVO.getPassword());
                 loginPartyRepo.save(party);
                 
                 
                 //PartyAgentTest表
                 UserAgentManage partyAgent = new UserAgentManage();
                 UUID agentId = UUID.randomUUID();
                 partyAgent.setId(agentId.toString());
                 partyAgent.setPartyId(party.getId());
                 partyAgent.setProvince(excelPartyVO.getProvince());
                 partyAgent.setCity(excelPartyVO.getCity());
                 partyAgent.setLocation(excelPartyVO.getAddress());
                 partyAgent.setNumber(excelPartyVO.getNumber());
                 partyAgent.setSaasCode("super");
                 partyAgent.setIsAvailable(1);
                 partyAgent.setCreateDate(new Date());
                 partyAgent.setModifyDate(new Date());
                 partyAgent.setVersion(0);
                 partyAgent.setType("1");
                 partyAgent.setName(excelPartyVO.getName());
                 partyAgent.setAgencyName(excelPartyVO.getCompany());
                 partyAgent.setMobilePhone(excelPartyVO.getMobile());
                 partyAgentRepo.save(partyAgent);
                 
                 //PartySaascodeTest表
                 PartySaasCode partySaascode = new PartySaasCode();
                 UUID saascodeId = UUID.randomUUID();
                 partySaascode.setId(saascodeId.toString());
                 partySaascode.setPartyId(party.getId());
                 partySaascode.setSaasCode("super");
                 partySaascode.setCreateDate(new Date());
                 partySaascode.setModifyDate(new Date());
                 partySaascode.setVersion(0);
                 partySaascode.setIsAvailable(1);
                 partySaascodeRepo.save(partySaascode);
                 
                 
                 
		
             }
		 }
	}
}
