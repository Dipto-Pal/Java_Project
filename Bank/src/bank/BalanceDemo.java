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
public class BalanceDemo extends JFrame {
    Container c; 
    
    JLabel jlll1;
    JTextField jttt1;
    JButton jbbb1;
    
    Double st,st1,sum;
    String se;
    public BalanceDemo()
    { 
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(750,300,500,300);
        c=getContentPane();
        c.setBackground(Color.WHITE);
        c.setLayout(null);
        jlll1=new JLabel("Balance: ");
        jlll1.setBounds(80, 60, 130, 30);
        jlll1.setFont(new Font("Arial Black", Font.PLAIN, 20));
        c.add(jlll1);
        
        jttt1=new JTextField();
        jttt1.setBounds(200,60,200,30);
        c.add(jttt1);
        
        jbbb1=new JButton("Enter");
        jbbb1.setBounds(320,100,80,20);
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
                         FileWriter fw1=new FileWriter("C:/Users/USER/Desktop/Balance_Demo.txt");
                         BufferedWriter bw1=new BufferedWriter(fw1);
                         bw1.write(jttt1.getText());
                    
                        bw1.close();
                        fw1.close();
                        
                        try
                        {
                            FileReader fr2=new FileReader("C:/Users/USER/Desktop/Total_Add_Balance.txt");
                            BufferedReader br2=new BufferedReader(fr2);
                            Scanner src3=new Scanner(fr2);
                         
                            while(src3.hasNext())
                            {
                             st=Double.parseDouble(src3.nextLine());
                            }
                        
                            br2.close();
                            fr2.close();
                            src3.close();
                            
                            st1=Double.parseDouble(jttt1.getText());
                            sum= st+st1;
                            System.out.println(st1);
                            se=String.valueOf(sum);
                            try
                            {
                                FileWriter fw2=new FileWriter("C:/Users/USER/Desktop/Total_Add_Balance.txt");
                                BufferedWriter bw2=new BufferedWriter(fw2);  
                                bw2.write(se);
                                bw2.close();
                                fw2.close();
                            }
                            catch(Exception epx)
                            {
                                
                            }
                        }
                        catch(Exception ex)
                        {
                            
                        } 
                }
                catch(Exception ep)
                {
                    
                }
                if(jttt1.getText().equalsIgnoreCase(""))
                {
                    Balance_Add_Fail baf=new Balance_Add_Fail();
                    dispose();
                }
                else
                { 
                    Balance_Show bs=new Balance_Show();
                    dispose();
                }
            }
        }
    }
    public static void main(String[] args) {
        BalanceDemo frame7 = new BalanceDemo();
        frame7.setResizable(false);
    }   

}
