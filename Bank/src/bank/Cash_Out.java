package bank;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
public class Cash_Out extends JFrame {
    Container c; 
    
    JLabel jlll1;
    JLabel jlll2;
    JLabel jlll3;
    JTextField jttt1;
    JTextField jttt2;
    JTextField jttt3;
    JButton jbbb1;
    
    String a,b,d;
    Double vul,st,cal;
    String st1;
    Double store_amount;
    String add_total;
    
    public Cash_Out()
    { 
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(750,300,500,300);
        c=getContentPane();
        c.setBackground(Color.WHITE);
        c.setLayout(null);
        jlll1=new JLabel("Mobile No: ");
        jlll1.setBounds(70, 60, 130, 30);
        jlll1.setFont(new Font("Arial Black", Font.PLAIN, 20));
        c.add(jlll1);
        
        jttt1=new JTextField();
        jttt1.setBounds(200,60,200,30);
        c.add(jttt1);
        
        jlll2=new JLabel("Balance: ");
        jlll2.setBounds(70, 120, 130, 30);
        jlll2.setFont(new Font("Arial Black", Font.PLAIN, 20));
        c.add(jlll2);
        
        jttt2=new JTextField();
        jttt2.setBounds(200,120,200,30);
        c.add(jttt2);
        
        jlll3=new JLabel("Password: ");
        jlll3.setBounds(70, 180, 130, 30);
        jlll3.setFont(new Font("Arial Black", Font.PLAIN, 20));
        c.add(jlll3);
        
        jttt3=new JTextField();
        jttt3.setBounds(200,180,200,30);
        c.add(jttt3);
        
        jbbb1=new JButton("Enter");
        jbbb1.setBounds(320,230,80,20);
        c.add(jbbb1);
        
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
       
       
       jbbb1.addActionListener(new Handler());
           
    }
    class Handler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==jbbb1)
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
                     }
                                 
                    catch(Exception exe )
                    {
                    
                     }
                    
                    if(jttt1.getText().equalsIgnoreCase("") || jttt2.getText().equalsIgnoreCase("") || jttt3.getText().equalsIgnoreCase(""))
                    {
                       Cash_Out_Fail sf=new Cash_Out_Fail();
                       dispose();
                    }
                    else
                    {
                            
                             if(jttt3.getText().equals(d))
                             {  
                                 
                                  try
                                  {
                                        FileReader fr2=new FileReader("C:/Users/USER/Desktop/Total_Add_Balance.txt");
                                        BufferedReader br2=new BufferedReader(fr2);
                                        Scanner src3=new Scanner(fr2);
                                        while(src3.hasNext())
                                        {
                                            st=Double.parseDouble(src3.nextLine());
                                        }
                                        vul=Double.parseDouble(jttt2.getText());
                                        fr2.close();
                                        br2.close();
                                        src3.close();
                                        
                                        if(st>=vul)
                                        {
                                             FileWriter fw1=new FileWriter("C:/Users/USER/Desktop/Cash_Out.txt");
                                             BufferedWriter bw1=new BufferedWriter(fw1);
                                             bw1.write(jttt2.getText());
                                             bw1.close();
                                             fw1.close();
                                     
                                             dispose();
                                             Cash_Out_Success ls=new Cash_Out_Success();
                                             
                                             store_amount=st-vul;
                                             add_total=String.valueOf(store_amount);
                                             
                                             FileWriter fw12=new FileWriter("C:/Users/USER/Desktop/Total_Add_Balance.txt");
                                             BufferedWriter bw12=new BufferedWriter(fw12);
                                             bw12.write(add_total);
                                             bw12.close();
                                             fw12.close();
                                             
                                             
                                        }
                                         else
                                         {
                                             
                                             Insufficient_Balance ib=new Insufficient_Balance();
                                             dispose();
                                             
                                         }
                                     
                                  } 
                                catch(Exception ep)
                                  {
                                      
                                  }
                             }
                            else
                             {
                                Cash_Out_Fail sf=new Cash_Out_Fail();
                                dispose();
                             }
                    }     
            }
        }
    }
    public static void main(String[] args) {
        Cash_Out frame21 = new Cash_Out();
        frame21.setResizable(false);
    }
}
