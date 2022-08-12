package com.gxlq.service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxlq.dao.EmailInfoDAO;
import com.gxlq.dao.RoleDAO;
import com.gxlq.entity.EmailInfo;
import com.gxlq.entity.Role;
import com.gxlq.service.IRoleService;

/**
 * ????????
 *
 * @author johny
 * ??????????��?��????????????????
 * ??????????��???
 */
public class RoleService implements IRoleService {
    @Override
    public void add(Role role) {
        //?????????��????
        RoleDAO roleDAO = new RoleDAO();
        try {
            roleDAO.add(role);
        } catch (ClassNotFoundException | SQLException e) {
            // ?????????��?????
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        //?????????��????
        RoleDAO roleDAO = new RoleDAO();
        Role role = new Role(); //{id=0}
        role.setId(id);
        try {
            roleDAO.delete(role);
        } catch (ClassNotFoundException | SQLException e) {
            // ?????????��?????
            e.printStackTrace();
        }
    }

    @Override
    public void update(Role role) {
        //?????????��????
        RoleDAO roleDAO = new RoleDAO();
        try {
            roleDAO.merge(role);
        } catch (ClassNotFoundException | SQLException e) {
            // ?????????��?????
            e.printStackTrace();
        }
    }

    @Override
    public Role find(int id) {
        //?????????��????
        RoleDAO roleDAO = new RoleDAO();
        Role role = new Role(); //{id=0,name=null}
        try {
            role = roleDAO.findByPrimaryKey(id);
        } catch (ClassNotFoundException | SQLException e) {
            // ?????????��?????
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public List<Role> find() {
        //?????????��????
        RoleDAO roleDAO = new RoleDAO();
        List<Role> roles = new ArrayList<Role>();
        try {
            roles = roleDAO.findAll();
        } catch (ClassNotFoundException | SQLException e) {
            // ?????????��?????
            e.printStackTrace();
        }
        return roles;
    }

	@Override
	//分页查找
	public List<Role> find(int currentPage, int pageSize) {
		RoleDAO roleDAO = new RoleDAO();
	        List<Role> roles = new ArrayList<Role>();
	        try {
	            roles = roleDAO.findAll(currentPage, pageSize);
	        } catch (ClassNotFoundException | SQLException e) {
	            // ?????????��?????
	            e.printStackTrace();
	        }
	        return roles;
	}
}

