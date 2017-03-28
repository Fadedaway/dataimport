package com.fengyun.data.service.impl;

import com.fengyun.data.repository.LoginPartyRepo;
import com.fengyun.data.entity.LoginParty;
import com.fengyun.data.service.LoginPartyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/3/28.
 */
@Service
@Transactional
public class LoginPartyServiceImpl implements LoginPartyService {

    private static final Logger logger = LoggerFactory.getLogger(LoginPartyServiceImpl.class);

    @Autowired
    private LoginPartyRepo loginPartyRepo;

    @Override
    public List<LoginParty> getAllLoginParty() {
        logger.info(">>>>>>>>>>>>>>>>> 取所有loginparty ");

        return loginPartyRepo.findAll();
    }
}
