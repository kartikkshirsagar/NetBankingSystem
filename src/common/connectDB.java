package common;
import java.sql.*;
public class connectDB {
    public static Connection connectToDB() throws ClassNotFoundException,SQLException {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nbs","root","Karan@123");
            return con;
    }

    public static Connection connectToCart() throws ClassNotFoundException,SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cart","root","Karan@123");
        return con;
    }
    //cart database will contain a table for each username of nbs db
}

