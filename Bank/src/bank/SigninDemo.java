package bank;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
public class SigninDemo extends JFrame {
    Container c;
    JButton jb1;
    JButton jb2;
    JLabel jl1;
    JLabel jl2;
    JLabel jl3;
    JLabel jl4;
    JLabel jl5;
    JTextField tf1;
    JTextField tf2;
    JTextField tf3;
    JTextField tf4;
    JTextField tf5;
    
    JRadioButton ck;
    JRadioButton ck1;
    
    public SigninDemo()
    { 
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(700,250,600,500);
        c=getContentPane();
        c.setBackground(Color.white);
        c.setLayout(null);
        
        
        jl1=new JLabel("Account No: ");
        jl1.setBounds(40,40,100,30);
        jl1.setForeground(Color.BLACK);
        c.add(jl1);
        
        
        tf1=new JTextField();
        tf1.setBounds(120,40,200,30);
        c.add(tf1);
        
        jl2=new JLabel("User Name: ");
        jl2.setBounds(40,100,100,30);
        jl2.setForeground(Color.BLACK);
        c.add(jl2);
        
        tf2=new JTextField();
        tf2.setBounds(120,100,200,30);
        c.add(tf2);
        
        jl3=new JLabel("Mobile No: ");
        jl3.setBounds(40,160,100,30);
        jl3.setForeground(Color.BLACK);
        c.add(jl3);
        
        tf3=new JTextField();
        tf3.setBounds(120,160,200,30);
        c.add(tf3);
        
        jl4=new JLabel("Password: ");
        jl4.setBounds(40,220,100,30);
        jl4.setForeground(Color.BLACK);
        c.add(jl4);
        
        tf4=new JTextField();
        tf4.setBounds(120,220,200,30);
        c.add(tf4);
        
        jl5=new JLabel("Amount: ");
        jl5.setBounds(40,280,100,30);
        jl5.setForeground(Color.BLACK);
        c.add(jl5);
        
        tf5=new JTextField();
        tf5.setBounds(120,280,200,30);
        c.add(tf5);
        
        jb1=new JButton("Clear");
        jb1.setBounds(120,340,90,20);
        c.add(jb1);
        jb2=new JButton("Sing In");
        jb2.setBounds(230,340,90,20);
        c.add(jb2);
        
        ck=new JRadioButton("Disagree");
        ck.setBounds(400, 80,120,50);
        ck.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        c.add(ck);
        
        
        ck1=new JRadioButton("Agree");
        ck1.setBounds(400, 140,120,50);
        ck1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        c.add(ck1);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(ck);
        bg.add(ck1);
        
        
        
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
       
       
        jb1.addActionListener(new Handler());
        jb2.addActionListener(new Handler());
        ck.addActionListener(new Handler());
       
    }
    class Handler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==jb2)
            {
               
                if(tf1.getText().equalsIgnoreCase("") || tf2.getText().equalsIgnoreCase("") ||tf3.getText().equalsIgnoreCase("") || tf4.getText().equalsIgnoreCase("") || ck.isSelected())
                {
                    SigninFail sf=new SigninFail();
                    dispose();
                }
                else
                {
                     try
                    {
                        FileWriter fw=new FileWriter("C:/Users/USER/Desktop/BankSign_In_Page.txt");
                        BufferedWriter bw=new BufferedWriter(fw);
                        bw.write(tf1.getText());
                        bw.newLine();
                        bw.write(tf3.getText());
                        bw.newLine();
                        bw.write(tf4.getText());
                        bw.close();
                        
                        FileWriter fw2=new FileWriter("C:/Users/USER/Desktop/Total_Add_Balance.txt");
                        BufferedWriter bw2=new BufferedWriter(fw2);  
                        bw2.write(tf5.getText());
                        bw2.close();
                        fw2.close();
                   
                     }
                    catch(Exception ex)
                    {
                        System.out.println(ex);
                     }
                    SigninSuccess ss=new SigninSuccess(); 
                    dispose();
                }
            }
           
            else if(e.getSource()==jb1)
            {
                tf1.setText("");
                tf2.setText("");
                tf3.setText("");
                tf4.setText("");
                
            }
            
        }
    }
    public static void main(String[] args) {
        SigninDemo frame2 = new SigninDemo();
        frame2.setResizable(false);
    }   
}

