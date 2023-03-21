package course.management.system;
import java.sql.*;
//connecting our java files with the database.
public class connect {
        Connection c;
        Statement s;
        public connect(){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); //installing JDBC driver
                c = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursemgmt", "root", "");
                s = c.createStatement();

            }catch (Exception e){
                System.out.println(e);
            }

        }
}
