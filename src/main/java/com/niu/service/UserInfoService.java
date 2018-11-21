package com.niu.service;

import com.niu.entity.UserInfo;
import com.niu.vo.PagedResult;

import java.util.List;

/**
 * Created by ami on 2018/11/20.
 */
public interface UserInfoService {

    UserInfo getUserInfo(String username);

    int insertUserInfo(String username, String password);

    List<UserInfo> selectAll();

    UserInfo inserWithId(UserInfo userInfo);

    List<UserInfo> findByPage(Integer pageNo, Integer pageSize);

    UserInfo findById(Integer id);

    List<UserInfo> findByName(String username);
}
