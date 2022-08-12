package com.gxlq.test;

import java.sql.SQLException;
import java.util.List;

import com.gxlq.entity.Authorization;
import com.gxlq.entity.Menu;
import com.gxlq.entity.Role;
import com.gxlq.service.IAuthorizationService;
import com.gxlq.service.IMenuService;
import com.gxlq.service.IOperatorService;
import com.gxlq.service.imp.AuthorizationService;
import com.gxlq.service.imp.MenuService;
import com.gxlq.service.imp.OperatorService;

public class Test {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
       //IOperatorService ios = OperatorService();
    	IAuthorizationService ias = new AuthorizationService();
    	Role role = new Role();
		role.setId(1);
		Menu menu = new Menu();
		menu.setId(9);
		Authorization au = new Authorization(role,menu);
		ias.add(au);
		System.out.println("已添加"+au.toString());
    }

}
