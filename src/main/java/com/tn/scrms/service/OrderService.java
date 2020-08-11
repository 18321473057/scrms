package com.tn.scrms.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tn.scrms.dao.mysql.OrderDao;
import com.tn.scrms.domain.CrmsTestVo;
import com.tn.scrms.domain.OracleTestVo;
import com.tn.scrms.dao.oracle.OracleTestMapper;
import com.tn.scrms.po.CrmsTestPo;
import com.tn.scrms.po.OracleTestPo;
import com.tn.scrms.service.interf.IOrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: yangcs
 * @Date: 2020/6/16 10:02
 * @Description:
 */
@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OracleTestMapper oracleTestMapper;

    @Override
    public CrmsTestVo getOne() {
        CrmsTestPo po = new CrmsTestPo();
        po.setId("2");
        CrmsTestPo crmsTestPo = orderDao.selectOne(po);
        CrmsTestVo vo = new CrmsTestVo();
        BeanUtils.copyProperties(crmsTestPo, vo);
        return vo;
    }

    @Override
    public OracleTestVo oGetOne() {
        OracleTestPo po = new OracleTestPo();
        po.setId("31124");
        OracleTestPo oracleTestPo = oracleTestMapper.selectOne(po);
        OracleTestVo vo = new OracleTestVo();
        BeanUtils.copyProperties(oracleTestPo, vo);
        return vo;
    }


    @Override
    public PageInfo<CrmsTestVo> getList(CrmsTestVo vo) {
        PageHelper.startPage(vo.getPage(), vo.getRows());
        List<CrmsTestVo> list = orderDao.getList();
        return new PageInfo<CrmsTestVo>(list);
    }


    @Override
    public int update(String id) {
        CrmsTestPo crmsTest = new CrmsTestPo();
        crmsTest.setId(id);
        crmsTest.setName("俺是中国人");
        return orderDao.updateByPrimaryKeySelective(crmsTest);
    }


    @Override
    public int oUpdate(String id) {
        OracleTestPo crmsTest = new OracleTestPo();
        crmsTest.setId(id);
        crmsTest.setName("奥瑞扣数据库呢");
        return oracleTestMapper.updateByPrimaryKeySelective(crmsTest);
    }


    @Override
    public PageInfo<OracleTestVo> getOList(OracleTestVo vo) {
        PageHelper.startPage(vo.getPage(), vo.getRows());
        List<OracleTestVo> list = oracleTestMapper.getOList();
        return new PageInfo<OracleTestVo>(list);
    }

    @Override
    @Transactional
    public int add() {
        CrmsTestPo crmsTest = new CrmsTestPo();
        crmsTest.setName("事务回滚测试");
        crmsTest.setPhone(18018850547L);
        orderDao.insertSelective(crmsTest);
        int i = 0 / 0;
        return  1;
    }

    @Override
    @Transactional
    public int oAdd() {
        OracleTestPo crmsTest = new OracleTestPo();
        crmsTest.setId("31121411");
        crmsTest.setName("CRSMProject");
        crmsTest.setPhone(18018850547L);
        return oracleTestMapper.insertSelective(crmsTest);
//        return oracleTestMapper.insert(crmsTest);
    }

    @Override
    @Transactional
    public int mo() {
        add();
        oAdd();
        int i = 0 / 0;
        return 0;
    }

    @Override
    @Transactional
    public int om() {
        oAdd();
        add();
        int i = 0 / 0;
        return 0;

    }

}
