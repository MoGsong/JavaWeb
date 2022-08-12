package com.gxlq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxlq.entity.Menu;

/**
 * ??????CURD????
 *
 * @author johny
 * ??��???
 */
public class MenuDAO extends C3P0BaseDAO {
    /**
     * ?????
     *
     * @param menu ???????????????????��{id=1,name=???}
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void add(Menu menu) throws ClassNotFoundException, SQLException {
        //1?????????? 2??????rbac?????
        Connection conn = super.getConnection();
        //3?????????????????? java.sql.Connection,????????????????java.sql.PreparedStatement????????SQL???
        //????????????��???????��??1???????????????????????
        PreparedStatement pstmt =
                conn.prepareStatement("insert into menu(name,parent,url) values(?,?,?)");
        //?????��?????,???????????????
        pstmt.setString(1, menu.getName());
        pstmt.setInt(2, menu.getParent());
        pstmt.setString(3, menu.getUrl());
        //???SQL???,??????????mysql????
        pstmt.executeUpdate();
        //????????????
        super.closeConnection(conn);
    }

    /**
     * ?????
     *
     * @param menu ??????????????????��{id=3,name=????}
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void merge(Menu menu) throws ClassNotFoundException, SQLException {
        //1?????????? 2??????rbac?????
        Connection conn = super.getConnection();
        //3?????????????????? java.sql.Connection,????????????????java.sql.PreparedStatement????????SQL???
        //????????????��???????��??1???????????????????????
        PreparedStatement pstmt =
                conn.prepareStatement("update menu set name=?,parent=?,url=? where id=?");
        //?????��?????,???????????????
        pstmt.setInt(4, menu.getId());
        pstmt.setString(1, menu.getName());
        pstmt.setInt(2, menu.getParent());
        pstmt.setString(3, menu.getUrl());
        //???SQL???,??????????mysql????
        pstmt.executeUpdate();
        //????????????
        super.closeConnection(conn);
    }

    /**
     * ??????
     *
     * @param menu ??????????????????��{id=3,name=????}
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void delete(Menu menu) throws ClassNotFoundException, SQLException {
        //1?????????? 2??????rbacpro?????
        Connection conn = super.getConnection();
        //3?????????????????? java.sql.Connection,????????????????java.sql.PreparedStatement????????SQL???
        //????????????��???????��??1???????????????????????
        PreparedStatement pstmt =
                conn.prepareStatement("delete from menu where id=?");
        //?????��?????,???????????????
        pstmt.setInt(1, menu.getId());
        //???SQL???,??????????mysql????
        pstmt.executeUpdate();
        //????????????
        super.closeConnection(conn);
    }
    //??????

    /**
     * ??????????????
     *
     * @return ???????��????��?????????menu???????????????
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public List<Menu> findAll() throws ClassNotFoundException, SQLException {
        //????????
    	List<Menu> menus = new ArrayList<Menu>(); //???????????null
        int i = 0;
        //1?????????? 2??????rbac?????
        Connection conn = super.getConnection();
        //3?????????????????? java.sql.Connection,????????????????java.sql.PreparedStatement????????SQL???
        //????????????��???????��??1???????????????????????
        PreparedStatement pstmt = conn.prepareStatement("select * from menu");
        //4?????????????????java.sql.PreparedStatement???????????????????java.sql.ResultSet
        ResultSet rs = pstmt.executeQuery();

        //???????????????
        while (rs.next()) {
            //??????��???????��???????????????
				/*
				int id = rs.getInt("id");  //id???????? 
				String name = rs.getString("name"); //name????????
				Menu menu = new Menu(id, name); //??????????Menu??????
				menus[i] = menu;
				i++;
				*/

