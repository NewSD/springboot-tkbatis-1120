package com.niu.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.niu.dao.UserDao;
import com.niu.dao.UserInfoDao;
import com.niu.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by ami on 2018/11/20.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserInfo getUserInfo(String username) {
        return userDao.findByName(username);
    }

    @Override
    public int insertUserInfo(String username, String password) {
        return userDao.insert(username, password);
    }


    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public List<UserInfo> selectAll() {
        return userInfoDao.selectAll();
    }

    @Override
    public UserInfo inserWithId(UserInfo userInfo) {
        userInfoDao.insert(userInfo);
        System.out.println(userInfo.getId());
        return userInfo;
    }

    @Override
    public List<UserInfo> findByPage(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<UserInfo> list = userInfoDao.selectAll();
        PageInfo<UserInfo> pageInfo = new PageInfo<UserInfo>(list);
        System.out.println("pageInfo:" + pageInfo);
        return list;
    }

    @Override
    public UserInfo findById(Integer id) {
        return userInfoDao.selectByPrimaryKey(id);
    }

    @Override
    public List<UserInfo> findByName(String username) {
        Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("username", "%"+username+"%");
        List<UserInfo> list = userInfoDao.selectByExample(example);
        return list;
    }
}
