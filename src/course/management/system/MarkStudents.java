package course.management.system;
import net.proteanit.sql.DbUtils;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

// This part will be used for marking students by the Admin and Instructors

public class MarkStudents extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t1,t2,t3,m1,m2,m3,m4,m5,m6;
    private JComboBox comboBox_1, comboBox_2,cbm1,cbm2,cbm3,cbm4,cbm5,cbm6,cbst;
    JButton b1,b2,b3;
    String indi;

    public static void main(String[] args) {
        new MarkStudents("Admin").setVisible(true);
    }

    public MarkStudents(String indicator) {
        indi=indicator;
        setBounds(700, 200, 500, 480);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel l1 = new JLabel("Student_id");
        l1.setForeground(new Color(0, 0, 0));
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(64, 60, 102, 22);
        contentPane.add(l1);

        JLabel l2 = new JLabel("Name");
        l2.setForeground(new Color(0, 0, 0));
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(64, 90, 102, 22);
        contentPane.add(l2);

        JLabel l3 = new JLabel("Course");
        l3.setForeground(new Color(0, 0, 0));
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setBounds(64, 120, 102, 22);
        contentPane.add(l3);

        JLabel l4 = new JLabel("Level");
        l4.setForeground(new Color(0, 0, 0));
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(64, 150, 102, 22);
        contentPane.add(l4);

        //here we are going to include all the modules to add marks to for one course

        cbm1 = new JComboBox();
        cbm1.setModel(new DefaultComboBoxModel(new String[] { "Introductory Programming","Academic Skills", "Fundamentals of Computing", "Embedded Systems Programming",
                "Internet Software","Computational Mathematics","Concepts and Technologies of AI","Object-Oriented Design and Programming",
                "Numerical Methods and Concurrency","Distributed and Cloud System Programming","Collaborative Development",
                "Human Computer Interaction","Complex System","High Performance Computing","Project and Professionalism",
                "Artificial Intelligence and Machine Learning","Big Data","Optional Subject"
        }));
        cbm1.setForeground(new Color(0, 0, 0));
        cbm1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        cbm1.setBounds(20, 180, 180, 20);
        contentPane.add(cbm1);

        cbm2 = new JComboBox();
        cbm2.setModel(new DefaultComboBoxModel(new String[] { "Introductory Programming","Academic Skills", "Fundamentals of Computing", "Embedded Systems Programming",
                "Internet Software","Computational Mathematics","Concepts and Technologies of AI","Object-Oriented Design and Programming",
                "Numerical Methods and Concurrency","Distributed and Cloud System Programming","Collaborative Development",
                "Human Computer Interaction","Complex System","High Performance Computing","Project and Professionalism",
                "Artificial Intelligence and Machine Learning","Big Data","Optional Subject"
        }));
        cbm2.setForeground(new Color(0, 0, 0));
        cbm2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        cbm2.setBounds(20, 210, 180, 20);
        contentPane.add(cbm2);

        cbm3 = new JComboBox();
        cbm3.setModel(new DefaultComboBoxModel(new String[] {"Introductory Programming", "Academic Skills", "Fundamentals of Computing", "Embedded Systems Programming",
                "Internet Software","Computational Mathematics","Concepts and Technologies of AI","Object-Oriented Design and Programming",
                "Numerical Methods and Concurrency","Distributed and Cloud System Programming","Collaborative Development",
                "Human Computer Interaction","Complex System","High Performance Computing","Project and Professionalism",
                "Artificial Intelligence and Machine Learning","Big Data","Optional Subject"
        }));
        cbm3.setForeground(new Color(0, 0, 0));
        cbm3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        cbm3.setBounds(20, 240, 180, 20);
        contentPane.add(cbm3);

        cbm4 = new JComboBox();
        cbm4.setModel(new DefaultComboBoxModel(new String[] { "Introductory Programming","Academic Skills", "Fundamentals of Computing", "Embedded Systems Programming",
                "Internet Software","Computational Mathematics","Concepts and Technologies of AI","Object-Oriented Design and Programming",
                "Numerical Methods and Concurrency","Distributed and Cloud System Programming","Collaborative Development",
                "Human Computer Interaction","Complex System","High Performance Computing","Project and Professionalism",
                "Artificial Intelligence and Machine Learning","Big Data","Optional Subject"
        }));
        cbm4.setForeground(new Color(0, 0, 0));
        cbm4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        cbm4.setBounds(20, 270, 180, 20);
        contentPane.add(cbm4);

        cbm5 = new JComboBox();
        cbm5.setModel(new DefaultComboBoxModel(new String[] {"Introductory Programming", "Academic Skills", "Fundamentals of Computing", "Embedded Systems Programming",
                "Internet Software","Computational Mathematics","Concepts and Technologies of AI","Object-Oriented Design and Programming",
                "Numerical Methods and Concurrency","Distributed and Cloud System Programming","Collaborative Development",
                "Human Computer Interaction","Complex System","High Performance Computing","Project and Professionalism",
                "Artificial Intelligence and Machine Learning","Big Data","Optional Subject"
        }));
        cbm5.setForeground(new Color(0, 0, 0));
        cbm5.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        cbm5.setBounds(20, 300, 180, 20);
        contentPane.add(cbm5);

        cbm6 = new JComboBox();
        cbm6.setModel(new DefaultComboBoxModel(new String[]{ "Introductory Programming","Academic Skills", "Fundamentals of Computing", "Embedded Systems Programming",
                "Internet Software","Computational Mathematics","Concepts and Technologies of AI","Object-Oriented Design and Programming",
                "Numerical Methods and Concurrency","Distributed and Cloud System Programming","Collaborative Development",
                "Human Computer Interaction","Complex System","High Performance Computing","Project and Professionalism",
                "Artificial Intelligence and Machine Learning","Big Data","Optional Subject"
        }));
        cbm6.setForeground(new Color(0, 0, 0));
        cbm6.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        cbm6.setBounds(20, 330, 180, 20);
        contentPane.add(cbm6);

        cbst = new JComboBox();
        cbst.setModel(new DefaultComboBoxModel(new String[]{ "Pass","Fail"}));
        cbst.setForeground(new Color(0, 0, 0));
        cbst.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        cbst.setBounds(330, 330, 80, 20);
        contentPane.add(cbst);

        t1 = new JTextField();
        t1.setForeground(new Color(0, 0, 0));
        t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t1.setBounds(174, 60, 156, 20);
        contentPane.add(t1);
        t1.setColumns(10);

        t2 = new JTextField();
        t2.setForeground(new Color(0, 0, 0));
        t2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t2.setColumns(10);
        t2.setBounds(174, 90, 156, 20);
        contentPane.add(t2);

        comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(
                new String[] { "BscIT", "BIBM"}));
        comboBox_1.setForeground(new Color(0, 0, 0));
        comboBox_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        comboBox_1.setBounds(176, 120, 154, 20);
        contentPane.add(comboBox_1);

        comboBox_2 = new JComboBox();
        comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "3", "4", "5", "6" }));
        comboBox_2.setForeground(new Color(0, 0, 0));
        comboBox_2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        comboBox_2.setBounds(176, 150, 154, 20);
        contentPane.add(comboBox_2);

        m1 = new JTextField();
        m1.setForeground(new Color(0, 0, 0));
        m1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        m1.setColumns(10);
        m1.setBounds(220, 180, 100, 20);
        contentPane.add(m1);

        m2 = new JTextField();
        m2.setForeground(new Color(0, 0, 0));
        m2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        m2.setColumns(10);
        m2.setBounds(220, 210, 100, 20);
        contentPane.add(m2);

        m3 = new JTextField();
        m3.setForeground(new Color(0, 0, 0));
        m3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        m3.setColumns(10);
        m3.setBounds(220, 240, 100, 20);
        contentPane.add(m3);

        m4 = new JTextField();
        m4.setForeground(new Color(0, 0, 0));
        m4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        m4.setColumns(10);
        m4.setBounds(220, 270, 100, 20);
        contentPane.add(m4);


        m5 = new JTextField();
        m5.setForeground(new Color(0, 0, 0));
        m5.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        m5.setColumns(10);
        m5.setBounds(220, 300, 100, 20);
        contentPane.add(m5);

        m6 = new JTextField();
        m6.setForeground(new Color(0, 0, 0));
        m6.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        m6.setColumns(10);
        m6.setBounds(220, 330, 100, 20);
        contentPane.add(m6);

        b1 = new JButton("ADD");
        b1.addActionListener(this);
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b1.setBounds(50, 380, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b2.setBounds(200, 380, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);

        b3 = new JButton("Change");
        b3.addActionListener(this);
        b3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b3.setBounds(350, 122, 100, 15);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        contentPane.add(b3);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), " Mark Students ",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel.setBackground(new Color(43, 128, 168));
        panel.setBounds(10, 38, 458, 400);

        contentPane.setBackground(new Color(43, 128, 168));
        panel.setBackground(new Color(43, 128, 168));

        contentPane.add(panel);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            if(ae.getSource() == b1){
                try{
                    connect con = new connect();
                    //sql query for add all the marks from textfields to the columns in database

                    String sql = "update `"+(String)comboBox_1.getSelectedItem() +"` set `"+(String)cbm1.getSelectedItem()+"` = '"+m1.getText()+"' , `"+(String)cbm2.getSelectedItem()+"` = '"+m2.getText()+"' , `"+(String)cbm3.getSelectedItem()+"` = '"+m3.getText()+"' , `"+(String)cbm4.getSelectedItem()+"` = '"+m4.getText()+"' , `"+(String)cbm5.getSelectedItem()+"` = '"+m5.getText()+"' , `"+(String)cbm6.getSelectedItem()+"` = '"+m6.getText()+"' , `level`= '"+(String)comboBox_2.getSelectedItem()+"',`status`= '"+(String) cbst.getSelectedItem()+"' where student_id="+t1.getText()+";";
                    System.out.println(sql);
                    PreparedStatement st = con.c.prepareStatement(sql); //this will prepare the sql statement
                    int i = st.executeUpdate();  //this will execute the statement
                    if (i > 0){
                        JOptionPane.showMessageDialog(null, "Marks Added");
                        this.setVisible(false);
                        new MarkStudents("Admin").setVisible(true);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "error");
                }catch(Exception e){
                    e.printStackTrace(); //to print exception errors
                }
            }
            if(ae.getSource() == b2){
                if (indi=="Admin") {
                    setVisible(false);
                    AdminHome home = new AdminHome();
                    home.setVisible(true);
                }
                else{
                    setVisible(false);
                    InstructorHome home = new InstructorHome();
                    home.setVisible(true);
                }
            }
            if (ae.getSource()==b3){
                // if user selects another course, the combobox for marks will change from here

                cbm1.setModel(new DefaultComboBoxModel(new String[] {"21st Century Management","Preparing Success at University", "Principles of Business", "Project Based Learning",
                        "Responsible Business","Sustainable Business","Innovative Business","Digital Business",
                        "Contemporary Issues in International Business","International HR Professional","Operation and Project Planning",
                        "Managing Finance and Accounts","Strategic Business","Global Context for Multinational Enterprises","Professional Project",
                        "Marketing Consultant"
                }));


                cbm2.setModel(new DefaultComboBoxModel(new String[] {"21st Century Management","Preparing Success at University", "Principles of Business", "Project Based Learning",
                        "Responsible Business","Sustainable Business","Innovative Business","Digital Business",
                        "Contemporary Issues in International Business","International HR Professional","Operation and Project Planning",
                        "Managing Finance and Accounts","Strategic Business","Global Context for Multinational Enterprises","Professional Project",
                        "Marketing Consultant"
                }));


                cbm3.setModel(new DefaultComboBoxModel(new String[] {"21st Century Management","Preparing Success at University", "Principles of Business", "Project Based Learning",
                        "Responsible Business","Sustainable Business","Innovative Business","Digital Business",
                        "Contemporary Issues in International Business","International HR Professional","Operation and Project Planning",
                        "Managing Finance and Accounts","Strategic Business","Global Context for Multinational Enterprises","Professional Project",
                        "Marketing Consultant"
                }));


                cbm4.setModel(new DefaultComboBoxModel(new String[] {"21st Century Management","Preparing Success at University", "Principles of Business", "Project Based Learning",
                        "Responsible Business","Sustainable Business","Innovative Business","Digital Business",
                        "Contemporary Issues in International Business","International HR Professional","Operation and Project Planning",
                        "Managing Finance and Accounts","Strategic Business","Global Context for Multinational Enterprises","Professional Project",
                        "Marketing Consultant"
                }));


                cbm5.setModel(new DefaultComboBoxModel(new String[] {"21st Century Management","Preparing Success at University", "Principles of Business", "Project Based Learning",
                        "Responsible Business","Sustainable Business","Innovative Business","Digital Business",
                        "Contemporary Issues in International Business","International HR Professional","Operation and Project Planning",
                        "Managing Finance and Accounts","Strategic Business","Global Context for Multinational Enterprises","Professional Project",
                        "Marketing Consultant"
                }));
                cbm6.setModel(new DefaultComboBoxModel(new String[]{"21st Century Management","Preparing Success at University", "Principles of Business", "Project Based Learning",
                        "Responsible Business","Sustainable Business","Innovative Business","Digital Business",
                        "Contemporary Issues in International Business","International HR Professional","Operation and Project Planning",
                        "Managing Finance and Accounts","Strategic Business","Global Context for Multinational Enterprises","Professional Project",
                        "Marketing Consultant"
                }));

            }
        }catch(Exception e){

        }
    }
}
// This part will be used for viewing marks of the studentss
class ViewMarks extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTable table;
    private JTextField t1;
    private JButton b1,b2;
    public static void main(String[] args) {
        new ViewMarks().setVisible(true);
    }

    public void marks() {
        try {
            connect con = new connect();
            String sql = "select * from bscit where student_id="+t1.getText()+"";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            st.close();
            con.c.close();
        } catch (Exception e) {

        }
    }
    public void marksbibm() {
        try {
            connect con = new connect();
            String sql = "select * from bibm where student_id="+t1.getText()+"";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            st.close();
            con.c.close();
        } catch (Exception e) {

        }
    }

    public ViewMarks() {
        setBounds(350, 200, 890, 475);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(43, 128, 168));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(5, 133, 1530, 288);
        contentPane.add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                int row = table.getSelectedRow();
            }
        });
        table.setBackground(new Color(43, 128, 168));
        table.setForeground(Color.BLACK);
        table.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        scrollPane.setViewportView(table);

        JLabel l1 = new JLabel("View Marks");
        l1.setForeground(new Color(0, 0, 0));
        l1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 26));
        l1.setBounds(250, 20, 400, 47);
        contentPane.add(l1);

        JLabel l2 = new JLabel("<--");
        l2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                StudentHome home = new StudentHome();
                home.setVisible(true);
            }
        });
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        l2.setBounds(90, 90, 72, 33);
        contentPane.add(l2);

        t1 = new JTextField();
        t1.setText("Student ID");
        t1.setForeground(new Color(0, 0, 0));
        t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t1.setBounds(160, 90, 156, 20);
        contentPane.add(t1);
        t1.setColumns(10);

        b1 = new JButton("Search in BscIT");
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(350, 80, 200, 20);
        contentPane.add(b1);

        b2 = new JButton("Search in BIBM");
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(350, 110, 200, 20);
        contentPane.add(b2);

    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==b1){
            marks();
        }
        if (ae.getSource()==b2){
            marksbibm();
        }

    }
}

