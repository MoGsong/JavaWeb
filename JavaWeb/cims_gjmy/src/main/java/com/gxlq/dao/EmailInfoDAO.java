package com.gxlq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.gxlq.entity.EmailInfo;

/**
* ??????CURD????
*
* @author johny
* ??????
*/
public class EmailInfoDAO extends C3P0BaseDAO {
  /**
   * ?????
   *
   * @param emailInfo ????????????????????{id=1,name=???}
   * @throws SQLException
   * @throws ClassNotFoundException
   */
  public void add(EmailInfo emailInfo) throws ClassNotFoundException, SQLException {
      //1?????????? 2??????rbac?????
      Connection conn = super.getConnection();
      //3?????????????????? java.sql.Connection,????????????????java.sql.PreparedStatement????????SQL???
      //???????????????????????1???????????????????????
      PreparedStatement pstmt =
              conn.prepareStatement("insert into emailinfo(receivenumber,sendtime,emailaddress,content) values(?,?,?,?)");
      //???????????,???????????????
      pstmt.setString(1, emailInfo.getReceivenumber());
      pstmt.setTimestamp(2, emailInfo.getSendtime());
      pstmt.setString(3, emailInfo.getEmailaddress());
      pstmt.setString(4, emailInfo.getContent());
      //???SQL???,??????????mysql????
      pstmt.executeUpdate();
      //????????????
      super.closeConnection(conn);
  }

  /**
   * ?????
   *
   * @param emailInfo ???????????????????{id=3,name=????}
   * @return
   * @throws SQLException
   * @throws ClassNotFoundException
   */

  public void merge(EmailInfo emailInfo) throws ClassNotFoundException, SQLException {
      //1?????????? 2??????rbac?????
      Connection conn = super.getConnection();
      //3?????????????????? java.sql.Connection,????????????????java.sql.PreparedStatement????????SQL???
      //???????????????????????1???????????????????????
      PreparedStatement pstmt =
              conn.prepareStatement("update emailinfo set receivenumber=?,sendtime=?,emailaddress=?,content=? where id=?");
      //???????????,???????????????
      pstmt.setString(1, emailInfo.getReceivenumber());
      pstmt.setTimestamp(2, emailInfo.getSendtime());
      pstmt.setString(3, emailInfo.getEmailaddress());
      pstmt.setString(4, emailInfo.getContent());
      pstmt.setInt(5, emailInfo.getId());
      //???SQL???,??????????mysql????
      pstmt.executeUpdate();
      //????????????
      super.closeConnection(conn);
  }

  /**
   * ??????
   *
   * @param emailInfo ???????????????????{id=3,name=????}
   * @throws SQLException
   * @throws ClassNotFoundException
   */
  public void delete(EmailInfo emailInfo) throws ClassNotFoundException, SQLException {
      //1?????????? 2??????rbac?????
      Connection conn = super.getConnection();
      //3?????????????????? java.sql.Connection,????????????????java.sql.PreparedStatement????????SQL???
      //???????????????????????1???????????????????????
      PreparedStatement pstmt =
              conn.prepareStatement("delete from emailinfo where id=?");
      //???????????,???????????????
      pstmt.setInt(1, emailInfo.getId());
      //???SQL???,??????????mysql????
      pstmt.executeUpdate();
      //????????????
      super.closeConnection(conn);
  }
  //??????

