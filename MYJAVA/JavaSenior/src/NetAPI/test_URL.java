package NetAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
/**
 * URL ���ʹ��
 */
public class test_URL {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("������Ҫ��λ��URL��ַ��");
        String url = input.next();
        System.out.print("������Ҫ��ʾ�ĸ�ҳ���ǩԪ�ص����ݣ�");
        String iStr = input.next();
        BufferedReader in = null;
        try {
            // ͨ�� url �ַ������� URL ����
            URL tURL = new URL(url);
            // ͨ�� IO ����ȡ��Ϣ
            InetAddress assignIP = InetAddress.getByName(url.replace("https://", ""));
            System.out.println("������" + url + " ��Ӧ��IP��ַΪ��" + assignIP.getHostAddress());
            in = new BufferedReader(new InputStreamReader(tURL.openStream()));
            String s;
            while((s = in.readLine()) != null){
                // ƥ��ָ���ı�ǩ����
                if(s.contains(iStr)){
                    System.out.println(s);
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            // ��Դ�ͷ�
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            input.close();
        }
    }
}