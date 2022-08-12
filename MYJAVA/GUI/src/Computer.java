
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;

public class Computer {
    private String one = "0";
    private String two = "0";
    private String three = "+";
    private String four = "";
    private int Fone = 1;
    private int Ftwo = 1;
    private int Fthree = 1;
    private int Ffour = 1;
    private int Ffive = 1;
    JButton Interface;
    @SuppressWarnings("rawtypes")
    Vector vector = new Vector(20, 10);
    JFrame frame = new JFrame("¼ÆËãÆ÷");
    JTextField jTextField = new JTextField(four, 20);
    JButton qingchu = new JButton("Çå³ý");
    JButton Zero = new JButton("0");
    JButton One = new JButton("1");
    JButton Two = new JButton("2");
    JButton Three = new JButton("3");
    JButton Four = new JButton("4");
    JButton Five = new JButton("5");
    JButton Six = new JButton("6");
    JButton Seven = new JButton("7");
    JButton Eight = new JButton("8");
    JButton Nine = new JButton("9");
    JButton dian = new JButton(".");
    JButton jia = new JButton("+");
    JButton jian = new JButton("-");
    JButton cheng = new JButton("*");
    JButton chu = new JButton("/");
    JButton dengyu = new JButton("=");
    public Computer() {
        Zero.setMnemonic(KeyEvent.VK_0);
        jTextField.setHorizontalAlignment(JTextField.RIGHT);
        JPanel pan = new JPanel();
        pan.setLayout(new GridLayout(4, 4, 5, 5));
        pan.add(Seven);
        pan.add(Eight);
        pan.add(Nine);
        pan.add(chu);
        pan.add(Four);
        pan.add(Five);
        pan.add(Six);
        pan.add(cheng);
        pan.add(One);
        pan.add(Two);
        pan.add(Three);
        pan.add(jian);
        pan.add(Zero);
        pan.add(dian);
        pan.add(dengyu);
        pan.add(jia);
        pan.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        Zero.setForeground(Color.blue);
        One.setForeground(Color.blue);
        Two.setForeground(Color.blue);
        Three.setForeground(Color.blue);
        Four.setForeground(Color.blue);
        Five.setForeground(Color.blue);
        Six.setForeground(Color.blue);
        Seven.setForeground(Color.blue);
        Eight.setForeground(Color.blue);
        Nine.setForeground(Color.blue);
        dengyu.setForeground(Color.red);
        jia.setForeground(Color.red);
        jian.setForeground(Color.red);
        cheng.setForeground(Color.red);
        chu.setForeground(Color.red);
        JPanel pan2 = new JPanel();
        pan2.setLayout(new BorderLayout());
        pan2.add(jTextField, BorderLayout.WEST);
        pan2.add(qingchu, BorderLayout.EAST);
        frame.setLocation(300, 200);
        frame.setResizable(false);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(pan2, BorderLayout.NORTH);
        frame.getContentPane().add(pan, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        jTextField.setText("0");
        jTextField.setEditable(false);       
        class Listener implements ActionListener {
            @SuppressWarnings("unchecked")
            public void actionPerformed(ActionEvent e) {
                String ss = ((JButton) e.getSource()).getText();
                Interface = (JButton) e.getSource();
                vector.add(Interface);
                if (Fone == 1) {
                    if (Fthree == 1) {
                        one = "";                     
                        Ffive = 1;
                    }
                    one = one + ss;
                    Fthree = Fthree + 1;                   
                    jTextField.setText(one);
                } else if (Fone == 2) {
                    if (Ffour == 1) {
                        two = "";                        
                        Ffive = 1; 
                    }
                    two = two + ss;
                    Ffour = Ffour + 1;
                    jTextField.setText(two);
                }
            }
        }       
        class Listener_signal implements ActionListener {
            @SuppressWarnings("unchecked")
            public void actionPerformed(ActionEvent e) {
                String ss2 = ((JButton) e.getSource()).getText();
                Interface = (JButton) e.getSource();
                vector.add(Interface);
                if (Ftwo == 1) {                    
                    Fone = 2;
                    Ffive = 1;
                    three = ss2;
                    Ftwo = Ftwo + 1;
                } else {
                    int a = vector.size();
                    JButton c = (JButton) vector.get(a - 2);
                    if (!(c.getText().equals("+"))
                            && !(c.getText().equals("-"))
                            && !(c.getText().equals("*"))
                            && !(c.getText().equals("/")))
                    {
                        cal();
                        one = four;                       
                        Fone = 2;
                        Ffive = 1;
                        Ffour = 1;
                        three = ss2;
                    }
                    Ftwo = Ftwo + 1;
                }

            }
        }       
        class Listener_clear implements ActionListener {
            @SuppressWarnings("unchecked")
            public void actionPerformed(ActionEvent e) {
                Interface = (JButton) e.getSource();
                vector.add(Interface);
                Ffive = 1;
                Ftwo = 1;
                Fone = 1;
                Fthree = 1;
                Ffour = 1;
                one = "0";
                two = "0";
                three = "";
                four = "";
                jTextField.setText(four);
                vector.clear();
            }
        }     
        class Listener_dy implements ActionListener {
            @SuppressWarnings("unchecked")
            public void actionPerformed(ActionEvent e) {
                Interface = (JButton) e.getSource();
                vector.add(Interface);
                cal();
                Fone = 1; 
                Ftwo = 1;
                Fthree = 1;
                Ffour = 1;
                one = four; 
            }
        }       
        class Listener_xiaos implements ActionListener {
            @SuppressWarnings("unchecked")
            public void actionPerformed(ActionEvent e) {
                Interface = (JButton) e.getSource();
                vector.add(Interface);
                if (Ffive == 1) {
                    String ss2 = ((JButton) e.getSource()).getText();
                    if (Fone == 1) {
                        if (Fthree == 1) {
                            one = "";                           
                            Ffive = 1; 
                        }
                        one = one + ss2;
                        Fthree = Fthree + 1;                      
                        jTextField.setText(one);
                    } else if (Fone == 2) {
                        if (Ffour == 1) {
                            two = "";                           
                            Ffive = 1;
                        }
                        two = two + ss2;
                        Ffour = Ffour + 1;
                        jTextField.setText(two);
                    }
                }
                Ffive = Ffive + 1;
            }
        }

        Listener_dy jt_dy = new Listener_dy();

        Listener jt = new Listener();
      
        Listener_signal jt_signal = new Listener_signal();
       
        Listener_clear jt_c = new Listener_clear(); 
       
        Listener_xiaos jt_xs = new Listener_xiaos();

        Seven.addActionListener(jt);
        Eight.addActionListener(jt);
        Nine.addActionListener(jt);
        chu.addActionListener(jt_signal);
        Four.addActionListener(jt);
        Five.addActionListener(jt);
        Six.addActionListener(jt);
        cheng.addActionListener(jt_signal);
        One.addActionListener(jt);
        Two.addActionListener(jt);
        Three.addActionListener(jt);
        jian.addActionListener(jt_signal);
        Zero.addActionListener(jt);
        dian.addActionListener(jt_xs);
        dengyu.addActionListener(jt_dy);
        jia.addActionListener(jt_signal);
        qingchu.addActionListener(jt_c);

        
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }


    public void cal() {
     
        double a2;
   
        double b2;
    
        String c = three;
    
        double result2 = 0;

        if (c.equals("")) {
            jTextField.setText("Please input operator");

        } else {
            if (one.equals("."))
                one = "0.0";
            if (two.equals("."))
                two = "0.0";
            a2 = Double.valueOf(one).doubleValue();
            b2 = Double.valueOf(two).doubleValue();

            if (c.equals("+")) {
                result2 = a2 + b2;
            }
            if (c.equals("-")) {
                result2 = a2 - b2;
            }
            if (c.equals("*")) {
                result2 = a2 * b2;
            }
            if (c.equals("/")) {
                if (b2 == 0) {
                    result2 = 0;
                } else {
                    result2 = a2 / b2;
                }

            }

            four = ((new Double(result2)).toString());

            jTextField.setText(four);
        }
    }
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Computer cal = new Computer();
    }
}

