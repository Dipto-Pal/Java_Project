package bank;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
public class LoginDemo extends JFrame{
    Container c;
    JLabel jl12;
    JLabel jl13;
    JTextField tf12;
    JLabel jl15;
    JLabel jl16;
    JTextField tf13;
    JTextField tf14;
    JButton jb12;
    JButton jb13;
    
     String a,b,d;
    public LoginDemo()
    { 
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(700,250,600,500);
        c=getContentPane();
        c.setBackground(Color.WHITE);
        c.setLayout(null);
        
        jl12=new JLabel("Login");
        jl12.setBounds(250,40,300,50);
        jl12.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 40));
        c.add(jl12);
        
        jl13=new JLabel("Account No: ");
        jl13.setBounds(100,140,160,30);
        jl13.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        jl13.setForeground(Color.BLACK);
        c.add(jl13);
        
        tf12=new JTextField();
        tf12.setBounds(230,140,200,30);
        c.add(tf12);
        
        jl15=new JLabel("Mobile No: ");
        jl15.setBounds(100,200,160,30);
        jl15.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        jl15.setForeground(Color.BLACK);
        c.add(jl15);
        
        tf13=new JTextField();
        tf13.setBounds(230,200,200,30);
        c.add(tf13);
        
        jl15=new JLabel("Password: ");
        jl15.setBounds(100,260,160,30);
        jl15.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        jl15.setForeground(Color.BLACK);
        c.add(jl15);
        
        tf14=new JTextField();
        tf14.setBounds(230,260,200,30);
        c.add(tf14);
        
        jb12=new JButton("Clear");
        jb12.setBounds(240, 300,70,30);
        c.add(jb12);
        
        jb13=new JButton("Login");
        jb13.setBounds(350, 300,70,30);
        c.add(jb13);
        
        
        
         
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
        jb12.addActionListener(new Handler());
        jb13.addActionListener(new Handler());
        
        
        
        
    }
    class Handler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==jb13)
            {
                try
                {
                    FileReader fr=new FileReader("C:/Users/USER/Desktop/BankSign_In_Page.txt");
                    BufferedReader br=new BufferedReader(fr);
                    Scanner src=new Scanner(fr);
                    while(src.hasNext())
                    {
                       a=src.nextLine();
                       b=src.nextLine();
                       d=src.nextLine();
                    }
                    br.close();
                    fr.close();
                    src.close();
                    if(tf12.getText().equals(a) && tf13.getText().equals(b) && tf14.getText().equals(d))
                    {
                        LoginSuccess ls=new LoginSuccess();
                        dispose();
                    }
                    
                    else if(tf12.getText().equalsIgnoreCase("") && tf13.getText().equalsIgnoreCase("") && tf14.getText().equalsIgnoreCase(""))
                    {
                       LoginFailSecond lfs=new LoginFailSecond();
                        dispose();
                    }
                    else
                    {
                        LoginFail lf=new LoginFail();
                        dispose();
                    }
                }
                catch(Exception exe )
                {
                    
                }
            }
            else
            {
               tf12.setText("");
               tf13.setText("");
               tf14.setText("");
            }
        }
    }
    public static void main(String[] args) {
        LoginDemo frame4 = new LoginDemo();
        frame4.setResizable(false);
    }   
}

