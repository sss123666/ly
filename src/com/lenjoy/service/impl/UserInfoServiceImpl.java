package com.lenjoy.service.impl;

import com.lenjoy.dao.UserInfoDao;
import com.lenjoy.dao.impl.UserInfoDaoImpl;
import com.lenjoy.entity.UserInfo;
import com.lenjoy.service.MenuInfoService;
import com.lenjoy.service.UserInfoService;
import com.lenjoy.utils.MD5Utils;
import com.lenjoy.utils.SessionUtil;
import com.lenjoy.utils.TrendsSwitchUtil;
import sun.security.util.Password;

import java.util.Scanner;

public class UserInfoServiceImpl implements UserInfoService {
    private UserInfoDao userInfoDao=new UserInfoDaoImpl();
    private Scanner sc=new Scanner(System.in);
    private MenuInfoService menuInfoService=new MenuInfoServiceImpl();

    @Override
    public void showMenu() {
        System.out.println("---------乐享洛阳-->用户版");
        menuInfoService.showMenu(1);
        TrendsSwitchUtil.invokeMethod();
        ;

    }

    @Override
    public void register() {
        System.out.println("乐享洛阳-------->用户版-------->(注册)");
        UserInfo userInfo=new UserInfo();
        System.out.println("用户名");
        String userName=sc.next();
        System.out.println("密码");
        String password=sc.next();
        //密码加密
       userInfo.setPassword(MD5Utils.encryptMD5(password,userName));
        System.out.println("邮箱");
        String emil=sc.next();
        int row=userInfoDao.addUserInfo(emil);
        if (row>0){
            System.out.println("邮箱已存在");
            TrendsSwitchUtil.rollBackMethod();
        }else {
      userInfo.setEmil(emil);
      int row2=userInfoDao.addUserInfo(userInfo);
            System.out.println(row2>0?"注册成功":"注册失败");
            TrendsSwitchUtil.rollBackMethod();
        }
    }

    @Override
    public void login() {
        System.out.println("乐享洛阳-------->用户版-------->(登录)");
        System.out.println("用户名");
        String userName=sc.next();
        System.out.println("密码");
        String password=sc.next();
        String encryptMD5 = MD5Utils.encryptMD5(password, userName);
        UserInfo userInfo=userInfoDao.getUserInfoByUserNameAndPassword(userName,encryptMD5);
       if (userInfo!=null){
           System.out.println("登录成功 欢迎您"+userInfo.getUserName());
           SessionUtil.setAttribute("userInfo",userInfo);
           menuInfoService.showMenu(SessionUtil.menuInfo.getId());
           TrendsSwitchUtil.invokeMethod();

       }

    }
}
