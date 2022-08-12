package com.gxlq.service.imp;

import java.sql.SQLException;

import com.gxlq.dao.MenuDAO;
import com.gxlq.entity.Menu;
import com.gxlq.service.IMenuService;

/**
 * ????????
 *
 * @author johny
 * ??????????¨®?¨°????????????????
 * ??????????§Õ???
 */
public class MenuService implements IMenuService {
    @Override
    public void add(Menu menu) {
        //?????????¨°????
        MenuDAO menuDAO = new MenuDAO();
        try {
            menuDAO.add(menu);
        } catch (ClassNotFoundException | SQLException e) {
            // ?????????§Õ?????
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        //?????????¨°????
        MenuDAO menuDAO = new MenuDAO();
        Menu menu = new Menu(); //{id=0}
        menu.setId(id);
        try {
            menuDAO.delete(menu);
        } catch (ClassNotFoundException | SQLException e) {
            // ?????????§Õ?????
            e.printStackTrace();
        }
    }

    @Override
    public void update(Menu menu) {
        //?????????¨°????
        MenuDAO menuDAO = new MenuDAO();
        try {
            menuDAO.merge(menu);
        } catch (ClassNotFoundException | SQLException e) {
            // ?????????§Õ?????
            e.printStackTrace();
        }
    }

    @Override
    public Menu find(int id) {
        //?????????¨°????
        MenuDAO menuDAO = new MenuDAO();
        Menu menu = new Menu(); //{id=0,name=null}
        try {
            menu = menuDAO.findByPrimaryKey(id);
        } catch (ClassNotFoundException | SQLException e) {
            // ?????????§Õ?????
            e.printStackTrace();
        }
        return menu;
    }

    @Override
    public Menu[] find() {
        //?????????¨°????
        MenuDAO menuDAO = new MenuDAO();
        Menu[] menus = new Menu[1];
        try {
            menus = menuDAO.findAll();
        } catch (ClassNotFoundException | SQLException e) {
            // ?????????§Õ?????
            e.printStackTrace();
        }
        return menus;
    }

    @Override
    public Menu[] findByParent(int parent) {
        MenuDAO menuDAO = new MenuDAO();
        Menu[] menus = new Menu[1];
        try {
            menus = menuDAO.findAll(parent);
        } catch (ClassNotFoundException | SQLException e) {
            // ?????????§Õ?????
            e.printStackTrace();
        }
        return menus;
    }

}
