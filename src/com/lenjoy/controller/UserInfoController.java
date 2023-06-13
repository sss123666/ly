package com.lenjoy.controller;

import com.lenjoy.service.UserInfoService;
import com.lenjoy.service.impl.UserInfoServiceImpl;

public class UserInfoController {
    UserInfoService userInfoService=new UserInfoServiceImpl();
    public void showMenu(){
userInfoService.showMenu();
    }
public void register(){
        userInfoService.register();
}
public void login(){
        userInfoService.login();
}

}
