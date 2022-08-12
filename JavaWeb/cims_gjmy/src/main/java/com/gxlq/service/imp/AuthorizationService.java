package com.gxlq.service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxlq.dao.AuthorizationDAO;
import com.gxlq.entity.Authorization;
import com.gxlq.service.IAuthorizationService;

/**
 * ????????
 *
 * @author johny
 * ??????????��?��????????????????
 * ??????????��???
 */
public class AuthorizationService implements IAuthorizationService {
    @Override
    public void add(Authorization authorization) {
        //????????��????
        AuthorizationDAO authorizationDAO = new AuthorizationDAO();
        try {
            authorizationDAO.add(authorization);
        } catch (ClassNotFoundException | SQLException e) {
            // ?????????��?????
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        //????????��????
        AuthorizationDAO authorizationDAO = new AuthorizationDAO();
        Authorization authorization = new Authorization(); //{id=0}
        authorization.setId(id);
        try {
            authorizationDAO.delete(authorization);
        } catch (ClassNotFoundException | SQLException e) {
            // ?????????��?????
            e.printStackTrace();
        }
    }

    @Override
    public void update(Authorization authorization) {
        //????????��????
        AuthorizationDAO authorizationDAO = new AuthorizationDAO();
        try {
            authorizationDAO.merge(authorization);
        } catch (ClassNotFoundException | SQLException e) {
            // ?????????��?????
            e.printStackTrace();
        }
    }

    @Override
    public Authorization find(int id) {
        //????????��????
        AuthorizationDAO authorizationDAO = new AuthorizationDAO();
        Authorization authorization = new Authorization(); //{id=0,name=null}
        try {
            authorization = authorizationDAO.findByPrimaryKey(id);
        } catch (ClassNotFoundException | SQLException e) {
            // ?????????��?????
            e.printStackTrace();
        }
        return authorization;
    }

    @Override
    public List<Authorization> find() {
        //????????��????
        AuthorizationDAO authorizationDAO = new AuthorizationDAO();
        List<Authorization> authorizations = new ArrayList<Authorization>();
        try {
            authorizations = authorizationDAO.findAll();
        } catch (ClassNotFoundException | SQLException e) {
            // ?????????��?????
            e.printStackTrace();
        }
        return authorizations;
    }


    @Override
    public List<Authorization> findByRole(int roleId) {
        AuthorizationDAO authorizationDAO = new AuthorizationDAO();
        List<Authorization> authorizations = new ArrayList<Authorization>();
        try {
            authorizations = authorizationDAO.findAll(roleId);
        } catch (ClassNotFoundException | SQLException e) {
            // ?????????��?????
            e.printStackTrace();
        }
        return authorizations;
    }
}
