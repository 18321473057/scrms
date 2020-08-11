package com.tn.scrms.controller.ding;

import com.tn.scrms.base.BasicController;
import com.tn.scrms.base.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yangcs
 * @Date: 2020/6/20 14:27
 * @Description: 钉钉应用用户信息管理
 */
@RestController
@RequestMapping("/ding/user/info/v1")
public class DingUserInfoController extends BasicController {

    @GetMapping("/get")
    public Response get(@RequestParam String userName, @RequestParam String passWord) {
        return returnSuccess("!");
    }


}
