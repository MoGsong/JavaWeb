package NetAPI;

import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 * ��ȡ���� IP ��ַ
 */
public class GetIP {
    public static void main(String[] args) {
        try {
            // ͨ��InetAddress��ľ�̬���������ر�����������
            InetAddress myIP = InetAddress.getLocalHost();
            // ͨ��InetAddress���getHostAddress()�������IP��ַ�ַ���
            System.out.println(myIP.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
