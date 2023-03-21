package course.management.system;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.*;
import java.sql.*;
//Suyogya Gautam
//2059802
// Main file for the system to work.
// Login Signup are accessible from here.

//use of inheritance
public class Main extends JFrame implements ActionListener{
    //data hiding
    private JPanel panel;  //JPanel is a generic lightweight container.
    private JTextField textField; //a text component that allows the editing of a single line text.
    private  JPasswordField passwordField; //for entering password. text is not shown.
    private JButton b1,b2,b3;  //declaring buttons
    private JComboBox comboBox; //combobox used for various options.

    // Main method
    public Main() {

        //setting the Main Panel
        setBackground(new Color(43, 128, 168));
        setBounds(600, 300, 600, 400);

        panel = new JPanel();
        panel.setBackground(new Color(43, 128, 168));
        setContentPane(panel);
        panel.setLayout(null);

        //setting a menu bar
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(43, 128, 168)));
        menuBar.setBackground(new Color(43, 128, 168));
        menuBar.setBounds(0, 0, 1000, 30);
        panel.add(menuBar);
        JMenu mnExit = new JMenu("Exit");
        mnExit.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        JMenuItem mntmExit = new JMenuItem("Exit");
        mntmExit.setForeground(new Color(0, 0, 0));
        mntmExit.setBackground(new Color(43, 128, 168));
        mntmExit.addActionListener(this);
        mnExit.add(mntmExit);
        menuBar.add(mnExit);

        JLabel l0 = new JLabel("COURSE MANAGEMENT SYSTEM");
        l0.setBounds(95, 0, 1000, 100);
        l0.setForeground(new Color(0, 0, 0));
        l0.setFont(new Font("Serif", Font.PLAIN, 25));
        panel.add(l0);

        JLabel l1 = new JLabel("Username : ");
        l1.setBounds(135, 89, 95, 24);
        l1.setForeground(new Color(0, 0, 0));
        panel.add(l1);

        JLabel l2 = new JLabel("Password : ");
        l2.setBounds(135, 124, 95, 24);
        l2.setForeground(new Color(0, 0, 0));
        panel.add(l2);

        JLabel l44 = new JLabel("Account Type : ");
        l44.setBounds(125, 154, 95, 24);
        l44.setForeground(new Color(0, 0, 0));
        panel.add(l44);

        //username
        textField = new JTextField();
        textField.setBounds(210, 93, 157, 20);
        panel.add(textField);

        passwordField = new JPasswordField();
        passwordField.setBounds(210, 128, 157, 20);
        panel.add(passwordField);

        //to select account type for user
        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Admin", "Instructor",
                "Student" }));
        comboBox.setBounds(215, 158, 157, 20);
        panel.add(comboBox);


        JLabel l3 = new JLabel("");
        l3.setBounds(377, 85, 46, 34);
        panel.add(l3);

        JLabel l4 = new JLabel("");
        l4.setBounds(377, 130, 46, 34);
        panel.add(l3);

        b1 = new JButton("Login");
        b1.addActionListener(this);

        b1.setForeground(new Color(255, 255, 255));
        b1.setBackground(new Color(0, 0, 0));
        b1.setBounds(149, 191, 113, 39);
        panel.add(b1);

        b2 = new JButton("SignUp");
        b2.addActionListener(this);

        b2.setForeground(new Color(255, 255, 255));
        b2.setBackground(new Color(0, 0, 0));
        b2.setBounds(289, 191, 113, 39);
        panel.add(b2);

        b3 = new JButton("Forgot Password");
        b3.addActionListener(this);

        b3.setForeground(new Color(255, 255, 255));
        b3.setBackground(new Color(0, 0, 0));
        b3.setBounds(199, 241, 179, 39);
        panel.add(b3);

        JLabel l5 = new JLabel("Trouble in Login?");
        l5.setFont(new Font("Tahoma", Font.PLAIN, 15));
        l5.setForeground(new Color(0, 0, 0));
        l5.setBounds(70, 250, 130, 20);
        panel.add(l5);

        //for design
        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(43, 128, 168));
        panel2.setBounds(24, 40, 434, 263);
        panel.add(panel2);
    }
    public void actionPerformed(ActionEvent ae){
        //check the account type first with value
        String value= comboBox.getSelectedItem().toString();
        if(ae.getSource() == b1){
            Boolean status = false;
            try {
                connect con = new connect(); //connecting with database
                String sql = "select * from accounts where username=? and password=?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, textField.getText());
                st.setString(2, passwordField.getText());
                //st.setString(3, value); in case to put it in query

                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    //check the value indicators first and then perform the action.
                    if (value == "Admin"){
                        this.setVisible(false);
                        AdminHome ah = new AdminHome();
                        ah.setVisible(true);
                    }else if (value == "Student") {
                        this.setVisible(false);
                        StudentHome sh = new StudentHome();
                        sh.setVisible(true);
                    }else if (value == "Instructor"){
                        this.setVisible(false);
                        InstructorHome ih = new InstructorHome();
                        ih.setVisible(true);
                    }

                } else
                    JOptionPane.showMessageDialog(null, "Invalid Login...!.");

            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        if(ae.getSource() == b2){
            setVisible(false);
            Signup su = new Signup();
            su.setVisible(true);
        }
        if(ae.getSource() == b3){
            setVisible(false);
            Forgot forgot = new Forgot();
            forgot.setVisible(true);
        }
        String msg = ae.getActionCommand();
        if(msg.equals("Exit")){
            System.exit(ABORT);}
        }

    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}
