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

public class SigninFail extends JFrame {
    Container c;
    
    JLabel jl14;
    JButton jb15;
    public SigninFail()
    { 
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(750,300,500,450);
        c=getContentPane();
        c.setBackground(Color.white);
        c.setLayout(null);
        
        jl14=new JLabel("!!!  Sign In Failed  !!!");
        jl14.setBounds(120,100,240,60);
        jl14.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        jl14.setForeground(Color.BLACK);
        c.add(jl14);
        
        jb15=new JButton("OK");
        jb15.setBounds(180, 170,70,50);
        jb15.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        c.add(jb15);
        
        
        
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
       
       
        jb15.addActionListener(new Handler());
        
        
    }
    class Handler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e)
        {
          if(e.getSource()==jb15)
            {
                SigninDemo sd=new SigninDemo();
                dispose();
            }
        }
    }
    public static void main(String[] args) {
        SigninFail frame = new SigninFail();
    }   
}
