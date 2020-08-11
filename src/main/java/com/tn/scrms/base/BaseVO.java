package com.tn.scrms.base;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @Author: yangcs
 * @Date: 2020/4/21 10:25
 * @Description: 前端参数接受基础类
 */
@Data
public class BaseVO {

    //当前页
    @JSONField(serialize = false)
    private int page = 1;


    //页数
    @JSONField(serialize = false)
    private int rows = 20;


}
