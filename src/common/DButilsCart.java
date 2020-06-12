package common;

import java.sql.*;

import static common.connectDB.connectToCart;

public class DButilsCart {
    public static Boolean doesTableExist(String Username) throws SQLException, ClassNotFoundException {
        Boolean retval=false;
        Connection con=connectToCart();
        if(con!=null)
        {
            DatabaseMetaData dbm=con.getMetaData();
            ResultSet tables=dbm.getTables(null,null,Username,null);
            if(tables.next())
            {
                retval=true;
            }
            else
            {
                retval=false;
            }
            con.close();
        }
        return retval;
    }

    public static void CreateCart(String Username) throws SQLException, ClassNotFoundException {
        //This method does not check anything about existing tables
        //Handle in page backend.....
        Connection con=connectToCart();
        if(con!=null)
        {
            Statement stmt=con.createStatement();
            String query="CREATE TABLE "+Username+" "+"(product_id INT NOT NULL," +
                    "quantity INT NOT NULL )";//Cost is not kept here,get via other backend
            stmt.executeUpdate(query);
            con.close();
        }
    }

    public static void UpdateCart(String Username,int product_id) throws SQLException, ClassNotFoundException {
        Connection con=connectToCart();
        Boolean already;
        already=doesTableExist(Username);
        if(already==false)
        {
            CreateCart(Username);
        }
        Statement stmt=con.createStatement();
        String query="SELECT * FROM "+Username+" WHERE product_id="+product_id+"";
        ResultSet res=stmt.executeQuery(query);
        if(res.next())
        {
            //Some items of this id already exist
            //Increment this here and update database
            int quantity=res.getInt("quantity");//quantity
            quantity=quantity+1;
            String update="UPDATE "+Username+" set quantity="+quantity+"";
            stmt.executeUpdate(update);
        }
        else
        {
            String insert="INSERT INTO "+Username+" VALUES ("+product_id+","+"1 )";
            stmt.executeUpdate(insert);
        }
    }
}
