package com.tn.scrms.service.interf;

import com.github.pagehelper.PageInfo;
import com.tn.scrms.base.Response;
import com.tn.scrms.domain.CrmsTestVo;
import com.tn.scrms.domain.OracleTestVo;

import java.util.List;

/**
 * @Author: yangcs
 * @Date: 2020/6/16 10:01
 * @Description:
 */
public interface IOrderService {

    CrmsTestVo getOne();

    PageInfo<CrmsTestVo> getList(CrmsTestVo vo);

    int add();

    int update(String id);

    PageInfo<OracleTestVo> getOList(OracleTestVo vo);

    int oAdd();

    OracleTestVo oGetOne();

    int oUpdate(String id);

    int mo();

    int om();
}
