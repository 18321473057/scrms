package com.tn.scrms.base;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yangcs
 * @Date: 2020/6/20 15:38
 * @Description:
 */
@ControllerAdvice
public class GlobaContextResolver {

    @ModelAttribute(name = "appInfo")
    public Map<String, Object> mydata() {
        Map<String, Object> map = new HashMap();
        map.put("name", "scmrs");
        map.put("description", "营销创新系统");
        return map;
    }

}
