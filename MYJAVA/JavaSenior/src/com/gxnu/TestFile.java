package com.gxnu;

import java.io.File;
import java.io.IOException;
/**
 * File ���еķ���ʹ��
 */
public class TestFile {
    public static void main(String args[]) {
        System.out.print("�ļ�ϵͳ��Ŀ¼");
        for (File root : File.listRoots()) {
            //format�����Ը�ʽ����ʽ����ַ���
            System.out.format("%s ", root);
        }
        System.out.println();
        try {
            showFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showFile() throws IOException{
        //����File�����file��ע��ʹ��ת���ַ� `\`
        File f = new File("/home/project/Vehicle.java");
        File f1 = new File("/home/project/Vehicle1.java");

        //�������ڸ��ļ�ʱ������һ���µĿ��ļ�
        f1.createNewFile();
        System.out.format("����ַ�����%s%n", f);
        System.out.format("�ж�File������Ƿ���ڣ�%b%n", f.exists());
        //%tc��������ں�ʱ��
        System.out.format("��ȡFile���������޸�ʱ�䣺%tc%n", f.lastModified());
        System.out.format("�ж�File������Ƿ����ļ���%b%n", f.isFile());
        System.out.format("�ж�File������Ƿ���Ŀ¼��%b%n", f.isDirectory());
        System.out.format("�ж�File������Ƿ������ص����ԣ�%b%n", f.isHidden());
        System.out.format("�ж�File������Ƿ�ɶ���%b%n", f.canRead());
        System.out.format("�ж�File������Ƿ��д��%b%n", f.canWrite());
        System.out.format("�ж�File������Ƿ��ִ�У�%b%n", f.canExecute());
        System.out.format("�ж�File������Ƿ��Ǿ���·����%b%n", f.isAbsolute());
        System.out.format("��ȡFile�����ĳ��ȣ�%d%n", f.length());
        System.out.format("��ȡFile���������ƣ�%s%n", f.getName());
        System.out.format("��ȡFile������·����%s%n", f.getPath());
        System.out.format("��ȡFile�����ľ���·����%s%n",f.getAbsolutePath());
        System.out.format("��ȡFile�����Ŀ¼��·��: %s%n", f.getParent());
    }
}
