package common;
import java.sql.*;
import java.util.Random;

public class DButilsLogin {
    void Print() throws SQLException, ClassNotFoundException {
        Connection con = common.connectDB.connectToDB();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from emp");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
        }
        con.close();
    }

    public static void InsertLogin(String name, String pass) throws SQLException, ClassNotFoundException {
        Connection con = common.connectDB.connectToDB();
        Statement stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO login(username,password)VALUES ('" + name + "','" + pass + "')");
        con.close();
    }

    void CreateTable() throws SQLException, ClassNotFoundException { //USE THIS METHOD ONLY ONCE IF YOU DONT HAVE TABLE CREATED
        Connection con = common.connectDB.connectToDB();
        Statement stmt = con.createStatement();
        stmt.executeQuery("CREATE TABLE `login` (`username` varchar(20) NOT NULL,`password` varchar(45) NOT NULL,PRIMARY KEY (`username`),UNIQUE KEY `username_UNIQUE` (`username`) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;");
        con.close();
    }

    public static void InsertAcc(String name) throws SQLException, ClassNotFoundException {
        Connection con = common.connectDB.connectToDB();
        Statement stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO accounts(acc_holder,balance) VALUES('"+name+"',0); ");
        con.close();
    }

    public static boolean ifUserExists(String uname) throws SQLException,ClassNotFoundException{
        boolean ret=false;//available
        Connection con=connectDB.connectToDB();
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM login WHERE username='"+uname+"';");
        if(rs.next())
        {
            ret=true;//exists and username not available
        }
        return ret;
    }

    public static int GenerateAccNo(){
        int Acc_no = new Random().nextInt(900000)+100000;
        return Acc_no;
    }

    public static Boolean DoesAccExist(int Acc_No) throws SQLException, ClassNotFoundException {
        Connection con=connectDB.connectToDB();
        Statement stmt=con.createStatement();
        String query="SELECT * FROM login WHERE acc_no="+Acc_No+"";
        ResultSet rs=stmt.executeQuery(query);
        Boolean retval=false;
        if(rs.next())
        {
            retval=true;
        }
        con.close();
        return retval;

    }

    public static void InsertIntoDatabase(String Username,String password,String name) throws SQLException, ClassNotFoundException {
        Connection con=connectDB.connectToDB();
        Statement stmt=con.createStatement();
        int acc_no;
        acc_no=GenerateAccNo();
        while(DoesAccExist(acc_no)==true)
        {
            acc_no=GenerateAccNo();
        }
        String insertAccounts="INSERT INTO accounts(acc_no,acc_holder,balance) VALUES ('"+acc_no+"','"+name+"','"+"0')";
        stmt.executeUpdate(insertAccounts);
        String insertlogin="INSERT INTO login(username,password,acc_no) VALUES ('"+Username+"','"+password+"','"+acc_no+"')";
        stmt.executeUpdate(insertlogin);
        con.close();
    }


}
