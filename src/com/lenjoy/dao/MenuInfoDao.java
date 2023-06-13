package com.lenjoy.dao;

import com.lenjoy.entity.MenuInfo;

import java.util.List;

public interface MenuInfoDao {
List getMenuInfoListBypId(Integer pId);
MenuInfo getMenuInfoById(Integer Id);
}
