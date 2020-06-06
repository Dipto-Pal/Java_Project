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
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
public class Check_Balance_Show extends JFrame {
    Container c; 
    
    JLabel jlll12;
    static JLabel jttt12;
    JButton jbbb12;
    static String ban;
    public Check_Balance_Show()
    { 
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(750,300,500,300);
        c=getContentPane();
        c.setBackground(Color.WHITE);
        c.setLayout(null);
        jlll12=new JLabel("Your Balance. ");
        jlll12.setBounds(80, 100, 270, 30);
        jlll12.setFont(new Font("Arial Black", Font.PLAIN, 20));
        c.add(jlll12);
        
        jttt12=new JLabel();
        jttt12.setBounds(80,60,500,30);
        jttt12.setFont(new Font("Arial Black", Font.PLAIN, 20));
        c.add(jttt12);
        
        jbbb12=new JButton("OK");
        jbbb12.setBounds(200,150,70,40);
        jbbb12.setFont(new Font("Arial Black", Font.PLAIN, 20));
        c.add(jbbb12);
        
        
        
        
        try
          {
             FileReader fr12=new FileReader("C:/Users/USER/Desktop/Total_Add_Balance.txt");
             BufferedReader br12=new BufferedReader(fr12);
             Scanner src1=new Scanner(fr12);

             while(src1.hasNext())
               {
                     ban=src1.nextLine();   
                }

                   br12.close();
                   fr12.close();
                   src1.close();
                        
                  jttt12.setText(ban+"  Tk.");
          }
        catch(Exception ep)
         {

          }
       
        
        
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
       
         jbbb12.addActionListener(new Handler());  
    }
    class Handler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e)
        {
           if(e.getSource()==jbbb12)
           {
               Account acc=new Account();
               dispose();
           }
                   
        }
    }
    
    public static void main(String[] args) {
        Check_Balance_Show frame13 = new Check_Balance_Show();
        frame13.setResizable(false);
        
    }
}
