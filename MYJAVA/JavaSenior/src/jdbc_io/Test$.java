package jdbc_io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.gxlq.dao.BaseDAO;

/**
 * �������ݿⴴ��һ���洢ͼƬ�ļ��ı�,sql��������
 * delimiter $
 * create pic(
 *     id int primary key auto_increment,
 *     name varchar(100),
 *     img BLOB
 * )
 * end;
 * $
 * delimiter ;
 */
public class Test$ extends BaseDAO {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        //new Test$$().test();
        new Test$().test2();
    }
    //ʹ��jdbc��һ��ͼƬ�ļ���ŵ����ݿ����
    public void test() throws ClassNotFoundException, SQLException, FileNotFoundException {
        //�����������������Ӷ���
        Connection conn = super.getConnection();
        //�������ݿ�������� PreparedStatement
        PreparedStatement  pstmt =
                conn.prepareStatement("insert into  pic (name,img) values(?,?)");
        pstmt.setString(1,"null");
        //���ڵ�����ĳ��ͼƬ����һ���ֽ�����������
        FileInputStream is = new FileInputStream("C:\\Users\\johny\\Desktop\\images\\wyb.jpg");
        BufferedInputStream bis = new BufferedInputStream(is);

        pstmt.setBlob(2,bis);
        pstmt.executeUpdate(); //ִ��sql
        //�ر�����
        super.closeConnection(conn);
    }

    //��ѯxxx���еļ�¼������blob�ֶ��ϵ����ݻ�ȡ
    public void test2() throws ClassNotFoundException, SQLException, IOException {
        //�����������������Ӷ���
        Connection conn = super.getConnection();
        //�������ݿ�������� PreparedStatement
        PreparedStatement  pstmt =  conn.prepareStatement("select * from pic");
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()) {
            System.out.println(rs.getInt("id"));
            System.out.println(rs.getString("name"));
            Blob blob = rs.getBlob("img"); //��blob�ֶ��ϵ����ݣ����浽 ������ d://yyy.jpg

            InputStream is = blob.getBinaryStream(); //��ͼƬ�����ݿ���ж�ȡ�� �ڴ�
            BufferedInputStream bis = new BufferedInputStream(is);
            FileOutputStream os = new FileOutputStream("d:\\yyy.jpg");//��ͼƬ���ڴ�д�� d��
            BufferedOutputStream bos = new BufferedOutputStream(os);
            int data;
            while ((data=bis.read())!=-1) {
                bos.write(data);
            }
            bos.close();
            os.close();
            bis.close();
            is.close();
        }
        //�ر�����
        super.closeConnection(conn);
    }
}
