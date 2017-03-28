package com.fengyun.data.service;

import com.fengyun.data.entity.ExcelAgentVO;

import java.util.List;

/**
 * Created by Administrator on 2017/3/28.
 */
public interface ImportPartyInfoService {

    void saveAgentInfo(List<ExcelAgentVO> excelAgentVOs);
}