            menus.add(new Menu(rs.getInt("id"), rs.getString("name"), rs.getInt("parent"), rs.getString("url")));
        }
        //????????????
        super.closeConnection(conn);
        //????????
        return menus;
    }

    /**
     * ?????????�b??
     *
     * @return ???????��????��?????????menu???????????????
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Menu findByPrimaryKey(int ID) throws ClassNotFoundException, SQLException {
        Menu menu = new Menu();
        //1?????????? 2??????rbac?????
        Connection conn = super.getConnection();
        //3?????????????????? java.sql.Connection,????????????????java.sql.PreparedStatement????????SQL???
        //????????????��???????��??1???????????????????????
        PreparedStatement pstmt = conn.prepareStatement("select * from menu where id=?");
        //4?????????????????java.sql.PreparedStatement???????????????????java.sql.ResultSet
        pstmt.setInt(1, ID);
        ResultSet rs = pstmt.executeQuery();

        //?????????????????????????????????????????????????????��???
        if (rs.next()) {
            //??????��???????��???????????????
            int id = rs.getInt("id");  //id????????
            String name = rs.getString("name"); //name????????
            int parent = rs.getInt("parent");
            String url = rs.getString("url");
            menu = new Menu(id, name, parent, url); //??????????Menu??????
        }
        //????????????
        super.closeConnection(conn);
        //????????
        return menu;
    }

    //??????????��????????
    private int findTotal() throws ClassNotFoundException, SQLException {
        int total = 0;
        //1?????????? 2??????rbac?????
        Connection conn = super.getConnection();
        //3?????????????????? java.sql.Connection,????????????????java.sql.PreparedStatement????????SQL???
        //????????????��???????��??1???????????????????????
        PreparedStatement pstmt = conn.prepareStatement("select  count(*) from menu");
        //4?????????????????java.sql.PreparedStatement???????????????????java.sql.ResultSet
        ResultSet rs = pstmt.executeQuery();

        //???????????????
        if (rs.next()) {
            //??????��???????��???????????????
            total = rs.getInt(1);  // ???1???????????????? count(*)????????
        }
        //????????????
        super.closeConnection(conn);
        return total;
    }

    private int findTotal(int parent) throws ClassNotFoundException, SQLException {
        int total = 0;
        //1?????????? 2??????rbac?????
        Connection conn = super.getConnection();
        //3?????????????????? java.sql.Connection,????????????????java.sql.PreparedStatement????????SQL???
        //????????????��???????��??1???????????????????????
        PreparedStatement pstmt = conn.prepareStatement("select  count(*) from menu where parent=?");
        pstmt.setInt(1, parent);
        //4?????????????????java.sql.PreparedStatement???????????????????java.sql.ResultSet
        ResultSet rs = pstmt.executeQuery();

        //???????????????
        if (rs.next()) {
            //??????��???????��???????????????
            total = rs.getInt(1);  // ???1???????????????? count(*)????????
        }
        //????????????
        super.closeConnection(conn);
        return total;
    }

    public List<Menu> findAll(int parent) throws ClassNotFoundException, SQLException {
    	List<Menu> menus = new ArrayList<Menu>();; //???????????null
        //1?????????? 2??????rbac?????
        Connection conn = super.getConnection();
        //3?????????????????? java.sql.Connection,????????????????java.sql.PreparedStatement????????SQL???
        //????????????��???????��??1???????????????????????
        PreparedStatement pstmt = conn.prepareStatement("select * from menu where parent=?");
        pstmt.setInt(1, parent);
        //4?????????????????java.sql.PreparedStatement???????????????????java.sql.ResultSet
        ResultSet rs = pstmt.executeQuery();

        //???????????????
        while (rs.next()) {
            menus.add(new Menu(rs.getInt("id"), rs.getString("name"), rs.getInt("parent"), rs.getString("url")));
        }
        //????????????
        super.closeConnection(conn);
        //????????
        return menus;
    }

	public List<Menu> findAll(int currentPage, int pageSize) throws SQLException, ClassNotFoundException {
		List<Menu> menus = new ArrayList<Menu>(); //???????????null
        //1?????????? 2??????rbac?????
        Connection conn = super.getConnection();
        //3?????????????????? java.sql.Connection,????????????????java.sql.PreparedStatement????????SQL???
        //????????????��???????��??1???????????????????????
        PreparedStatement pstmt = conn.prepareStatement("select * from menu order by id limit ?,?");
        pstmt.setInt(1, (currentPage-1)*pageSize);
        pstmt.setInt(2, pageSize);
        //4?????????????????java.sql.PreparedStatement???????????????????java.sql.ResultSet
        ResultSet rs = pstmt.executeQuery();

        //???????????????
        while (rs.next()) {
            menus.add(new Menu(rs.getInt("id"), rs.getString("name"), rs.getInt("parent"), rs.getString("url")));
        }
        //????????????
        super.closeConnection(conn);
        //????????
        return menus;
	}

}
