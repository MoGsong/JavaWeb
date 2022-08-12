package com.gxlq.service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxlq.dao.OperatorDAO;
import com.gxlq.entity.Operator;
import com.gxlq.service.IOperatorService;

/**
 * ??????????
 *
 * @author johny
 * ??????????ó?ò????????????????
 * ??????????????
 */
public class OperatorService implements IOperatorService {
    @Override
    public void add(Operator operator) {
        //???????????ò????
        OperatorDAO operatorDAO = new OperatorDAO();
        try {
            operatorDAO.add(operator);
        } catch (ClassNotFoundException | SQLException e) {
            // ???????????????
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        //???????????ò????
        OperatorDAO operatorDAO = new OperatorDAO();
        Operator operator = new Operator(); //{id=0}
        operator.setId(id);
        try {
            operatorDAO.delete(operator);
        } catch (ClassNotFoundException | SQLException e) {
            // ???????????????
            e.printStackTrace();
        }
    }

    @Override
    public void update(Operator operator) {
        //???????????ò????
        OperatorDAO operatorDAO = new OperatorDAO();
        try {
            operatorDAO.merge(operator);
        } catch (ClassNotFoundException | SQLException e) {
            // ???????????????
            e.printStackTrace();
        }
    }

    @Override
    public Operator find(int id) {
        //???????????ò????
        OperatorDAO operatorDAO = new OperatorDAO();
        Operator operator = new Operator(); //{id=0,name=null}
        try {
            operator = operatorDAO.findByPrimaryKey(id);
        } catch (ClassNotFoundException | SQLException e) {
            // ???????????????
            e.printStackTrace();
        }
        return operator;
    }

    @Override
    public List<Operator> find() {
        //???????????ò????
        OperatorDAO operatorDAO = new OperatorDAO();
        List<Operator> operators = new ArrayList<Operator>();
        try {
            operators = operatorDAO.findAll();
        } catch (ClassNotFoundException | SQLException e) {
            // ???????????????
            e.printStackTrace();
        }
        return operators;
    }

    @Override
    public Operator find(String username, String password) {
        OperatorDAO operatorDAO = new OperatorDAO();
        Operator op = new Operator(); //{name=null,id=0},???????????????id?????????????????
        List<Operator> operators = new ArrayList<Operator>();
        try {
            operators = operatorDAO.findAll();
            //???????????
            for (Operator operator : operators) {
                if (operator.getUsername().equalsIgnoreCase(username) && operator.getPassword().equals(password)) {
                    op = operator;
                    break;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            // ???????????????
            e.printStackTrace();
        }
        return op;
    }

}
