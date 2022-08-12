package NetAPI;

import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 * 获取本机 IP 地址
 */
public class GetIP {
    public static void main(String[] args) {
        try {
            // 通过InetAddress类的静态方法，返回本地主机对象
            InetAddress myIP = InetAddress.getLocalHost();
            // 通过InetAddress类的getHostAddress()方法获得IP地址字符串
            System.out.println(myIP.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
