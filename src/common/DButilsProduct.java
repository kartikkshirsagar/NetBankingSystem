package common;

import MallPack.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static common.connectDB.connectToDB;

public class DButilsProduct {
    public static ArrayList<Product> getProducts() throws SQLException, ClassNotFoundException {
        Connection con=connectToDB();
        ArrayList<Product> products=null;
        Statement stmt=con.createStatement();
        String query="SELECT * FROM products";
        ResultSet res=stmt.executeQuery(query);
        while(res.next())
        {
            if(res.getInt("quantity")!=0)
            {
                //If not zero,then only this product will be displayed
                products.add(new Product(res.getString("name"),res.getInt("id"),res.getInt("price"),res.getString("description"),res.getInt("quantity")));
            }
        }
        con.close();
        return products;
    }

    public static Boolean ProductSold(int product_id) throws SQLException, ClassNotFoundException {
        //return will tell is succesful or not
        Boolean retval=false;
        Connection con=connectToDB();
        Statement stmt=con.createStatement();
        String query="SELECT * FROM products WHERE id="+product_id;
        ResultSet res=stmt.executeQuery(query);
        if(res.next())
        {
            int quantity;
            if(res.getInt("quantity")>=1)
            {
                quantity=res.getInt("quantity");
                quantity=quantity-1;
                String update="UPDATE products set quantity="+quantity;
                stmt.executeUpdate(update);
                retval=true;
            }
        }
        con.close();
        return retval;
    }

    public static void ProductQuantityUpdate(int product_id) throws SQLException, ClassNotFoundException {
        Connection con=connectToDB();
        Statement stmt=con.createStatement();
        ResultSet res=stmt.executeQuery("SELECT * FROM products WHERE id="+product_id);
        if(res.next())
        {
            String query="UPDATE products set quatity="+(res.getInt("quantity")+1)+" WHERE id="+product_id;
            stmt.executeUpdate(query);
        }
        /*
        else
        {
            String query="INSERT INTO products VALUES ("+P.getName()+","+P.getId()+","+P.getPrice()+","+P.getDescription()+",1)";
            stmt.executeUpdate(query);
        }
         */
    }

    public static Product getProductInfo(int product_id) throws SQLException, ClassNotFoundException {
        Connection con=connectToDB();
        Statement stmt=con.createStatement();
        ResultSet res=stmt.executeQuery("SELECT * FROM products WHERE id="+product_id);
        if(res.next())
        {
            return new Product(res.getString("name"),res.getInt("id"),res.getInt("price"),res.getString("description"),res.getInt("quantity"));
        }
    }
}
