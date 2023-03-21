package course.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.util.Random;
import javax.swing.border.*;

public class StudentHome extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JButton b1,b2,b3;

    public static void main(String[] args) {
        new StudentHome().setVisible(true);
    }

    public StudentHome() {

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

        JLabel l1 = new JLabel("LOGGED IN AS: STUDENT");
        l1.setForeground(new Color(0, 0, 0));
        l1.setFont(new Font("Segoe UI Semilight", Font.BOLD, 30));
        l1.setBounds(240, 30, 701, 80);
        contentPane.add(l1);

        b1 = new JButton("Enroll Courses");
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(60, 150, 159, 44);
        contentPane.add(b1);

        b2 = new JButton("View Instructors");
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(313, 150, 139, 44);
        contentPane.add(b2);

        b3 = new JButton("View Result");
        b3.addActionListener(this);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(562, 150, 167, 44);
        contentPane.add(b3);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Action", TitledBorder.LEADING,
                TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel.setBounds(20, 120, 750, 100);
        panel.setBackground(new Color(43, 128, 168));
        contentPane.add(panel);

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
            new EnrollCourse().setVisible(true);
        }
        if(ae.getSource() == b2){
            this.setVisible(false);
            new ViewInstructors("Student").setVisible(true);
        }
        if(ae.getSource() == b3){
            this.setVisible(false);
            new ViewMarks().setVisible(true);
        }
    }
}

class EnrollCourse extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t1,t2,t3;
    private JComboBox comboBox, comboBox_1, comboBox_2, comboBox_3;
    JButton b1,b2;

    public static void main(String[] args) {
        new EnrollCourse().setVisible(true);
    }

    public void random() {
        Random rd = new Random();
        t1.setText("" + rd.nextInt(10000 + 1));
    }

    public EnrollCourse() {
        super("Enroll Course");
        setBounds(700, 200, 550, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel l1 = new JLabel("Student_id");
        l1.setForeground(new Color(0, 0, 0));
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(64, 63, 102, 22);
        contentPane.add(l1);

        JLabel l2 = new JLabel("Name");
        l2.setForeground(new Color(0, 0, 0));
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(64, 97, 102, 22);
        contentPane.add(l2);

        JLabel l5 = new JLabel("Level");
        l5.setForeground(new Color(0, 0, 0));
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setBounds(64, 182, 102, 22);
        contentPane.add(l5);

        JLabel l6 = new JLabel("Semester");
        l6.setForeground(new Color(0, 0, 0));
        l6.setFont(new Font("Tahoma", Font.BOLD, 14));
        l6.setBounds(64, 222, 102, 22);
        contentPane.add(l6);

        t1 = new JTextField();
        t1.setEditable(false);
        t1.setForeground(new Color(0, 0, 0));
        t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t1.setBounds(174, 66, 156, 20);
        contentPane.add(t1);
        t1.setColumns(10);

        t2 = new JTextField();
        t2.setForeground(new Color(0, 0, 0));
        t2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t2.setColumns(10);
        t2.setBounds(174, 100, 156, 20);
        contentPane.add(t2);

        comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "First", "Second", "Third", "Four" }));
        comboBox_1.setForeground(new Color(0, 0, 0));
        comboBox_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        comboBox_1.setBounds(176, 220, 154, 20);
        contentPane.add(comboBox_1);

        comboBox_2 = new JComboBox();
        comboBox_2.setModel(
                new DefaultComboBoxModel(new String[] {"3", "4", "5", "6"}));
        comboBox_2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        comboBox_2.setForeground(new Color(0, 0, 0));
        comboBox_2.setBounds(176, 180, 154, 20);
        contentPane.add(comboBox_2);

        b1 = new JButton("Enroll");
        b1.addActionListener(this);
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b1.setBounds(64, 320, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b2.setBounds(250, 320, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);

        JLabel l7 = new JLabel("Course");
        l7.setForeground(new Color(0, 0, 0));
        l7.setFont(new Font("Tahoma", Font.BOLD, 14));
        l7.setBounds(64, 140, 102, 22);
        contentPane.add(l7);

        comboBox_3 = new JComboBox();
        comboBox_3.setModel(new DefaultComboBoxModel(
                new String[] { "BscIT", "BIBM"}));
        comboBox_3.setForeground(new Color(0, 0, 0));
        comboBox_3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        comboBox_3.setBounds(176, 138, 154, 20);
        contentPane.add(comboBox_3);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), " Enroll Yourself ",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel.setBackground(new Color(43, 128, 168));
        panel.setBounds(10, 38, 458, 348);
        contentPane.setBackground(new Color(43, 128, 168));
        panel.setBackground(new Color(43, 128, 168));
        contentPane.add(panel);
        random();
    }
    public void actionPerformed(ActionEvent ae){
        try{
            if(ae.getSource() == b1){
                try{
                    connect con = new connect();
                    String sql = "insert into student(student_id, name, course, level, semester) values(?, ?, ?, ?, ?)";
                    PreparedStatement st = con.c.prepareStatement(sql);
                    st.setString(1, t1.getText());
                    st.setString(2, t2.getText());
                    st.setString(3, (String) comboBox_3.getSelectedItem());
                    st.setString(4, (String) comboBox_2.getSelectedItem());
                    st.setString(5, (String) comboBox_1.getSelectedItem());

                    int i = st.executeUpdate();
                    if (i > 0){
                        JOptionPane.showMessageDialog(null, "Successfully Enrolled");
                        this.setVisible(false);
                        new EnrollCourse().setVisible(true);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "error");
                    if ((String) comboBox_3.getSelectedItem()=="BscIT"){
                        String sql2 = "insert into bscit(student_id,student_name,level) values(?,?,?)";
                        PreparedStatement st2 = con.c.prepareStatement(sql2);
                        st2.setString(1, t1.getText());
                        st2.setString(2, t2.getText());
                        st2.setString(3, (String) comboBox_2.getSelectedItem());

                        st2.executeUpdate();
                    }
                    else {
                        String sql2 = "insert into bibm(student_id,student_name,level) values(?,?,?)";
                        PreparedStatement st2 = con.c.prepareStatement(sql2);
                        st2.setString(1, t1.getText());
                        st2.setString(2, t2.getText());
                        st2.setString(3, (String) comboBox_2.getSelectedItem());
                        st2.executeUpdate();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            if(ae.getSource() == b2){
                    this.setVisible(false);
                    new StudentHome().setVisible(true);
            }
        }catch(Exception e){
        }
    }
}