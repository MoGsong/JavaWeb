package Multi_thread;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * ʵ�������ߺ��������߳�Э��
 */
public class TestProdCons {
    //����һ������ȹ��ļ��ϣ������ŵ��������������ȹ����
    private static final List<Integer> hotDogs = new ArrayList<Integer>();

    public static void main(String[] args) {
        Random rand = new Random();
        for (int i = 1; i <= 3; i++) {
            new Producer(i).start();
            //Thread.currentThread().setPriority(rand.nextInt(10));//rand.nextInt(10)���ֵ����Ϊ0�������ȼ����ò����쳣
            //System.out.println("Prod("+ i +")�����ȼ�:"+Thread.currentThread().getPriority());
        }
        for (int i = 1; i <= 5; i++) {
            new Consumer(i).start();
            //Thread.currentThread().setPriority(rand.nextInt(10));//rand.nextInt(10)���ֵ����Ϊ0�������ȼ����ò����쳣
            //System.out.println("Cons("+ i +")�����ȼ�:"+Thread.currentThread().getPriority());
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    //�������̣߳����ȹ�������Ϊ�����������ж��ȹ����ϵĲ�������
    private static class Producer extends Thread {
        int i = 1;
        int pid = -1;

        public Producer(){}

        public Producer(int id) {
            this.pid = id;
        }

        public void run() {
            while (true) {
                synchronized (hotDogs) {
                    try {
                        //ģ�����ĵ�ʱ��
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (hotDogs.size() < 10) {
                        //�ȹ���ţ���30002������Ϊ3�������������ĵ�2���ȹ�
                        hotDogs.add(pid * 10000 + i);
                        System.out.println("������" + pid + "�����ȹ������Ϊ��" + (pid * 10000 + i));
                        i++;
                        //����hotDogs�����������е���wait()�������߳�
                        hotDogs.notifyAll();
                    } else {
                        try {
                            System.out.println("�ȹ����ѵ�10�����ȴ����ѣ�");
                            hotDogs.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    //�������̣߳����ȹ�������Ϊ�����������ж��ȹ����ϵĲ�������
    private static class Consumer extends Thread {
        int cid = -1;

        public Consumer(){}

        public Consumer(int id) {
            this.cid = id;
        }

        public void run() {
            while (true) {
                synchronized (hotDogs) {
                    try {
                        //ģ�����ĵ�ʱ��
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (hotDogs.size() > 0) {
                        System.out.println("������" + this.cid + "��������һ���ȹ�������Ϊ�� " + hotDogs.remove(0));
                        hotDogs.notifyAll();
                    } else {
                        try {
                            System.out.println("��û���ȹ����ȴ�������");
                            hotDogs.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
