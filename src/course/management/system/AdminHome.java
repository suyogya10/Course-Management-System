package course.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

public class AdminHome extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JButton b1,b2,b3,b4,b5;

    public static void main(String[] args) {
        new AdminHome().setVisible(true);
    }

    public AdminHome() {

        setBounds(400, 150, 800, 400);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(43, 128, 168));


        JMenuBar menuBar = new JMenuBar();
        menuBar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0)));
        menuBar.setBackground(new Color(43, 128, 168));
        menuBar.setBounds(0, 10, 1000, 35);
        contentPane.add(menuBar);

        JMenu mnExit = new JMenu("Exit");
        mnExit.setForeground(Color.BLACK);
        mnExit.setFont(new Font("Trebuchet MS", Font.BOLD, 17));


        JMenuItem mntmLogout = new JMenuItem("Logout");
        mntmLogout.setBackground(new Color(211, 211, 211));
        mntmLogout.setForeground(new Color(105, 105, 105));
        mntmLogout.addActionListener(this);
        mnExit.add(mntmLogout);

        JMenuItem mntmExit = new JMenuItem("Exit");
        mntmExit.setForeground(new Color(105, 105, 105));
        mntmExit.setBackground(new Color(211, 211, 211));
        mntmExit.addActionListener(this);
        mnExit.add(mntmExit);
        menuBar.add(mnExit);

        JLabel l1 = new JLabel("LOGGED IN AS: ADMIN");
        l1.setForeground(new Color(0, 0, 0));
        l1.setFont(new Font("Segoe UI Semilight", Font.BOLD, 30));
        l1.setBounds(240, 30, 701, 80);
        contentPane.add(l1);


        b1 = new JButton("Manage Instructors");
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(60, 150, 159, 44);
        contentPane.add(b1);

        b2 = new JButton("Manage Courses");
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(313, 150, 139, 44);
        contentPane.add(b2);

        b3 = new JButton("Manage Students");
        b3.addActionListener(this);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(562, 150, 167, 44);
        contentPane.add(b3);

        b4 = new JButton("Mark Students");
        b4.addActionListener(this);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setBounds(450, 270, 167, 44);
        contentPane.add(b4);

        b5 = new JButton("Generate Student Report");
        b5.addActionListener(this);
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.setBounds(180, 270, 200, 44);
        contentPane.add(b5);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "", TitledBorder.LEADING,
                TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel.setBounds(20, 120, 750, 100);
        panel.setBackground(new Color(43, 128, 168));
        contentPane.add(panel);

        JPanel panel2 = new JPanel();
        panel2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "", TitledBorder.LEADING,
                TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel2.setBounds(20, 240, 750, 100);
        panel2.setBackground(new Color(43, 128, 168));
        contentPane.add(panel2);

    }
    
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if(msg.equals("Logout")){
            setVisible(false);
            new Main().setVisible(true);
        }else if(msg.equals("Exit")){
            System.exit(ABORT);
        }
        if(ae.getSource() == b1){
            this.setVisible(false);
            new ManageInstructor().setVisible(true);
        }
        if(ae.getSource() == b2){
            this.setVisible(false);
            new ManageCourse().setVisible(true);
        }
        if(ae.getSource() == b3){
            this.setVisible(false);
            new ManageStudent().setVisible(true);
        }
        if(ae.getSource() == b4){
            this.setVisible(false);
            new MarkStudents("Admin").setVisible(true);
        }
        if(ae.getSource() == b5){
            this.setVisible(false);
            new GenerateReport().setVisible(true);
        }

    }

}
