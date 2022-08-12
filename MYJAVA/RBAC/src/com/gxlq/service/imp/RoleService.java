package com.gxlq.service.imp;

import java.sql.SQLException;

import com.gxlq.dao.RoleDAO;
import com.gxlq.entity.Role;
import com.gxlq.service.IRoleService;

/**
 * ????????
 *
 * @author johny
 * ??????????¨®?¨°????????????????
 * ??????????§Õ???
 */
public class RoleService implements IRoleService {
    @Override
    public void add(Role role) {
        //?????????¨°????
        RoleDAO roleDAO = new RoleDAO();
        try {
            roleDAO.add(role);
        } catch (ClassNotFoundException | SQLException e) {
            // ?????????§Õ?????
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        //?????????¨°????
        RoleDAO roleDAO = new RoleDAO();
        Role role = new Role(); //{id=0}
        role.setId(id);
        try {
            roleDAO.delete(role);
        } catch (ClassNotFoundException | SQLException e) {
            // ?????????§Õ?????
            e.printStackTrace();
        }
    }

    @Override
    public void update(Role role) {
        //?????????¨°????
        RoleDAO roleDAO = new RoleDAO();
        try {
            roleDAO.merge(role);
        } catch (ClassNotFoundException | SQLException e) {
            // ?????????§Õ?????
            e.printStackTrace();
        }
    }

    @Override
    public Role find(int id) {
        //?????????¨°????
        RoleDAO roleDAO = new RoleDAO();
        Role role = new Role(); //{id=0,name=null}
        try {
            role = roleDAO.findByPrimaryKey(id);
        } catch (ClassNotFoundException | SQLException e) {
            // ?????????§Õ?????
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public Role[] find() {
        //?????????¨°????
        RoleDAO roleDAO = new RoleDAO();
        Role[] roles = new Role[1];
        try {
            roles = roleDAO.findAll();
        } catch (ClassNotFoundException | SQLException e) {
            // ?????????§Õ?????
            e.printStackTrace();
        }
        return roles;
    }

}
