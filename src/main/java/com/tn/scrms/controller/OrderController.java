package com.tn.scrms.controller;

import com.github.pagehelper.PageInfo;
import com.tn.scrms.base.BasicController;
import com.tn.scrms.base.Response;
import com.tn.scrms.domain.CrmsTestVo;
import com.tn.scrms.domain.OracleTestVo;
import com.tn.scrms.exception.BusinessException;
import com.tn.scrms.service.interf.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author: yangcs
 * @Date: 2020/6/16 10:01
 * @Description:
 */
@RestController
@RequestMapping("/test")
public class OrderController extends BasicController {
    @Autowired
    private IOrderService orderService;

    @GetMapping("/map")
    public void map(Model mo) {
        Map<String, Object> stringObjectMap = mo.asMap();
        System.out.println(stringObjectMap);
    }


    //基础crud 测试

    @GetMapping("/get")
    public Response<CrmsTestVo> get() {
        return returnSuccess(orderService.getOne());
    }

    @GetMapping("/o/get")
    public Response<OracleTestVo> oGet() {
        return returnSuccess(orderService.oGetOne());
    }


    @GetMapping("/get_list")
    public Response<List<CrmsTestVo>> getList(CrmsTestVo vo) {
        PageInfo<CrmsTestVo> list = orderService.getList(vo);
        return returnSuccess(list.getList(), list.getTotal());
    }

    @GetMapping("/et")
    public Response userInfo(@RequestParam String code) {

        if ("a".equals(code)) {
            throw new BusinessException("我是自定义异常");
        } else if ("b".equals(code)) {
            throw new RuntimeException("我是其他异常");
        }
        return returnSuccess();
    }

    @GetMapping("/add")
    public int add() {
        return orderService.add();
    }

    @GetMapping("/update")
    public Response update(String id) {
        return returnSuccess(orderService.update(id));
    }

    @GetMapping("/o/update")
    public Response oUpdate(String id) {
        return returnSuccess(orderService.oUpdate(id));
    }


    @GetMapping("/o/get_list")
    public Response<List<OracleTestVo>> getOList(OracleTestVo vo) {
        PageInfo<OracleTestVo> list = orderService.getOList(vo);
        return returnSuccess(list.getList(), list.getTotal());
    }

    @GetMapping("/o/add")
    public int oAdd(OracleTestVo vo) {
        return orderService.oAdd();
    }


    // 事务 测试


    @GetMapping("/mo")
    public int mo() {
        return orderService.mo();
    }


    @GetMapping("/om")
    public int om() {
        return orderService.om();
    }


}
