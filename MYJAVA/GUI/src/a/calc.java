
package a;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class a{
	public static void main(String[] args) {
		new calculator();
	}
}
class calculator extends JFrame implements ActionListener{
	String a[]= {" "," "," ","C",
				 "7","8","9","+",
				 "4","5","6","-",
				 "1","2","3","��",
				 "0",".","=","��",};
	JTextField tf;
	JPanel jp;
	public calculator()
	{
		setSize(300,400);
		setTitle("������");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setVisible(true);
	    tf=new JTextField();
	    tf.setPreferredSize(new Dimension(300,80));
	    jp=new JPanel();
	    jp.setLayout(new GridLayout(5,4));
	    setLayout(new BorderLayout());
	    add("North",tf);
	    add("Center",jp);
	    for(int i=0;i<20;i++)
	    {
	    	JButton jb=new JButton(a[i]);
	    	jp.add(jb);
	    	jb.addActionListener(this);
	    }
	validate();
	}
	public void actionPerformed(ActionEvent e) 
	{  	
}
}