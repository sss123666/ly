package com.lenjoy.utils;

import com.lenjoy.controller.MenuInfoController;
import com.lenjoy.dao.MenuInfoDao;
import com.lenjoy.dao.impl.MenuInfoDaoImpl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//实现菜单动态选择的工具
public class TrendsSwitchUtil {
    private static final String PREFIX="com.lenjoy.controller.";

    //执行选择菜单对应的方法
    public static void invokeMethod(){
        //从菜单对象中获取url，方便实例化对象，执行方法
        //先根据“/”把url拆开，下标为0是类名，1为方法名
        String[] split = SessionUtil.menuInfo.getUrl().split("/");
        try {
            //在类型前面拼上“com.lenjoy.controller.”通过反射实例化对象
            Class aClass = Class.forName(PREFIX + split[0]);
            //通过反射创建对象
            Object obj = aClass.newInstance();
            //根据方法名获取对应的执行方法
            Method method = aClass.getMethod(split[1]);
            //执行方法
            method.invoke(obj);
        } catch (ClassNotFoundException e) {
            System.out.println("获取字节码对象失败"+(PREFIX+split[0]));
            e.printStackTrace();
        } catch (InstantiationException e) {
            System.out.println("创建对象异常");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            System.out.println("获取不到执行方法");
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            System.out.println("执行方法异常");
            e.printStackTrace();
        }
    }



    //返回上一级菜单
    public static void rollBackMethod(){
        //获取当前选中菜单的父级id
        Integer pId = SessionUtil.menuInfo.getPId();
        if (pId!=-1){
            MenuInfoDao menuInfoDao=new MenuInfoDaoImpl();
            SessionUtil.menuInfo=menuInfoDao.getMenuInfoById(pId);
            invokeMethod();
        }else {
            //直接调用主菜单的方法
            MenuInfoController menuInfoController=new MenuInfoController();
            menuInfoController.showMainMenu();
        }

    }
}
