package com.lenjoy.controller;

import com.lenjoy.service.MenuInfoService;
import com.lenjoy.service.impl.MenuInfoServiceImpl;

public class MenuInfoController {
   private MenuInfoService menuInfoService=new MenuInfoServiceImpl();
public void showMainMenu(){
menuInfoService.showMainMenu();
}

}
