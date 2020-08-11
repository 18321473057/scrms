package com.tn.scrms.dao.oracle;

import com.tn.scrms.base.IBaseDao;
import com.tn.scrms.domain.OracleTestVo;
import com.tn.scrms.po.OracleTestPo;

import java.util.List;

/**
 * @Author: yangcs
 * @Date: 2020/5/30 10:08
 * @Description: 钉钉应用token 管理mapper
 */
public interface OracleTestMapper extends IBaseDao<OracleTestPo> {

    List<OracleTestVo> getOList();

    int insert(OracleTestPo crmsTest);
}
