package course.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class ManageCourse extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t1,t2;
    private JButton b1,b2,b3,b4,b5;
    private JComboBox comboBox;

    public static void main(String[] args) {
        new ManageCourse().setVisible(true);
    }

    public ManageCourse() {
        setBounds(600, 200, 450, 380);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel l1 = new JLabel("Course ID");
        l1.setForeground(new Color(0, 0, 0));
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(53, 60, 110, 22);
        contentPane.add(l1);

        JLabel l2 = new JLabel("Course Name");
        l2.setForeground(new Color(0, 0, 0));
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(53, 90, 110, 22);
        contentPane.add(l2);

        JLabel l3 = new JLabel("Course Status");
        l3.setForeground(new Color(0, 0, 0));
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setBounds(53, 120, 110, 22);
        contentPane.add(l3);

        t1 = new JTextField();
        t1.setForeground(new Color(0, 0, 0));
        t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t1.setBounds(169, 60, 198, 20);
        contentPane.add(t1);
        t1.setColumns(10);

        t2 = new JTextField();
        t2.setForeground(new Color(0, 0, 0));
        t2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t2.setColumns(10);
        t2.setBounds(169, 90, 198, 20);
        contentPane.add(t2);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(
                new String[] { "Active", "Cancelled"}));
        comboBox.setForeground(new Color(0, 0, 0));
        comboBox.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        comboBox.setBounds(169, 120, 154, 20);
        contentPane.add(comboBox);

        b1 = new JButton("Add");
        b1.addActionListener(this);
        b1.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128)), null));
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b1.setBounds(24, 200, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        b3 = new JButton("Delete");
        b3.addActionListener(this);
        b3.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128)), null));
        b3.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b3.setBounds(150, 200, 111, 33);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        contentPane.add(b3);

        b4 = new JButton("View All");
        b4.addActionListener(this);
        b4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b4.setBounds(280, 200, 111, 33);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        contentPane.add(b4);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setBorder(new CompoundBorder(new LineBorder(new Color(105, 105, 105)), null));
        b2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b2.setBounds(150, 250, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);

        b5 = new JButton("Update");
        b5.addActionListener(this);
        b5.setBorder(new CompoundBorder(new LineBorder(new Color(105, 105, 105)), null));
        b5.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b5.setBounds(30, 250, 111, 33);
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        contentPane.add(b5);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "manage Course", TitledBorder.LEADING,
                TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel.setBounds(10, 29, 398, 300);
        contentPane.add(panel);
        panel.setBackground(new Color(43, 128, 168));
        contentPane.setBackground(new Color(43, 128, 168));

    }

    public void actionPerformed(ActionEvent ae){
        try{
            connect con = new connect();
            if(ae.getSource() == b1){
                String sql = "insert into coursedb(course_id, course_name, status) values(?, ?,?)";
                String sql2 = "create table "+t2.getText()+"(student_id int)";
                PreparedStatement st = con.c.prepareStatement(sql);
                PreparedStatement st2 = con.c.prepareStatement(sql2);
                // st.setInt(1, Integer.parseInt(textField.getText()));
                st.setString(1, t1.getText());
                st.setString(2, t2.getText());
                st.setString(3,(String) comboBox.getSelectedItem());
                int rs = st.executeUpdate();
                st2.executeUpdate();
                if (rs > 0) {
                    JOptionPane.showMessageDialog(null, "Successfully Added");
                }else
                    JOptionPane.showMessageDialog(null, "Error in Adding");
                t1.setText("");
                t2.setText("");
                st.close();}
            if(ae.getSource() == b3){
                String sql = "delete from coursedb where course_id=?";
                String sql2 = "drop table "+t2.getText()+"";
                PreparedStatement st = con.c.prepareStatement(sql);
                PreparedStatement st2 = con.c.prepareStatement(sql2);
                st.setString(1, t1.getText());
                int i = st.executeUpdate();
                st2.executeUpdate();
                if (i > 0)
                    JOptionPane.showMessageDialog(null, "Course '"+t2.getText()+"' Deleted!");
                else
                    JOptionPane.showMessageDialog(null, "Error in Deleting");
                    st.close();
                    t1.setText("");
                    t2.setText("");
            }
            if(ae.getSource() == b5){
                String sql = "update coursedb set status=? where course_name=?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1,(String) comboBox.getSelectedItem());
                st.setString(2, t2.getText());

                int i = st.executeUpdate();
                if (i > 0)
                    JOptionPane.showMessageDialog(null, "Course '"+t2.getText()+"' Updated!");
                else
                    JOptionPane.showMessageDialog(null, "Error in Updating");
                    st.close();
                    t1.setText("");
                    t2.setText("");
            }
            if(ae.getSource() == b2){
                this.setVisible(false);
                new AdminHome().setVisible(true);

            }
            if(ae.getSource() == b4){
                this.setVisible(false);
                new ViewCourses().setVisible(true);

            }
            con.c.close();
        }catch(Exception e){

        }
    }
}