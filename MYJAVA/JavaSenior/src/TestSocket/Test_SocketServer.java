package TestSocket;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * �����ҷ�������
 */
public class Test_SocketServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8880);
            while (true) {
                Socket socket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // �ر� ServerSocket ����
            try {
                if(serverSocket != null){
                    serverSocket.close();
                }               
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
class ServerThread extends Thread {
    Socket socket;
    Scanner input = new Scanner(System.in);

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        DataInputStream dis = null;
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
            String str = null;

            while (true) {
                if ((str = dis.readUTF()) != null) {
                    if ("bye".equals(str)){
                        break;
                    }
                    System.out.println("�ͻ��˷��������ݣ�" + str);
                }

                // �������ͻ����˷�����Ӧ����
                System.out.println("������Ҫ��ͻ��˷��͵���Ϣ��");
                String msg = input.nextLine();
                dos.writeUTF(msg);
                System.out.println();
            }
            // ��Դ�ͷ�
            dis.close();
            dos.close();
            socket.close();
            input.close();
        } catch (EOFException e) {
            System.out.println("�ͻ���" + socket.getInetAddress().getHostAddress() + ":" + socket.getPort() + "�˳���");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}