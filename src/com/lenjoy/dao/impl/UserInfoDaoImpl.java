package com.lenjoy.dao.impl;

import com.lenjoy.dao.UserInfoDao;
import com.lenjoy.entity.UserInfo;
import com.lenjoy.utils.BaseDao;

public class UserInfoDaoImpl extends BaseDao<UserInfo>implements UserInfoDao {
    @Override
    public int addUserInfo(UserInfo userInfo) {
        String sql="insert into t_user_info value(null,?,?,?,default,default)";
        return executeUpdate(sql,userInfo.getUserName(),userInfo.getPassword(),userInfo.getEmil());
    }

    @Override
    public int addUserInfo(String emil) {
        String sql="update t_user_info set emil=? where emil=?";
        return executeUpdate(sql,emil,emil);
    }

    @Override
    public UserInfo getUserInfoByUserNameAndPassword(String userName, String password) {
        String sql="select * from t_user_info where user_name=? and password=?";
        return selectOne(sql,UserInfo.class,userName,password);
    }
}
