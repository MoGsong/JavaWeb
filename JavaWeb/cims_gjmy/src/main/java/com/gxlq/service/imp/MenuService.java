package com.gxlq.service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxlq.dao.MenuDAO;
import com.gxlq.entity.Menu;
import com.gxlq.service.IMenuService;

/**
 * ????????
 *
 * @author johny
 * ??????????��?��????????????????
 * ??????????��???
 */
public class MenuService implements IMenuService {
    @Override
    public void add(Menu menu) {
        //?????????��????
        MenuDAO menuDAO = new MenuDAO();
        try {
            menuDAO.add(menu);
        } catch (ClassNotFoundException | SQLException e) {
            // ?????????��?????
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        //?????????��????
        MenuDAO menuDAO = new MenuDAO();
        Menu menu = new Menu(); //{id=0}
        menu.setId(id);
        try {
            menuDAO.delete(menu);
        } catch (ClassNotFoundException | SQLException e) {
            // ?????????��?????
            e.printStackTrace();
        }
    }

    @Override
    public void update(Menu menu) {
        //?????????��????
        MenuDAO menuDAO = new MenuDAO();
        try {
            menuDAO.merge(menu);
        } catch (ClassNotFoundException | SQLException e) {
            // ?????????��?????
            e.printStackTrace();
        }
    }


    @Override
    public List<Menu> find() {
        //?????????��????
        MenuDAO menuDAO = new MenuDAO();
        List<Menu> menus = new ArrayList<Menu>();
        try {
            menus = menuDAO.findAll();
        } catch (ClassNotFoundException | SQLException e) {
            // ?????????��?????
            e.printStackTrace();
        }
        return menus;
    }

    @Override
    public List<Menu> findByParent(int parent) {
        MenuDAO menuDAO = new MenuDAO();
        List<Menu> menus = new ArrayList<Menu>();
        try {
            menus = menuDAO.findAll(parent);
        } catch (ClassNotFoundException | SQLException e) {
            // ?????????��?????
            e.printStackTrace();
        }
        return menus;
    }

	@Override
	public List<Menu> find(int currentPage, int pageSize) {
		MenuDAO menuDAO = new MenuDAO();
        List<Menu> menus = new ArrayList<Menu>();
        try {
            menus = menuDAO.findAll(currentPage, pageSize);
        } catch (ClassNotFoundException | SQLException e) {
            // ?????????��?????
            e.printStackTrace();
        }
        return menus;
	}

	@Override
	public Menu find(int id) {
		 MenuDAO menuDAO = new MenuDAO();
	        Menu menus = new Menu();
	        try {
	            menus = menuDAO.findByPrimaryKey(id);
	        } catch (ClassNotFoundException | SQLException e) {
	            // ?????????��?????
	            e.printStackTrace();
	        }
	        return menus;
	}

}
