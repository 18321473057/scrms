package com.tn.scrms.controller.ding;

import com.tn.scrms.base.BasicController;
import com.tn.scrms.base.Response;
import com.tn.scrms.service.ding.interf.IDingSyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yangcs
 * @Date: 2020/6/20 14:27
 * @Description: 钉钉数据处理服务
 */
@RestController
@RequestMapping("/ding/sync")
public class DingSyncController extends BasicController {
    @Value("${ding.operation.acct.userName:}")
    private String userName;
    @Value("${ding.operation.acct.passWord:}")
    private String passWord;

    @Autowired
    private IDingSyncService syncService;

    @GetMapping("/busi")
    public Response business(@RequestParam String userName, @RequestParam String passWord) {
        if (!this.userName.equals(userName) || !this.passWord.equals(passWord)) {
            return returnFailure("用户信息验证失败!");
        }
        syncService.syncBusi();
        return returnSuccess("钉钉业务人员初始化成功!");
    }


}
