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
public class LoginFail extends JFrame{
    Container c;
    JButton jb11;
    public LoginFail()
    { 
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(750,300,500,350);
        c=getContentPane();
        c.setBackground(Color.white);
        c.setLayout(null);
        
        JLabel jl11=new JLabel("!!!  Login Failed  !!!");
        jl11.setBounds(160,40,240,60);
        jl11.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        jl11.setForeground(Color.BLACK);
        c.add(jl11);
        
        
       JLabel jl12=new JLabel("Incorrect  Account  No, Mobile No and  Password");
       jl12.setBounds(70,100,380,60);
       jl12.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
       jl12.setForeground(Color.BLACK);
       c.add(jl12);
        
        
        jb11=new JButton("OK");
        jb11.setBounds(210, 170,70,50);
        jb11.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        c.add(jb11);
        
        
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
        
        
        jb11.addActionListener(new Handler());
    }
    class Handler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==jb11)
            {
                LoginDemo ld=new LoginDemo();
                dispose();
            }
        }
    }
    public static void main(String[] args) {
        
        LoginFail frame5 = new LoginFail();
        frame5.setResizable(false);
        
    }   
}

