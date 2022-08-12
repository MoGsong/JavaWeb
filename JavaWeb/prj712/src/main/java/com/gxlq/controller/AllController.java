package com.gxlq.controller;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import com.gxlq.entity.Operator;
import com.gxlq.view.UI;

/**
 * ???????
 *
 * @author Administrator
 */
public class AllController {
    public static void main(String[] args) throws UnsupportedEncodingException {
        UI.show1();
        UI.show2();
        Operator op = OperatorController.Login();
        do {
            //UI.show3();
            UI.show4(op);
            Scanner scan = new Scanner(System.in);
            System.out.println("请输入想要操作的菜单选项:");
            String input = scan.next();
            if ("添加菜单".equals(input)) {
                MenuController.addMenu();
            } else if ("删除菜单".equals(input)) {
                MenuController.deleteMenu();
            } else if ("修改菜单".equals(input)) {
                MenuController.updateMenu();
            } else if ("权限管理".equals(input)) {
                AuthorizationController.update();
            } else if ("退出".equals(input)) {
                scan.close();
                System.exit(0);
            } else {
                System.out.println("该功能还在建设中......");
            }
        } while (true);
    }

}
