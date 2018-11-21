package com.niu.dao;

import com.niu.entity.UserInfo;
import com.niu.query.UserInfoQuery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ami on 2018/11/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoDaoTest {
    @Resource
    private UserInfoDao userInfoDao;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test1(){
        UserInfo userInfo = userInfoDao.selectByPrimaryKey(10);
        System.out.println(userInfo);
    }

    @Test
    public void test11(){
        List<UserInfo> list = userInfoDao.selectAll();
        list.forEach(System.out::println);
    }
    @Test
    public void test2(){
        List<UserInfo> list = userInfoDao.selectByExample(UserInfoQuery.builder()
                .username("h")
                .build().toExample());
        list.forEach(System.out::println);
    }

    @Test
    public void test3(){
        List<UserInfo> list = userInfoDao.selectByExample(UserInfoQuery.builder()
                .username("h")
                .startId(21).endId(25)
                .build().toExample());
        list.forEach(System.out::println);
    }



}