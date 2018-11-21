package com.niu.config;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by ami on 2018/11/20.
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {

    //FIXME 特别注意，该接口不能被扫描到，否则会出错
}
