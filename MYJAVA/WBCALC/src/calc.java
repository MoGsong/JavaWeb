import java.awt.BorderLayout;                       //本代码未写入负数运算和连续运算，若要实现该功能，将z的值进行if嵌套即可
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class calc extends JFrame {

	private JPanel contentPane;
	private  JTextField text;
	int z;double a,b,result=0.0; 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calc frame = new calc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public calc() {
		setTitle("\u8BA1\u7B97\u5668");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		text = new JTextField();
		panel.add(text);
		text.setColumns(30);
		text.setText("0");
		
		JButton btn16 = new JButton("del");
		btn16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = text.getText();
				if (s.length()<1)
				{
				text.setText(s);}
				else {s = s.substring(0,s.length()-1);
						text.setText(s);}
			}
		});
		panel.add(btn16);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(4, 4, 0, 0));
		
		
		
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = text.getText();
				if(s.equals("0")) {text.setText("1");}
				else {s = s + "1";
				text.setText(s);}
			}
		});
		panel_1.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = text.getText();
				if(s.equals("0")) {text.setText("2");}
				else {s = s + "2";
				text.setText(s);}
			}
		});
		panel_1.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = text.getText();
				if(s.equals("0")) {text.setText("3");}
				else {s = s + "3";
				text.setText(s);}
			}
		});
		panel_1.add(btn3);
		

		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = text.getText();
				if(s.equals("0")) {text.setText("4");}
				else {s = s + "4";
				text.setText(s);}
			}
		});
		
		
		
		JButton btn11 = new JButton("+");
		btn11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  a = Double.parseDouble(text.getText());
			  z = 1;
			 text.setText("");
			}
		});
		panel_1.add(btn11);
		panel_1.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = text.getText();
				if(s.equals("0")) {text.setText("5");}
				else {s = s + "5";
				text.setText(s);}
			}
		});
		panel_1.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = text.getText();
				if(s.equals("0")) {text.setText("6");}
				else {s = s + "6";
				text.setText(s);}
			}
		});
		panel_1.add(btn6);
		
		JButton btn12 = new JButton("-");
		btn12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 a = Double.parseDouble(text.getText());
				 if(text.getText().length()==0 || text.getText().equals("0"))
				 {	String s = "-";
					text.setText(s);
				 }else text.setText("");
				 z = 2;
				 
			}
		});
		panel_1.add(btn12);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = text.getText();
				if(s.equals("0")) {text.setText("7");}
				else {s = s + "7";
				text.setText(s);}
			}
		});
		panel_1.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = text.getText();
				if(s.equals("0")) {text.setText("8");}
				else {s = s + "8";
				text.setText(s);}
			}
		});
		panel_1.add(btn8);
		

		JButton btn13 = new JButton("*");
		btn13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  a = Double.parseDouble(text.getText());
				 z = 3;
				 text.setText("");
			}
		});
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = text.getText();
				if(s.equals("0")) {text.setText("9");}
				else {s = s + "9";
				text.setText(s);}
				
			}
		});
		panel_1.add(btn9);
		panel_1.add(btn13);
		
		JButton btn15 = new JButton("=");
		btn15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 b =  Double.parseDouble(text.getText());
				switch (z) {
				 case 1:result = Double.valueOf(a) + Double.valueOf(b);break;
				 case 2:result = Double.valueOf(a) - Double.valueOf(b);break;
				 case 3:result = Double.valueOf(a) * Double.valueOf(b);break;
				 case 4:result = Double.valueOf(a) / Double.valueOf(b);break;
				 default:break;
				}
				text.setText(Double.toString(result));
			}
		});
		
		JButton btn10 = new JButton(".");
		btn10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = text.getText();
				if(s.substring( s.length(),1).equals(".") ) {
				text.setText(s);}
				else {
					s = s + ".";
					text.setText(s);
				}
			}
		});
		panel_1.add(btn10);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = text.getText();
				if(s.equals("0"))
					 {s = "0";
						text.setText("0");
					}
				else{ s = s + "0";
				text.setText(s);}	
				
			}
		});
		panel_1.add(btn0);
		panel_1.add(btn15);
		
		JButton btn14 = new JButton("/");
		btn14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 a = Double.parseDouble(text.getText());
				  z = 4;
				 text.setText("");
			}
		});
		panel_1.add(btn14);
	}

}
