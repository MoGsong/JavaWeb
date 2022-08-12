package com.gxlq.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0BaseDAO {

	    public Connection getConnection() throws ClassNotFoundException, SQLException {
	    	Connection conn = null;
	    	try {
				ComboPooledDataSource dateSource = new ComboPooledDataSource();
				conn = dateSource.getConnection();
			} catch (Exception e) {
				// TODO: handle exception
			}
			return conn;
	    }

	    public void closeConnection(Connection conn) throws SQLException {
	        if (conn != null) {
	            conn.close();
	        }
	    }
}

