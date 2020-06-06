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

public class HelpDemo extends JFrame {
    Container p; 
    JButton jb1;
    public HelpDemo()
    { 
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(750,300,500,300);
         
        
        p=getContentPane();
        p.setBackground(Color.WHITE);
        p.setLayout(null);
        JLabel j1 = new JLabel("Contact Us: ");
        j1.setBounds(40, 30, 250, 50);
        j1.setFont(new Font("Arial Black", Font.ITALIC, 30));
        j1.setForeground(Color.BLACK);
        p.add(j1);
         
        JLabel j2 = new JLabel("Mobile No:   017XXXXXXXX");
        j2.setBounds(120, 70, 300, 50);
        j2.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 20));
        j2.setForeground(Color.BLACK);
        p.add(j2);
        
        JLabel j3 = new JLabel("Email:    admin.@gmail.com");
        j3.setBounds(120, 100, 300, 50);
        j3.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 20));
        j3.setForeground(Color.BLACK);
        p.add(j3);
        
        JLabel j4 = new JLabel("Thanks For Contact Us....");
        j4.setBounds(120,130, 300, 50);
        j4.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 20));
        j4.setForeground(Color.BLACK);
        p.add(j4);
        
        jb1=new JButton("OK");
        jb1.setBounds(200,180,100,50);
        jb1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        jb1.setForeground(Color.BLACK);
        p.add(jb1);
        
        
        //window close
        
       addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            if (JOptionPane.showConfirmDialog(p , 
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
           
    }
    class Handler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==jb1)
            {
                Bank bk=new Bank();
                dispose();
            } 
        }
    }
    public static void main(String[] args) {
        HelpDemo frame1 = new HelpDemo();
        frame1.setResizable(false);
    }   
}

