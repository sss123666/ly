package com.lenjoy.dao;

import com.lenjoy.entity.UserInfo;

public interface UserInfoDao {
    int addUserInfo(UserInfo userInfo);
    int addUserInfo(String userinfo);
UserInfo getUserInfoByUserNameAndPassword(String userName,String password);
}
