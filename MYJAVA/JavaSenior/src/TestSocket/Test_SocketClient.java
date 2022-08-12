package TestSocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
/**
 * 聊天室客户端
 */
public class Test_SocketClient {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Socket socket = null;
        DataInputStream dis = null;
        DataOutputStream dos = null;
        String receive = null;
        try {
            // 根据提供的 IP 地址和端口号，创建 Socket 对象
            socket = new Socket("localhost", 888);

            while (true) {
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
                //客户端向服务器端发送请求内容
                System.out.println("请输入要向服务端发送的信息（输入字符串 bye 结束会话）：");
                String msg = input.nextLine();
                if ("bye".equals(msg)) {
                    System.out.println("已退出聊天！");
                    break;
                }

                dos.writeUTF(msg);
                if ((receive = dis.readUTF()) != null){
                    System.out.println("\n服务端发来的内容：" + receive);
                }
            }
            // 资源释放
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