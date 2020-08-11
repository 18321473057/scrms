package com.tn.scrms.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Description: 公用Mapper接口
 */
public interface IBaseDao<T> extends Mapper<T>, MySqlMapper<T> {


}

