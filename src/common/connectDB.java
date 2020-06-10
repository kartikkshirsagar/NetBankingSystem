package common;
import java.sql.*;
public class connectDB {
    public static Connection connectToDB() throws ClassNotFoundException,SQLException {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nbs","root","root");
            return con;
    }
}

