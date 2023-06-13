package com.lenjoy.dao.impl;

import com.lenjoy.dao.MenuInfoDao;
import com.lenjoy.entity.MenuInfo;
import com.lenjoy.utils.BaseDao;

import java.util.List;

public class MenuInfoDaoImpl extends BaseDao<MenuInfo>implements MenuInfoDao {
    @Override
    public List<MenuInfo> getMenuInfoListBypId(Integer pId) {
        String sql="select * from t_menu_info where pId=?";
        return selectListForObject(sql,MenuInfo.class,pId);
    } 

    @Override
    public MenuInfo getMenuInfoById(Integer id) {
        return selectOne("select * from t_menu_info where id=?",MenuInfo.class,id);
    }
}
