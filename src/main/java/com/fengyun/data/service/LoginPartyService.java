package com.fengyun.data.service;

import com.fengyun.data.entity.ExcelPartyVO;
import com.fengyun.data.entity.LoginParty;
import com.fengyun.data.entity.PartyPerson;
import com.fengyun.data.entity.PartySaasCode;
import com.fengyun.data.entity.UserAgentManage;

import java.util.List;

/**
 * Created by Administrator on 2017/3/28.
 */
public interface LoginPartyService {

    List<LoginParty> getAllLoginParty();
    
//    void savePartyPerson(List<PartyPerson> partyPersons);
//    void saveLoginParty(List<LoginParty> loginPartys);
//    void savePartySaascode(List<PartySaasCode> partySaascodes);
//    void savePartyAgent(List<UserAgentManage> userAgentManages);
    
    
    void saves(List<ExcelPartyVO> excelPartyVOs);
}
