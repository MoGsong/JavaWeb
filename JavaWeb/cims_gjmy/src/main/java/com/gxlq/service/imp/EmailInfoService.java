package com.gxlq.service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxlq.dao.EmailInfoDAO;
import com.gxlq.entity.EmailInfo;
import com.gxlq.service.IEmailInfoService;

/**
 * ????????
 *
 * @author johny
 * ??????????��?��????????????????
 * ??????????��???
 */
public class EmailInfoService implements IEmailInfoService {
    @Override
    public void add(EmailInfo emailInfo) {
        //?????????��????
        EmailInfoDAO emailInfoDAO = new EmailInfoDAO();
        try {
            emailInfoDAO.add(emailInfo);
        } catch (ClassNotFoundException | SQLException e) {
            // ?????????��?????
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        //?????????��????
        EmailInfoDAO emailInfoDAO = new EmailInfoDAO();
        EmailInfo emailInfo = new EmailInfo(); //{id=0}
        emailInfo.setId(id);
        try {
            emailInfoDAO.delete(emailInfo);
        } catch (ClassNotFoundException | SQLException e) {
            // ?????????��?????
            e.printStackTrace();
        }
    }

    @Override
    public void update(EmailInfo emailInfo) {
        //?????????��????
        EmailInfoDAO emailInfoDAO = new EmailInfoDAO();
        try {
            emailInfoDAO.merge(emailInfo);
        } catch (ClassNotFoundException | SQLException e) {
            // ?????????��?????
            e.printStackTrace();
        }
    }

    @Override
    public EmailInfo find(int id) {
        //?????????��????
        EmailInfoDAO emailInfoDAO = new EmailInfoDAO();
        EmailInfo emailInfo = new EmailInfo(); //{id=0,name=null}
        try {
            emailInfo = emailInfoDAO.findByPrimaryKey(id);
        } catch (ClassNotFoundException | SQLException e) {
            // ?????????��?????
            e.printStackTrace();
        }
        return emailInfo;
    }

    @Override
    public List<EmailInfo> find() {
        //?????????��????
        EmailInfoDAO emailInfoDAO = new EmailInfoDAO();
        List<EmailInfo> emailInfos = new ArrayList<EmailInfo>();
        try {
            emailInfos = emailInfoDAO.findAll();
        } catch (ClassNotFoundException | SQLException e) {
            // ?????????��?????
            e.printStackTrace();
        }
        return emailInfos;
    }

	@Override
	public List<EmailInfo> find(int currentPage, int pageSize) {
		 EmailInfoDAO emailInfoDAO = new EmailInfoDAO();
	        List<EmailInfo> emailInfos = new ArrayList<EmailInfo>();
	        try {
	            emailInfos = emailInfoDAO.findAll(currentPage, pageSize);
	        } catch (ClassNotFoundException | SQLException e) {
	            // ?????????��?????
	            e.printStackTrace();
	        }
	        return emailInfos;
	}

}