class Signup extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JButton b1, b2;
    private JComboBox comboBox,comboBox2;


    public static void main(String[] args) {
        new Signup().setVisible(true);
    }

    public Signup() {
        setBounds(600, 250, 606, 406);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(new Color(43, 128, 168));
        contentPane.setLayout(null);

        JLabel lblUsername = new JLabel("Username :");
        lblUsername.setForeground(Color.BLACK);
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblUsername.setBounds(99, 86, 92, 26);
        contentPane.add(lblUsername);

        JLabel lblName = new JLabel("Name :");
        lblName.setForeground(Color.BLACK);
        lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblName.setBounds(99, 123, 92, 26);
        contentPane.add(lblName);

        JLabel lblPassword = new JLabel("Password :");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPassword.setBounds(99, 160, 92, 26);
        contentPane.add(lblPassword);

        JLabel lblAnswer = new JLabel("Answer :");
        lblAnswer.setForeground(Color.BLACK);
        lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAnswer.setBounds(99, 234, 92, 26);
        contentPane.add(lblAnswer);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] { "Your NickName?", "Your Lucky Number?",
                "Your child SuperHero?", "Your childhood Name ?" }));
        comboBox.setBounds(265, 202, 148, 20);
        contentPane.add(comboBox);

        JLabel lblSecurityQuestion = new JLabel("Security Question :");
        lblSecurityQuestion.setForeground(Color.BLACK);
        lblSecurityQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblSecurityQuestion.setBounds(99, 197, 140, 26);
        contentPane.add(lblSecurityQuestion);

        comboBox2 = new JComboBox();
        comboBox2.setModel(new DefaultComboBoxModel(new String[] { "Instructor",
                "Student"}));
        comboBox2.setBounds(265, 272, 148, 20);
        contentPane.add(comboBox2);

        JLabel lblaccounttype = new JLabel("Account type :");
        lblaccounttype.setForeground(Color.BLACK);
        lblaccounttype.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblaccounttype.setBounds(99, 265, 140, 26);
        contentPane.add(lblaccounttype);

        textField = new JTextField();
        textField.setBounds(265, 91, 148, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(265, 128, 148, 20);
        contentPane.add(textField_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(265, 165, 148, 20);
        contentPane.add(textField_2);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(265, 239, 148, 20);
        contentPane.add(textField_3);

        b1 = new JButton("Create");
        b1.addActionListener(this);
        b1.setFont(new Font("Tahoma", Font.BOLD, 13));
        b1.setBounds(140, 304, 100, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setFont(new Font("Tahoma", Font.BOLD, 13));
        b2.setBounds(300, 304, 100, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);

        JPanel panel = new JPanel();
        panel.setForeground(new Color(0, 0, 0));
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Create-Account",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel.setBounds(31, 46, 476, 296);
        panel.setBackground(new Color(43, 128, 168));
        contentPane.add(panel);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            connect con = new connect();

            if(ae.getSource() == b1){
                //sql query to save new account details.
                String sql = "insert into accounts(username, name, password, sec_q, sec_a, acc_type) values(?, ?, ?, ?, ?,?)";
                PreparedStatement st = con.c.prepareStatement(sql);
                //setString will get values from textfrields and comboboxes and set in query
                st.setString(1, textField.getText());
                st.setString(2, textField_1.getText());
                st.setString(3, textField_2.getText());
                st.setString(4, (String) comboBox.getSelectedItem());
                st.setString(5, textField_3.getText());
                st.setString(6, (String) comboBox2.getSelectedItem());

                int i = st.executeUpdate();
                if (i > 0){
                    JOptionPane.showMessageDialog(null, "successfully Created");
                }

                textField.setText("");
                textField_1.setText("");
                textField_2.setText("");
                textField_3.setText("");
            }
            if(ae.getSource() == b2){
                this.setVisible(false);
                new Main().setVisible(true);

            }
        }catch(Exception e){

        }
    }
}
class Forgot extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t1,t2,t3,t4,t5;
    private JButton b1,b2,b3;

    public static void main(String[] args) {
        new Forgot().setVisible(true);
    }

    public Forgot() {

        setBounds(500, 200, 650, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(new Color(43, 128, 168));
        contentPane.setLayout(null);

        JLabel l1 = new JLabel("Username");
        l1.setFont(new Font("Tahoma", Font.BOLD, 13));
        l1.setBounds(109, 83, 87, 29);
        l1.setForeground(new Color(0, 0, 0));
        contentPane.add(l1);

        JLabel l2 = new JLabel("Name");
        l2.setFont(new Font("Tahoma", Font.BOLD, 13));
        l2.setBounds(109, 122, 75, 21);
        l2.setForeground(new Color(0, 0, 0));
        contentPane.add(l2);

        JLabel l3 = new JLabel("Your Security Question");
        l3.setFont(new Font("Tahoma", Font.BOLD, 13));
        l3.setBounds(109, 154, 156, 27);
        l3.setForeground(new Color(0, 0, 0));
        contentPane.add(l3);

        JLabel l4 = new JLabel("Answer");
        l4.setFont(new Font("Tahoma", Font.BOLD, 13));
        l4.setBounds(109, 192, 104, 21);
        l4.setForeground(new Color(0, 0, 0));
        contentPane.add(l4);

        JLabel l5 = new JLabel("Password");
        l5.setFont(new Font("Tahoma", Font.BOLD, 13));
        l5.setBounds(109, 224, 104, 21);
        l5.setForeground(new Color(0, 0, 0));
        contentPane.add(l5);

        t1 = new JTextField();
        t1.setFont(new Font("Tahoma", Font.BOLD, 13));
        t1.setForeground(Color.BLACK);
        t1.setBounds(277, 88, 139, 20);
        contentPane.add(t1);
        t1.setColumns(10);

        t2 = new JTextField();
        t2.setEditable(false);
        t2.setFont(new Font("Tahoma", Font.BOLD, 13));
        t2.setForeground(new Color(165, 42, 42));
        t2.setColumns(10);
        t2.setBounds(277, 123, 139, 20);
        contentPane.add(t2);

        t3 = new JTextField();
        t3.setEditable(false);
        t3.setFont(new Font("Tahoma", Font.BOLD, 12));
        t3.setForeground(new Color(0, 0, 0));
        t3.setColumns(10);
        t3.setBounds(277, 161, 221, 20);
        contentPane.add(t3);

        t4 = new JTextField();
        t4.setFont(new Font("Tahoma", Font.BOLD, 13));
        t4.setForeground(new Color(0, 0, 0));
        t4.setColumns(10);
        t4.setBounds(277, 193, 139, 20);
        contentPane.add(t4);

        t5 = new JTextField();
        t5.setEditable(false);
        t5.setFont(new Font("Tahoma", Font.BOLD, 13));
        t5.setForeground(new Color(0, 0, 0));
        t5.setColumns(10);
        t5.setBounds(277, 225, 139, 20);
        contentPane.add(t5);

        b1 = new JButton("Search");
        b1.addActionListener(this);
        b1.setFont(new Font("Tahoma", Font.BOLD, 12));
        b1.setBounds(428, 83, 80, 29);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        b2 = new JButton("Retrieve");
        b2.addActionListener(this);
        b2.setFont(new Font("Tahoma", Font.BOLD, 12));
        b2.setBounds(426, 188, 90, 29);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);

        b3 = new JButton("Back");
        b3.addActionListener(this);
        b3.setFont(new Font("Tahoma", Font.BOLD, 13));
        b3.setBounds(233, 270, 101, 29);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        contentPane.add(b3);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Forgot-Panel",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel.setBounds(47, 45, 508, 281);
        panel.setBackground(new Color(43, 128, 168));
        contentPane.add(panel);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            connect con = new connect();
            //check valid username
            if(ae.getSource() == b1){
                String sql = "select * from accounts where username=?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, t1.getText());
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    //set values if username matches
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("sec_q"));
                }

            }
            if(ae.getSource() == b2){
                //check security answer
                String sql = "select * from accounts where sec_a=?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, t4.getText());
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    t5.setText(rs.getString("password"));
                }

            }
            if(ae.getSource() == b3){
                this.setVisible(false);
                new Main().setVisible(true);

            }
        }catch(Exception e){

        }
    }

}
