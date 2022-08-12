
package com.gxlq.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.gxlq.dao.AuthorizationDAO;
import com.gxlq.dao.BaseDAO;
import com.gxlq.dao.MenuDAO;
import com.gxlq.dao.OperatorDAO;
import com.gxlq.dao.RoleDAO;
import com.gxlq.entity.Authorization;
import com.gxlq.entity.Menu;
import com.gxlq.entity.Operator;
import com.gxlq.entity.Role;
import com.gxlq.service.imp.*;

/**
 * ??????
 *
 * @author johny
 */
public class Test {
    // ???????java??????????
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //????BaseDAO????
        BaseDAO baseDAO = new BaseDAO();
        if (baseDAO.getConnection() != null) {
            Connection conn = baseDAO.getConnection();
            System.out.println("????mysql???!");
            baseDAO.closeConnection(conn);
        }

//????
//		RoleDAO roleDAO = new RoleDAO();
//		Role[] roles = roleDAO.findAll();
//		Role role = new Role(3,"vip");
//		roleDAO.merge(role);
//		for(int i = 0; i < roles.length; i++) {  
//				System.out.println(roles[i]); 
//			}

//		MenuDAO menuDAO = new MenuDAO();
////		Menu menu = new Menu(5,"???",1,"https://www.hao123.com/");
////		menuDAO.merge(menu);
//		System.out.println(menuDAO.findByPrimaryKey(1).toString());
//		Menu[] menus = menuDAO.findAll();
//		for(int i = 0; i < menus.length; i++) {  
//				System.out.println(menus[i]); 
//			}
//		
//		OperatorDAO operatorDAO = new OperatorDAO();
//		Operator[] operators = operatorDAO.findAll();
//		for(int i = 0; i < operators.length; i++) {  
//				System.out.println(operators[i]); 
//			}

//		AuthorizationDAO authorizationDAO = new AuthorizationDAO();
//		Authorization[] authorizations = authorizationDAO.findAll();
//		authorizationDAO.add(new Authorization(roles[1],menus[0]));

        //?????????
        Role role = new Role(4, "SVIP");
        RoleService roleSercice = new RoleService();
        roleSercice.add(role);

    }

}
