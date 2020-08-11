package com.tn.scrms.service.ding;

import com.tn.scrms.dao.oracle.DingSyncMapper;
import com.tn.scrms.service.ding.interf.IDingSyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: yangcs
 * @Date: 2020/6/20 16:08
 * @Description: 钉钉数据处理服务
 */
@Service
public class DingSyncService implements IDingSyncService {

    @Autowired
    private DingSyncMapper dingSyncMapper;

    @Override
    public void syncBusi() {
    }
}
