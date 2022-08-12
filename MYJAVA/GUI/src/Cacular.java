import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

@SuppressWarnings("serial")
public  class Cacular extends JFrame implements ActionListener,MouseListener{
	private int m1=0,n=0;
	private double m2=0; 
	private int flag=0;
	JFrame f;
	JPanel p1,p2,p3;
	JTextField t;
	JButton b1[]=new JButton[18];
	String b[]= {"1","2","3","4","5","6","7","8","9","0","Çå¿Õ","ÍË¸ñ",".","=","+","-","*","/"};
	private boolean ture;

public  Cacular() {
	f=new JFrame("¼ÆËãÆ÷");
	t=new JTextField(35);
	p1=new JPanel();
	p2=new JPanel();
	p3=new JPanel();
	f.setBounds(100, 100, 400, 200);
	f.add(p1,BorderLayout.NORTH);
	f.add(p2,BorderLayout.CENTER);
	f.add(p3,BorderLayout.EAST);
	p2.setLayout(new GridLayout(5,3));
	p3.setLayout(new GridLayout(4,1));
	p1.add(t);
	validate();
	for(int i=0;i<14;i++)
	{
		b1[i]=new JButton(b[i]);
		p2.add(b1[i]);
		b1[i].addActionListener(this);
	}
	
	for(int i=14;i<18;i++)
	{
		b1[i]=new JButton(b[i]);
		p3.add(b1[i]);
		b1[i].addActionListener(this);		
	}
	//shixianjiekou
	f.setVisible(ture);
}

@Override
public void mouseClicked(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseEntered(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mousePressed(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	String str="";
	int i;
	for(i=0;i<9;i++)
	{
		if(arg0.getSource()==b[i]){ 
			if(i==9) {
				n*=10;
			}else {
				n=n*10+i+1;
			}
			str=String.valueOf(n);  //zhenhgxingzhuanzifu
			t.setText(str);         //xianshi 
		}
	}
	for(i=14;i<18;i++) {
		if(arg0.getSource()==b[i]){  //pipeiyunsuanfu
			m1=Integer.parseInt(t.getText());
			if(flag==15) {
				m2=m1+m2;
			}else if(flag==16) {
				m2=m1-m2;
			}else if(flag==17) {
				m2=m1*m2;
			}else if(flag==18) {
				m2=m1/m2;
			}else m2=m1;
			if(i==14) flag=15;
			else if(i==15) flag=16;
			else if(i==16) flag=17;
			else flag=18;
			str=String.valueOf(b[i]);
			t.setText(str);
			n=0;  //huanyuanjilushuju
			break;  //tuichu
		}
	}
	if(arg0.getSource()==b[13]){  
		m1=Integer.parseInt(t.getText());
		if(flag==15) {
			m2=m1+m2;
		}else if(flag==16) {
			m2=m1-m2;
		}else if(flag==17) {
			m2=m1*m2;
		}else if(flag==18) {
			m2=m1/m2;
		}else m2=m1;
		str=String.valueOf(m2);
		t.setText(str);
		n=0;
		flag=0;
		}
	if(arg0.getSource()==b1[10]) {
		m1=0;
		m2=0;
		flag=0;
		n=0;
		t.setText("0");
	}
	if(arg0.getSource()==b1[11]) {
		m1=(int)Integer.parseInt(t.getText());
		n=m1;
		str=String.valueOf(m1+b[12]);
		t.setText(str);
		int j=0;
		for(i=0;i<9;i++) {
			if(arg0.getSource()==b1[i]) {
				j++;
				m2=Math.pow(0.1, j)*Integer.parseInt(b[i]);
				str=String.valueOf(m1+m2);
				t.setText(str);
			}
		}
	}
	
}
public static void main(String[] args) {
	new Cacular();
}
}



