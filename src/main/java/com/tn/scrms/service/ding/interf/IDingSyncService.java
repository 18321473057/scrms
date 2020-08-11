package com.tn.scrms.service.ding.interf;

import com.github.pagehelper.PageInfo;
import com.tn.scrms.domain.CrmsTestVo;
import com.tn.scrms.domain.OracleTestVo;

/**
 * @Author: yangcs
 * @Date: 2020/6/16 10:01
 * @Description: 钉钉数据处理服务
 */
public interface IDingSyncService {

    //初始化业务员账号数据
    void syncBusi();

}
