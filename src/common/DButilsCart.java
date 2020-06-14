package common;

import MallPack.Product;
import PayPackage.Account;

import java.net.UnknownServiceException;
import java.sql.*;
import java.util.ArrayList;

import static common.DButilsBank.UpdateBal;
import static common.DButilsBank.getAccObj;
import static common.DButilsProduct.*;
import static common.connectDB.connectToCart;
import static common.connectDB.connectToDB;

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
        System.out.println("in create cart");
        if(con!=null)
        {
            Statement stmt=con.createStatement();
            String query="CREATE TABLE "+Username.toLowerCase()+" "+"(product_id INT NOT NULL," +
                    "quantity INT NOT NULL)";//Cost is not kept here,get via other backend
            stmt.executeUpdate(query);
            con.close();
        }
    }

    public static void addToCart(String Username,int product_id) throws SQLException, ClassNotFoundException {
        Connection con=connectToCart();
        Boolean already,updateproduct;
        //updateproduct= ProductSold(product_id);
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
            String insert="INSERT INTO "+Username+" VALUES ('"+product_id+"',"+"1 )";
            stmt.executeUpdate(insert);
        }

    }

    public static void removeFromCart(String Username,int product_id) throws SQLException, ClassNotFoundException {
        Connection con=connectToCart();
        //Assumption-Product exists in cart
        Statement stmt=con.createStatement();
        ResultSet res=stmt.executeQuery("SELECT * FROM "+Username+" WHERE product_id="+product_id);
        if(res.next())
        {
            String query;
            if(res.getInt("quantity")==1)
            {
                query="DELETE FROM "+Username+" WHERE product_id="+product_id;
                stmt.executeUpdate(query);
                //Check to see empty cart
                String check="SELECT * FROM "+Username;
                ResultSet rs=stmt.executeQuery(check);
                if(rs.next())
                {
                    //cart is not empty
                }
                else
                {
                    //cart is empty
                    //Drop table
                    DropCart(Username);
                }
            }
            else
                {
                    int q=res.getInt("quantity");
                    q=q-1;
                query="UPDATE "+Username+" set quantity="+q+" WHERE product_id="+product_id;
                stmt.executeUpdate(query);
            }
            //ProductQuantityUpdate(product_id);
        }
    }

    public static ArrayList<Product> getCart(String Username) throws SQLException, ClassNotFoundException {
        Connection con=connectToCart();
        ArrayList<Product> products=new ArrayList<Product>();
        if(doesTableExist(Username)==false)
        {
            //Cart is empty
        }
        else
        {
            Statement stmt=con.createStatement();
            ResultSet res=stmt.executeQuery("SELECT * FROM "+Username);
            int product_id,quantity;
            double total=0;
            Product P;
            while(res.next())
            {
                product_id=res.getInt("product_id");
                quantity=res.getInt("quantity");
                P=getProductInfo(product_id);
                P.setQuantity(quantity);
                int price=P.getPrice();

                products.add(new Product(P.getName(),product_id,price,P.getDescription(),quantity));
            }

        }
        return products;
    }

    public static void DropCart(String Username) throws SQLException, ClassNotFoundException {
        Connection cart = connectToCart();
        //Boolean retval;
        Account User = getAccObj(Username);
        //if(User.getBalance() >= Total_cost)
        //{
        //   retval=true;
        Statement stmt = cart.createStatement();
        String drop = "DROP TABLE " + Username.toLowerCase();
        stmt.executeUpdate(drop);
        //User.setBalance(User.getBalance()-Total_cost);
        //UpdateBal(User);
        cart.close();
        //}
       /*else
       {
           retval=false;
           //Transaction not possible,redirect to error page...
       }
       return retval;
       */
    }
    public static int getTotal(ArrayList<Product> list)
    {
        int sum=0;
        for(Product p:list){
            sum=sum+p.getPrice();
        }
        return sum;
    }
}
