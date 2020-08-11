package com.tn.scrms.base;


import com.tn.scrms.base.Response;

/**
 * @Author: yangcs
 * @Date: 2020/3/26 14:32
 * @Description: 基础父控制层, 提供返回对象的封装
 */
public class BasicController {

    /**
     * @param rows  列表数据
     * @param total 总条数
     * @Description: 组织返回前段数据格式:: 查询列表
     */
    public <T> Response<T> returnSuccess(T rows, Long total) {
        return Response.buildSuccessResponse(rows, total);
    }


    /**
     * @Description: 返回成功
     */
    public <T> Response<T> returnSuccess() {
        return Response.buildSuccessResponse("SUCCESS");
    }

    /**
     * @Description: 返回成功
     */
    public <T> Response<T> returnSuccess(T obj) {
        return Response.buildSuccessResponse(obj);
    }


    /**
     * @param msg 返回消息
     * @Description: 组织返回前段数据格式
     */
    public Response returnFailure(String msg) {
        return Response.buildFailureResponse(msg);
    }

}
