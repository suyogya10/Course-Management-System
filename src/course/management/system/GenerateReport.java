package course.management.system;
import net.proteanit.sql.DbUtils;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class GenerateReport extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTable table;
    private JTextField t1;
    private JButton b1,b2,b3,b4;
    String status;
    public static void main(String[] args) {
        new GenerateReport().setVisible(true);
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
    public void generatebscit() {
        try {
            connect con = new connect();
            String sql = "select * from bscit where student_id="+t1.getText()+"";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                status = rs.getString("status");
            }
            rs.close();
            st.close();
            con.c.close();
        } catch (Exception e) {

        }
    }
    public void generatebibm() {
        try {
            connect con = new connect();
            String sql = "select * from bibm where student_id="+t1.getText()+"";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                status = rs.getString("status");
            }
            rs.close();
            st.close();
            con.c.close();
        } catch (Exception e) {

        }
    }

    public GenerateReport() {
        setBounds(350, 200, 900, 500);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setBackground(new Color(43, 128, 168));
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(5, 133, 1530, 288);
        scrollPane.setBackground(new Color(43, 128, 168));
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

        JLabel l1 = new JLabel("Generate Report");
        l1.setForeground(new Color(0, 0, 0));
        l1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 26));
        l1.setBounds(250, 20, 400, 47);
        contentPane.add(l1);

        JLabel l2 = new JLabel("<--");
        l2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                AdminHome home = new AdminHome();
                home.setVisible(true);
            }
        });
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
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

        b3 = new JButton("Generate Report (BscIT)");
        b3.addActionListener(this);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(580, 80, 200, 20);
        contentPane.add(b3);

        b4 = new JButton("Generate Report (BIBM)");
        b4.addActionListener(this);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setBounds(580, 110, 200, 20);
        contentPane.add(b4);

    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==b1){
            marks();
        }
        if (ae.getSource()==b2){
            marksbibm();
        }
        if (ae.getSource()==b3){
            generatebscit();
            JLabel g = new JLabel("--------------------------------------------------REPORT--------------------------------------------------");
            g.setForeground(new Color(0, 0, 0));
            g.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 26));
            g.setBounds(10, 420, 4000, 47);
            contentPane.add(g);
            if (status.equals("Pass")){
                JLabel gp = new JLabel("Congratulations! You can proceed to another semester.");
                gp.setForeground(new Color(0, 0, 0));
                gp.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 26));
                gp.setBounds(10, 475, 4000, 30);
                contentPane.add(gp);
            }
            if (status.equals("Fail")){
                JLabel gf = new JLabel("Sorry! You can not proceed to another semester.");
                gf.setForeground(new Color(0, 0, 0));
                gf.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 26));
                gf.setBounds(10, 475, 4000, 30);
                contentPane.add(gf);
            }

            JLabel g2 = new JLabel("---------------------------------------------------------------------------------------------------------------");
            g2.setForeground(new Color(0, 0, 0));
            g2.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 26));
            g2.setBounds(10, 520, 4000, 47);
            contentPane.add(g2);

        }
        if (ae.getSource()==b4){
            generatebibm();
            JLabel g = new JLabel("--------------------------------------------------REPORT--------------------------------------------------");
            g.setForeground(new Color(0, 0, 0));
            g.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 26));
            g.setBounds(10, 420, 4000, 47);
            contentPane.add(g);
            if (status.equals("Pass")){
                JLabel gp = new JLabel("Congratulations! You can proceed to another semester.");
                gp.setForeground(new Color(0, 0, 0));
                gp.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 26));
                gp.setBounds(10, 475, 4000, 30);
                contentPane.add(gp);
            }
            if (status.equals("Fail")){
                JLabel gf = new JLabel("Sorry! You can not proceed to another semester.");
                gf.setForeground(new Color(0, 0, 0));
                gf.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 26));
                gf.setBounds(10, 475, 4000, 30);
                contentPane.add(gf);
            }

            JLabel g2 = new JLabel("---------------------------------------------------------------------------------------------------------------");
            g2.setForeground(new Color(0, 0, 0));
            g2.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 26));
            g2.setBounds(10, 520, 4000, 47);
            contentPane.add(g2);
        }

    }
}