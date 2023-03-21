package course.management.system;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
//this will be used for adding or deleteing students

public class ManageStudent extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t1,t2,t3;
    private JComboBox comboBox, comboBox_1, comboBox_2, comboBox_3;
    JButton b1,b2,b3,b4;

    public static void main(String[] args) {
        new ManageStudent().setVisible(true);
    }

    //creating method to generate random number
    public void random() {
        Random rd = new Random();
        t1.setText("" + rd.nextInt(10000 + 1));
    }

    public ManageStudent() {
        super("Add Student");
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

        b1 = new JButton("ADD");
        b1.addActionListener(this);
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b1.setBounds(24, 270, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        b3 = new JButton("Delete");
        b3.addActionListener(this);
        b3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b3.setBounds(150, 270, 111, 33);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        contentPane.add(b3);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b2.setBounds(150, 320, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);

        b4 = new JButton("View All");
        b4.addActionListener(this);
        b4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b4.setBounds(280, 270, 111, 33);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        contentPane.add(b4);

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
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), " Add/Delete- Students ",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel.setBackground(new Color(43, 128, 168));
        panel.setBounds(10, 38, 458, 348);
        contentPane.setBackground(new Color(43, 128, 168));
        contentPane.add(panel);

        random(); //use of method. or implementation of polymorphism
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
                        JOptionPane.showMessageDialog(null, "Successfully Added");
                        this.setVisible(false);
                        new ManageStudent().setVisible(true);
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
            if (ae.getSource() == b3){
                this.setVisible(false);
                new DeleteStudent().setVisible(true);
            }

            if(ae.getSource() == b2){
                this.setVisible(false);
                new AdminHome().setVisible(true);
            }
            if(ae.getSource() == b4){
                this.setVisible(false);
                new ViewStudents("Admin").setVisible(true);
            }
        }catch(Exception e){

        }
    }
}

class DeleteStudent extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t1,t2,t3,t4;
    private JButton b1,b2,b3;
    private JComboBox comboBox_1;

    public static void main(String[] args) {
        new DeleteStudent().setVisible(true);
    }

    public DeleteStudent() {
        setBounds(600, 200, 450, 350);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel l1 = new JLabel("Student ID");
        l1.setForeground(new Color(0, 0, 0));
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(53, 80, 110, 22);
        contentPane.add(l1);

        t2 = new JTextField();
        t2.setForeground(new Color(0, 0, 0));
        t2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t2.setColumns(10);
        t2.setBounds(169, 82, 198, 20);
        contentPane.add(t2);

        JLabel l2 = new JLabel("Course");
        l2.setForeground(new Color(0, 0, 0));
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(53, 120, 110, 22);
        contentPane.add(l2);

        comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(
                new String[] { "BscIT", "bibm"}));
        comboBox_1.setForeground(new Color(0, 0, 0));
        comboBox_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        comboBox_1.setBounds(176, 120, 154, 20);
        contentPane.add(comboBox_1);

        b3 = new JButton("Delete");
        b3.addActionListener(this);
        b3.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128)), null));
        b3.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b3.setBounds(150, 180, 100, 33);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        contentPane.add(b3);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setBorder(new CompoundBorder(new LineBorder(new Color(105, 105, 105)), null));
        b2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b2.setBounds(150, 250, 108, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Delete Student", TitledBorder.LEADING,
                TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel.setBounds(10, 29, 398, 200);
        contentPane.add(panel);
        panel.setBackground(new Color(43, 128, 168));
        contentPane.setBackground(new Color(43, 128, 168));

    }

    public void actionPerformed(ActionEvent ae){
        try{
            connect con = new connect();
            if(ae.getSource() == b3){
                String sql = "delete from student where student_id=?";
                String sql2 = "delete from "+(String)comboBox_1.getSelectedItem()+" where student_id=?";
                PreparedStatement st = con.c.prepareStatement(sql);
                PreparedStatement st2 = con.c.prepareStatement(sql2);
                st.setString(1, t2.getText());
                st2.setString(1, t2.getText());
                int i = st.executeUpdate();
                st2.executeUpdate();
                if (i > 0)
                    JOptionPane.showMessageDialog(null, "Student '"+t2.getText()+"' Deleted!");
            }
            if(ae.getSource() == b2){
                this.setVisible(false);
                new ManageStudent().setVisible(true);

            }
            con.c.close();
        }catch(Exception e){

        }
    }
}


