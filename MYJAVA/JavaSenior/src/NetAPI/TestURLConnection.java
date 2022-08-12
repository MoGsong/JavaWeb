package NetAPI;

 import java.io.IOException;
 import java.io.InputStream;
 import java.net.HttpURLConnection;
 import java.net.MalformedURLException;
 import java.net.URL;
 import java.net.URLConnection;;
 /**
  * URLConnection ���ʹ��
  */
 public class TestURLConnection {
     public static void main(String[] args) {
         try {
             // ��1��ͨ����URL�ϵ���openConnection()�����������Ӷ���
             URL url = new URL("https://www.lanqiao.cn/");
             // ����URL��ȡURLConnection����
             URLConnection urlC = url.openConnection();
             // ����Э����HTTPЭ�飬�ʿ�ת��ΪHttpURLConnection����
             HttpURLConnection hUrlC = (HttpURLConnection)urlC;
             // ��2�����ò�����һ����������
             // ���󷽷������POST������Ҫ���������������Ҫ��hUrlC�������
             hUrlC.setDoOutput(true);
             // �����Ƿ��httpUrlConnection���룬Ĭ���������true
             hUrlC.setDoInput(true);
             // ���󷽷������POST������ʹ�û���
             hUrlC.setUseCaches(false);
             // ����Content-Type����
             hUrlC.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
             // �趨����ķ���ΪPOST��Ĭ����GET
             hUrlC.setRequestMethod("POST");
             // ��3��ʹ��connect����������Զ�̶����ʵ������
             hUrlC.connect();
             // ��4��Զ�̶����Ϊ����
             // ͨ��HttpURLConnection��ȡ������������ɸ��������һ������
             InputStream inStrm = hUrlC.getInputStream();
             // �ж������Ƿ�ɹ�
             if(hUrlC.getResponseCode() == 200){
                 System.out.println(inStrm.toString());
             }else{
                 System.out.println("POST����ʧ��");
             }
             // �ر�����
             hUrlC.disconnect();
         } catch (MalformedURLException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
 }