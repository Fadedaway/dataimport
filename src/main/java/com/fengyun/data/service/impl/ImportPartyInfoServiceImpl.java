package com.fengyun.data.service.impl;

import com.fengyun.data.entity.ExcelAgentVO;
import com.fengyun.data.service.ImportPartyInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/3/28.
 */
@Service
@Transactional
public class ImportPartyInfoServiceImpl implements ImportPartyInfoService{

    @Override
    public void saveAgentInfo(List<ExcelAgentVO> excelAgentVOs) {

    }
}
