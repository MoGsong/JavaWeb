package TestSocket;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 聊天室服务器端
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
            // 关闭 ServerSocket 对象
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
                    System.out.println("客户端发来的内容：" + str);
                }

                // 服务端向客户器端发送响应内容
                System.out.println("请输入要向客户端发送的信息：");
                String msg = input.nextLine();
                dos.writeUTF(msg);
                System.out.println();
            }
            // 资源释放
            dis.close();
            dos.close();
            socket.close();
            input.close();
        } catch (EOFException e) {
            System.out.println("客户端" + socket.getInetAddress().getHostAddress() + ":" + socket.getPort() + "退出！");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}