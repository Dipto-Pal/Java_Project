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
public class Check_Balance extends JFrame{
    Container c; 
    
    JLabel jlll1;
    JTextField jttt1;
    JButton jbbb1;
    
    String a,b,d;
    public Check_Balance()
    { 
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(750,300,500,300);
        c=getContentPane();
        c.setBackground(Color.WHITE);
        c.setLayout(null);
        jlll1=new JLabel("Enter Password: ");
        jlll1.setBounds(20, 60, 220, 30);
        jlll1.setFont(new Font("Arial Black", Font.PLAIN, 20));
        c.add(jlll1);
        
        jttt1=new JTextField();
        jttt1.setBounds(210,60,200,30);
        c.add(jttt1);
        
        jbbb1=new JButton("OK");
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
                }
                
                if(jttt1.getText().equalsIgnoreCase(""))
                    {
                       Checked_Invalid sf=new Checked_Invalid();
                       dispose();
                    }
                else
                { 
                    if(jttt1.getText().equals(d))
                    { 
                        Check_Balance_Show cbs= new Check_Balance_Show();
                        dispose();

                    }
                   else
                    {
                       Checked_Invalid sf=new Checked_Invalid();
                       dispose();
                    }
                    
                }
            }
        
    }
    public static void main(String[] args) {
        Check_Balance frame14 = new Check_Balance();
        frame14.setResizable(false);
    }   

}
