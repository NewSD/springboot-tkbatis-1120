package com.niu.controller;

import com.niu.entity.UserInfo;
import com.niu.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by ami on 2018/11/20.
 */
@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserController {

    @Resource
    private UserInfoService userInfoService;

    @RequestMapping(value = "/get", method = GET)
    @ResponseBody
    UserInfo getUserById(
            @RequestParam(value = "id",required = true) Integer id
    ) {
        return userInfoService.findById(id);
    }

    //增加新的对外访问接口
    @RequestMapping(value = "/add", method = GET)
    @ResponseBody
    String add() {
        userInfoService.insertUserInfo("username123寇鑫", "password123寇鑫");
        return "插入成功";
    }

    //新增的接口方法
    @RequestMapping(value = "/getall", method = GET)
    @ResponseBody
    List<UserInfo> getall() {
        return userInfoService.selectAll();
    }


    @RequestMapping(value = "/addByGetId", method = GET)
    @ResponseBody
    UserInfo insetWithId(
            @RequestParam(value = "username",required = true) String username,
            @RequestParam(value = "password",required = true) String password
    ){
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setPassword(password);
        return userInfoService.inserWithId(userInfo);
    }



    @RequestMapping(value = "/findByPage", method = GET)
    @ResponseBody
    public List<UserInfo> findByPage(
            @RequestParam(value = "pageNo",required = false) Integer pageNo,
            @RequestParam(value = "pageSize",required = false) Integer pageSize
    ){
        return userInfoService.findByPage(pageNo,pageSize);
    }

    @RequestMapping(value = "/findByName", method = GET)
    @ResponseBody
    public List<UserInfo> findByName(
            @RequestParam(value = "username", required = false) String username
    ) {
        return userInfoService.findByName(username);
    }

}
