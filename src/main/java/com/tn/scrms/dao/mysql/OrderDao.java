package com.tn.scrms.dao.mysql;

import com.tn.scrms.base.IBaseDao;
import com.tn.scrms.po.CrmsTestPo;
import com.tn.scrms.domain.CrmsTestVo;

import java.util.List;

/**
 * @Author: yangcs
 * @Date: 2020/6/16 10:02
 * @Description:
 */

public interface OrderDao extends IBaseDao<CrmsTestPo> {

    List<CrmsTestVo> getList();

    int insert(CrmsTestPo crmsTest);

    CrmsTestVo getOne();
}
