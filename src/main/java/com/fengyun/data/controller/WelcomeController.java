package com.fengyun.data.controller;

import com.fengyun.data.entity.LoginParty;
import com.fengyun.data.service.LoginPartyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Administrator on 2017/3/28.
 */
@Controller
public class WelcomeController {

    private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    @Autowired
    private LoginPartyService loginPartyService;

    @RequestMapping(value = "/")
    public String welcome(){
        logger.info(" >>>>>>>>>>>>>>>>>>  进入首页 <<<<<<<<<<<<<<<<<<<< ");
        return "index";
    }

    @RequestMapping(value = "/getAllLoginParty")
    public void getAllLoginParty(){
        List<LoginParty> loginParties = loginPartyService.getAllLoginParty();
        logger.info(" >>>>>>>>>>>>>>>>>>  loginparty size <<<<<<<<<<<<<<<<<<<< : " + ((null==loginParties)?0:loginParties.size()));
        for (LoginParty loginParty:loginParties){
            logger.info(">> id:  " + loginParty.getId() + "  >> name: "+ loginParty.getName());
        }
    }
}
