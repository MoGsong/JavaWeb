package TestSocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
/**
 * �����ҿͻ���
 */
public class Test_SocketClient {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Socket socket = null;
        DataInputStream dis = null;
        DataOutputStream dos = null;
        String receive = null;
        try {
            // �����ṩ�� IP ��ַ�Ͷ˿ںţ����� Socket ����
            socket = new Socket("localhost", 888);

            while (true) {
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
                //�ͻ�����������˷�����������
                System.out.println("������Ҫ�����˷��͵���Ϣ�������ַ��� bye �����Ự����");
                String msg = input.nextLine();
                if ("bye".equals(msg)) {
                    System.out.println("���˳����죡");
                    break;
                }

                dos.writeUTF(msg);
                if ((receive = dis.readUTF()) != null){
                    System.out.println("\n����˷��������ݣ�" + receive);
                }
            }
            // ��Դ�ͷ�
            dis.close();
            dos.close();
            socket.close();
            input.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}