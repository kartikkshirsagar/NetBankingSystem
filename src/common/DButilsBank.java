package common;

import PayPackage.Account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static common.connectDB.connectToDB;

public class DButilsBank {
    public static Account getAccObj(String username) throws SQLException, ClassNotFoundException {

        Connection con=connectToDB();
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM login WHERE username="+username+"; ");
        int acc_no = rs.getInt("acc_no");
        stmt=con.createStatement();
        rs=stmt.executeQuery("SELECT * FROM accounts WHERE acc_no="+acc_no+";");
        Account ret=new Account(rs.getString("acc_holder"),acc_no,rs.getInt("balance"));
        con.close();
        return ret;
    }
    public static void UpdateBal(Account obj) throws SQLException, ClassNotFoundException {
        Connection con=connectToDB();
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("UPDATE accounts SET balance = "+obj.getBalance()+" WHERE acc_no="+obj.getAccount_Number()+"; ");
        con.close();
    }
}
