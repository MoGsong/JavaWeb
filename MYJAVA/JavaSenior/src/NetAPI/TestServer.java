package NetAPI;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ��������
 */
public class TestServer {
    public static void main(String[] args) {   
        ServerSocket server = null; 
        try {
            // ����һ��ServerSocket���󣬲�ָ���˿ں�Ϊ8888
            server = new ServerSocket(8888);
            // ���������ܵ����׽��ֵ�����
            while(true){
                Socket s = server.accept();
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                dos.writeUTF("�ͻ���IP��" + s.getInetAddress().getHostAddress()
    + "�ͻ��˶˿ںţ�" + s.getPort());
                // �ر�����������
                dos.close();
                  // �ر� Socket ����
                s.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(server != null){
                try {
                      // �ر� ServerSocket ����
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}