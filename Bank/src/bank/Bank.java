package bank;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SingleSelectionModel;

public class Bank extends JFrame {
    Container c;
    ImageIcon icon;
    JLabel background;
    JPanel p;  
    
    JMenuBar menubar;
    JMenuItem log;
    JMenuItem sig;
    JMenuItem help;
    JMenuItem exit;
    JButton jb1;
    public Bank()
    { 
        //window
        setVisible(true);
        setTitle("Bank");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(700,250,600,500);
        c=getContentPane();
        c.setLayout(null);
        
        
        
        //login
        JPanel login=new JPanel();
        login.setSize(400,350);
        login.setBackground(new Color(0,0,0,60));
        login.setBounds(253,210,90,180);
      
        //Menu
        
        menubar=new JMenuBar();
        login.add(menubar);
        
        
        JMenu menu=new JMenu("    Menu   ");    
        menubar.add(menu);
        
        log=new JMenuItem(" Log In");
        menu.add(log);
        
       sig =new JMenuItem(" Sign In");
        menu.add(sig);
        
        
        help=new JMenuItem(" Help");
        menu.add(help);
        
        
        exit=new JMenuItem(" Exit");
        menu.add(exit);
            
        //Background
        ImageIcon img=new ImageIcon("D:\\Dipta Pal\\University\\First Year\\TRIMESTER 3\\Object Oriented Programming Lab\\Project\\New Folder\\Bank\\img.jpeg");
        Image img1=img.getImage();
        Image temp_img1=img1.getScaledInstance(600,500,Image.SCALE_SMOOTH);
        img=new ImageIcon(temp_img1);
        background =new JLabel("",img,JLabel.CENTER);
        background.setBounds(0,0,600,500);
        background.add(login);
        c.add(background);
        
        log.addActionListener(new Handler());
        sig.addActionListener(new Handler());
        help.addActionListener(new Handler());
        exit.addActionListener(new Handler());
        
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
        
        //Hide Menu
        addMouseMotionListener(new MouseAdapter() {
        @Override
        public void mouseMoved(MouseEvent e) {
            if (menubar.isSelected()) {
                try {
                    Robot robot = new Robot();
                    robot.keyPress(KeyEvent.VK_ESCAPE);
                    SingleSelectionModel sm = menubar.getSelectionModel();
                    sm.clearSelection();
                } catch (AWTException ex) 
                {
                        
                }
            }
        }
    });
        
    }
    class Handler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==log)
            {
                LoginDemo ld=new LoginDemo();
                dispose();
            }
            if(e.getSource()==sig)
            {
                SigninDemo ld=new SigninDemo();
                dispose();
            }
            if(e.getSource()==help)
            {
              HelpDemo nw= new HelpDemo(); 
              dispose();
            }
            if(e.getSource()==exit)
            {
             System.exit(0);
            }
          
        }
    }
    public static void main(String[] args) {
        Bank frame = new Bank();
        frame.setResizable(false);
        
    }   
}
