package com.lenjoy.utils;

import com.lenjoy.entity.MenuInfo;


import java.util.HashMap;
import java.util.Map;

//存放对象的工具
public abstract class SessionUtil {
    public static MenuInfo menuInfo;


    private static Map<String,Object>sessionMap=new HashMap<>();

    public static void setAttribute(String key,Object value){
        sessionMap.put(key,value);
    }
    public static Object getAttribute(String key){
        return sessionMap.get(key);
    }

}
