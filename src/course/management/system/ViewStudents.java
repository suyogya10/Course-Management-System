package course.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;

public class ViewStudents extends JFrame{

    private JPanel contentPane;
    private JTable table;
    String indi;

    public static void main(String[] args) {
        new ViewStudents("Admin").setVisible(true);
    }

    public void student() {
        try {
            connect con = new connect();
            String sql = "select * from student";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            st.close();
            con.c.close();
        } catch (Exception e) {

        }
    }

    public ViewStudents(String indicator) {
        indi=indicator;
        setBounds(350, 200, 890, 475);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(43, 128, 168));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(79, 133, 771, 288);
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

        JLabel l1 = new JLabel("Student Details");
        l1.setForeground(new Color(0, 0, 0));
        l1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 26));
        l1.setBounds(250, 20, 400, 47);
        contentPane.add(l1);

        //override allows a subclass or child class to provide a specific implementation of a method
        JLabel l2 = new JLabel("<--");
        l2.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (indi=="Admin") {
                    setVisible(false);
                    ManageStudent home = new ManageStudent();
                    home.setVisible(true);
                }
                else{
                    setVisible(false);
                    InstructorHome home = new InstructorHome();
                    home.setVisible(true);
                }
            }
        });
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        l2.setBounds(97, 89, 72, 33);
        contentPane.add(l2);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3, true), "Student-Details",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel.setBounds(68, 59, 790, 370);
        panel.setBackground(new Color(43, 128, 168));
        contentPane.add(panel);
        student();
    }
}
