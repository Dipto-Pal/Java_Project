package bank;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
public class Account extends JFrame {
    Container c;
    
    JLabel jll1;
    JButton jbb1;
    JButton jbb2;
    JButton jbb3;
    JButton jbb4;
    JButton jbb5;
    JButton jbb6;
    JButton jbb7;
    public Account()
    { 
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(700,250,600,500);
        c=getContentPane();
        c.setBackground(Color.WHITE);
        c.setLayout(null);
        
        jll1=new JLabel("Welcome");
        jll1.setBounds(220,40,200, 40);
        jll1.setFont(new Font("Arial Black", Font.ITALIC, 30));
        c.add(jll1);
        
        jbb1=new JButton("Add Balance");
        jbb1.setBounds(195,100,200,30);
        jbb1.setFont(new Font("Arial Black", Font.PLAIN, 15));
        jbb1.setBackground(new Color(102, 255, 102));
        c.add(jbb1);
        
        jbb2=new JButton("Sent Money");
        jbb2.setBounds(195,140,200,30);
        jbb2.setFont(new Font("Arial Black", Font.PLAIN, 15));
        jbb2.setBackground(new Color(7, 245, 170));
        c.add(jbb2);
        
        jbb3=new JButton("Mobile Recharge");
        jbb3.setBounds(195,180,200,30);
        jbb3.setFont(new Font("Arial Black", Font.PLAIN, 15));
        jbb3.setBackground(new Color(2, 219, 247));
        c.add(jbb3);
        
        jbb4=new JButton("Payment");
        jbb4.setBounds(195,220,200,30);
        jbb4.setFont(new Font("Arial Black", Font.PLAIN, 15));
        jbb4.setBackground(new Color(255, 102, 255));
        c.add(jbb4);
        
        jbb5=new JButton("Cash Out");
        jbb5.setBounds(195,260,200,30);
        jbb5.setFont(new Font("Arial Black", Font.PLAIN, 15));
        jbb5.setBackground(new Color(247, 108, 2));
        c.add(jbb5);
        
        jbb6=new JButton("Check Balance");
        jbb6.setBounds(195,300,200,30);
        jbb6.setFont(new Font("Arial Black", Font.PLAIN, 15));
        jbb6.setBackground(new Color(247, 202, 2));
        c.add(jbb6);
        
        jbb7=new JButton("Exit");
        jbb7.setBounds(195,340,200,30);
        jbb7.setFont(new Font("Arial Black", Font.PLAIN, 15));
        jbb7.setBackground(new Color(250, 0, 0));
        c.add(jbb7);
        
        jbb1.addActionListener(new Handler());
        jbb2.addActionListener(new Handler());
        jbb3.addActionListener(new Handler());
        jbb4.addActionListener(new Handler());
        jbb5.addActionListener(new Handler());
        jbb6.addActionListener(new Handler());
        jbb7.addActionListener(new Handler());
        //window close
        
       addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            if (JOptionPane.showConfirmDialog(c , 
                "Are you sure you want to close this window?", "Close Window?", 
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                System.exit(0);
             }
            else
            {
              setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
             }
            }
         });
        
    }
    class Handler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==jbb1)
            { 
                BalanceDemo bd=new BalanceDemo();
                dispose();
            }
            if(e.getSource()==jbb2)
            {
                Sent_Money bd=new Sent_Money();
                dispose();
            }
            if(e.getSource()==jbb3)
            {
                Mobile_Recharge bd=new Mobile_Recharge();
                dispose();
            }
            if(e.getSource()==jbb4)
            {
                Payment bd=new Payment();
                dispose();
            }
            if(e.getSource()==jbb5)
            {
                Cash_Out co=new Cash_Out();
                dispose();
            }
            if(e.getSource()==jbb6)
            {
                Check_Balance bd=new Check_Balance();
                dispose();
            }
            if(e.getSource()==jbb7)
            {
                System.exit(0);
            }
        }
    }
    public static void main(String[] args) {
        Account frame6 = new Account();
         frame6.setResizable(false);
    }   
}
