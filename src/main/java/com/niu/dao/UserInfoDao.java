package com.niu.dao;

import com.niu.config.MyMapper;
import com.niu.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by ami on 2018/11/20.
 */
@Mapper
public interface UserInfoDao extends MyMapper<UserInfo> {

}
