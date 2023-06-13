package com.lenjoy.service.impl;

import com.lenjoy.dao.MenuInfoDao;
import com.lenjoy.dao.impl.MenuInfoDaoImpl;
import com.lenjoy.entity.MenuInfo;
import com.lenjoy.service.MenuInfoService;
import com.lenjoy.utils.SessionUtil;
import com.lenjoy.utils.TrendsSwitchUtil;

import java.util.IdentityHashMap;
import java.util.List;
import java.util.Scanner;

public class MenuInfoServiceImpl implements MenuInfoService {
    private MenuInfoDao menuInfoDao = new MenuInfoDaoImpl();
    private Scanner sc = new Scanner(System.in);

    @Override
    public void showMainMenu() {
        System.out.println("=========================乐享洛阳=======================");
        showMenu(-1);
        TrendsSwitchUtil.invokeMethod();
    }

    @Override
    public void showMenu(Integer pId) {
        List<MenuInfo> menuInfoList = menuInfoDao.getMenuInfoListBypId(pId);
        for (int i = 0; i < menuInfoList.size(); i++) {
            System.out.println(i + 1 + ":" + menuInfoList.get(i).getName());
        }
        System.out.println(pId == -1 ? "0|其他，退出系统" : "其他，返回上一级");
        String menuIdStr = sc.next();
        int menuId = 0;
        try {
            menuId = Integer.parseInt(menuIdStr);
        } catch (NumberFormatException e) {
            if (pId == -1) {
                System.out.println("系统正在退出");
                System.exit(0);
            } else {
                TrendsSwitchUtil.rollBackMethod();
            }
        }
        if (menuId > 0 && menuId < menuInfoList.size()) {
            SessionUtil.menuInfo = menuInfoList.get(menuId - 1);
        } else {
            if (pId == -1) {
                System.out.println("系统正在退出...");
                System.exit(0);
            } else {
                TrendsSwitchUtil.invokeMethod();
            }
        }

    }
}
