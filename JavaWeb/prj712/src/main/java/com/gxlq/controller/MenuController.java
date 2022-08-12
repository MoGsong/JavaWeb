package com.gxlq.controller;

import java.util.Scanner;

import com.gxlq.entity.Menu;
import com.gxlq.service.IMenuService;
import com.gxlq.service.imp.MenuService;

/**
 * ??????????ò????????
 *
 * @author Administrator
 */

public class MenuController {
    //?????
    public static void addMenu() {
        IMenuService ims = new MenuService();
        //???????????в??
        Menu[] fathers = ims.find();
        StringBuffer msg = new StringBuffer();
        for (Menu father : fathers) {
            msg.append(father.getId() + "、" + father.getName() + "\t");
        }
        System.out.println(msg);
        //??????????????
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入添加的菜单编号(0是父菜单):");
        int parent = sc.nextInt();

        System.out.println("请输入新添加的菜单名:");
        String name = sc.next();

        System.out.println("请输入新添加的菜单的url:");
        String url = sc.next();

        Menu menu = new Menu(name, parent, url);
        ims.add(menu);
        System.out.println("添加菜单成功");
    }

    //??????
    public static void deleteMenu() {
        IMenuService ims;
        ims = new MenuService();
        //???????????в??
        Menu[] fathers;
        fathers = ims.find();
        StringBuffer msg = new StringBuffer();
        for (Menu father : fathers) {
            msg.append(father.getId() + "、" + father.getName() + "\t");
        }
        System.out.println(msg);
        //??????????
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入想要删除的菜单编号:");
        int id = sc.nextInt();
        ims.remove(id);
        System.out.println("删除成功");

    }

    //?????
    public static void updateMenu() {
        IMenuService ims = new MenuService();
        //???????????в??
        Menu[] fathers = ims.find();
        StringBuffer msg = new StringBuffer();
        for (Menu father : fathers) {
            msg.append(father.getId() + "、" + father.getName() + "\t");
        }
        System.out.println(msg);
        //??????????????
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入修改的菜单编号:");
        int id = sc.nextInt();

        System.out.println("修改后的父菜单编号:");
        int parent = sc.nextInt();

        System.out.println("修改后的菜单名:");
        String name = sc.next();

        System.out.println("修改后的菜单url:");
        String url = sc.next();

        Menu menu = new Menu(id, name, parent, url);
        ims.update(menu);
        System.out.println("修改成功");
    }
}