  /**
   * ??????????????
   *
   * @return ??????????????????????emailInfo???????????????
   * @throws ClassNotFoundException
   * @throws SQLException
   */
  public List<EmailInfo> findAll() throws ClassNotFoundException, SQLException {
      //????????
      List<EmailInfo> emailInfos = new ArrayList<EmailInfo>(); //???????????null
      int i = 0;
      Connection conn = super.getConnection();
      //3?????????????????? java.sql.Connection,????????????????java.sql.PreparedStatement????????SQL???
      //???????????????????????1???????????????????????
      PreparedStatement pstmt = conn.prepareStatement("select * from emailinfo");
      //4?????????????????java.sql.PreparedStatement???????????????????java.sql.ResultSet
      ResultSet rs = pstmt.executeQuery();

      //???????????????
      while (rs.next()) {
          //??????????????????????????????
			/*
			int id = rs.getInt("id");  //id???????? 
			String name = rs.getString("name"); //name????????
			EmailInfo emailInfo = new EmailInfo(id, name); //??????????EmailInfo??????
			emailInfos[i] = emailInfo;
			i++;
			*/

          emailInfos.add(new EmailInfo(rs.getInt("id"), rs.getString("receivenumber"),  
        		  rs.getTimestamp("sendtime"),  rs.getString("emailaddress"),  rs.getString("content")));
      }
      //????????????
      super.closeConnection(conn);
      //????????
      return emailInfos;
  }

  /**
   * ????????????
   *
   * @return ??????????????????????emailInfo???????????????
   * @throws ClassNotFoundException
   * @throws SQLException
   */
  public EmailInfo findByPrimaryKey(int ID) throws ClassNotFoundException, SQLException {
      EmailInfo emailInfo = new EmailInfo();
      //1?????????? 2??????rbac?????
      Connection conn = super.getConnection();
      //3?????????????????? java.sql.Connection,????????????????java.sql.PreparedStatement????????SQL???
      //???????????????????????1???????????????????????
      PreparedStatement pstmt = conn.prepareStatement("select * from emailinfo where id=?");
      //4?????????????????java.sql.PreparedStatement???????????????????java.sql.ResultSet
      pstmt.setInt(1, ID);
      ResultSet rs = pstmt.executeQuery();

      //?????????????????????????????????????????????????????????
      if (rs.next()) {
          //??????????????????????????????
          int id = rs.getInt("id");  //id????????
          String  receivenumber = rs.getString("receivenumber"); 
          String  sendtime = rs.getString("sendtime"); 
          String  emailaddress = rs.getString("emailaddress"); 
          String  content = rs.getString("content"); 
          emailInfo = new EmailInfo(id, receivenumber, Timestamp.valueOf(sendtime), emailaddress, content); //??????????EmailInfo??????
      }
      //????????????
      super.closeConnection(conn);
      //????????
      return emailInfo;
  }

  //???????????????????
  @SuppressWarnings("unused")
private int findTotal() throws ClassNotFoundException, SQLException {
      int total = 0;
      //1?????????? 2??????rbac?????
      Connection conn = super.getConnection();
      //3?????????????????? java.sql.Connection,????????????????java.sql.PreparedStatement????????SQL???
      //???????????????????????1???????????????????????
      PreparedStatement pstmt = conn.prepareStatement("select  count(*) from emailinfo");
      //4?????????????????java.sql.PreparedStatement???????????????????java.sql.ResultSet
      ResultSet rs = pstmt.executeQuery();

      //???????????????
      if (rs.next()) {
          //??????????????????????????????
          total = rs.getInt(1);  // ???1???????????????? count(*)????????
      }
      //????????????
      super.closeConnection(conn);
      return total;
  }

public List<EmailInfo> findAll(int currentPage, int pageSize) throws ClassNotFoundException, SQLException {
	    List<EmailInfo> emailInfos = new ArrayList<EmailInfo>(); 
	    Connection conn = super.getConnection();
	    PreparedStatement pstmt = conn.prepareStatement("select * from emailinfo order by id limit ?,?");
	    pstmt.setInt(1, (currentPage-1)*pageSize);
	    pstmt.setInt(2, pageSize);
	    ResultSet rs = pstmt.executeQuery();

	    while (rs.next()) {
	        emailInfos.add(new EmailInfo(rs.getInt("id"), rs.getString("receivenumber"),  
	      		  rs.getTimestamp("sendtime"),  rs.getString("emailaddress"),  rs.getString("content")));
	    }
	    super.closeConnection(conn);
	    return emailInfos;
	}

}
