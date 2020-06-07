package common;
import java.sql.*;
public class DButils {
    void Print() throws SQLException, ClassNotFoundException {
        Connection con=common.connectDB.connectToDB();
        Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from emp");
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            }
            con.close();
    }
    void InsertLogin(String name, String pass) throws SQLException, ClassNotFoundException {
        Connection con=common.connectDB.connectToDB();
        Statement stmt=con.createStatement();
        stmt.executeQuery("INSERT INTO login(username,password)VALUES ('"+name +"','"+pass+"')");
        con.close();
    }
    void CreateTable() throws SQLException, ClassNotFoundException { //USE THIS METHOD ONLY ONCE IF YOU DONT HAVE TABLE CREATED
        Connection con=common.connectDB.connectToDB();
        Statement stmt=con.createStatement();
        stmt.executeQuery("CREATE TABLE `login` (`username` varchar(20) NOT NULL,`password` varchar(45) NOT NULL,PRIMARY KEY (`username`),UNIQUE KEY `username_UNIQUE` (`username`) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;");
        con.close();
    }
}
