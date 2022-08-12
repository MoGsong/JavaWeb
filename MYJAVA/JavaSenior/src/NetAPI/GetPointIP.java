package NetAPI;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
/**
 * ����������ȡ��Ӧ�� IP ��ַ
 */
public class GetPointIP {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("������Ҫ��ѯIP��ַ��������");
        String dName = input.next();
        try {
            // ͨ��InetAddress��ľ�̬����������ָ��������IP��ַ����
            InetAddress assignIP = InetAddress.getByName(dName);
            // ��������Ͷ�Ӧ�� IP ��ַ
            System.out.println("������" + dName + " ��Ӧ��IP��ַΪ��" + assignIP.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } finally{
            input.close();
        }
    }
}