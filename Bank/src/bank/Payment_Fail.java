package bank;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
public class Payment_Fail extends JFrame {
    Container c; 
    
    JLabel jlll12;
    JButton jbbb12;
    static String ban;
    public Payment_Fail()
    { 
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(750,300,500,300);
        c=getContentPane();
        c.setBackground(Color.WHITE);
        c.setLayout(null);
        jlll12=new JLabel("Payment Failed  !!!");
        jlll12.setBounds(100, 100, 320, 50);
        jlll12.setFont(new Font("Arial Black", Font.PLAIN, 30));
        c.add(jlll12);
        
        jbbb12=new JButton("OK");
        jbbb12.setBounds(220,150,60,20);
        c.add(jbbb12);
    
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
               Payment acc=new Payment();
               dispose();
           }
                   
        }
    }
    
    public static void main(String[] args) {
        Payment_Fail frame21 = new Payment_Fail();
        frame21.setResizable(false);
        
    }
}
