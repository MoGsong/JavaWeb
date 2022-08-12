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
 * 先在数据库创建一个存储图片文件的表,sql代码如下
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
    //使用jdbc把一个图片文件存放到数据库表中
    public void test() throws ClassNotFoundException, SQLException, FileNotFoundException {
        //加载驱动，创建连接对象
        Connection conn = super.getConnection();
        //创建数据库操作对象 PreparedStatement
        PreparedStatement  pstmt =
                conn.prepareStatement("insert into  pic (name,img) values(?,?)");
        pstmt.setString(1,"null");
        //基于电脑上某个图片创建一个字节输入流对象
        FileInputStream is = new FileInputStream("C:\\Users\\johny\\Desktop\\images\\wyb.jpg");
        BufferedInputStream bis = new BufferedInputStream(is);

        pstmt.setBlob(2,bis);
        pstmt.executeUpdate(); //执行sql
        //关闭连接
        super.closeConnection(conn);
    }

    //查询xxx表中的记录，并把blob字段上的数据获取
    public void test2() throws ClassNotFoundException, SQLException, IOException {
        //加载驱动，创建连接对象
        Connection conn = super.getConnection();
        //创建数据库操作对象 PreparedStatement
        PreparedStatement  pstmt =  conn.prepareStatement("select * from pic");
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()) {
            System.out.println(rs.getInt("id"));
            System.out.println(rs.getString("name"));
            Blob blob = rs.getBlob("img"); //把blob字段上的数据，保存到 电脑上 d://yyy.jpg

            InputStream is = blob.getBinaryStream(); //把图片从数据库表中读取到 内存
            BufferedInputStream bis = new BufferedInputStream(is);
            FileOutputStream os = new FileOutputStream("d:\\yyy.jpg");//把图片从内存写到 d盘
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
        //关闭连接
        super.closeConnection(conn);
    }
}
