package common;

import MallPack.Product;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.*;
import java.util.ArrayList;

import static common.connectDB.connectToDB;

public class DButilsProduct {
    public static ArrayList<Product> getProducts() throws SQLException, ClassNotFoundException {
        Connection con=connectToDB();
        ArrayList<Product> products=new ArrayList<Product>();
        Statement stmt=con.createStatement();
        String query="SELECT * FROM products";
        ResultSet res=stmt.executeQuery(query);
        while(res.next())
        {
                //If not zero,then only this product will be displayed
                products.add(new Product(res.getString("name"),res.getInt("id"),res.getInt("price"),res.getString("description"),1));
        }
        con.close();
        return products;
    }

//    public static Boolean ProductSold(int product_id) throws SQLException, ClassNotFoundException {
//        //return will tell is succesful or not
//        Boolean retval=false;
//        Connection con=connectToDB();
//        Statement stmt=con.createStatement();
//        String query="SELECT * FROM products WHERE id="+product_id;
//        ResultSet res=stmt.executeQuery(query);
//        if(res.next())
//        {
//            int quantity;
//            if(res.getInt("quantity")>=1)
//            {
//                quantity=res.getInt("quantity");
//                quantity=quantity-1;
//                String update="UPDATE products set quantity="+quantity;
//                stmt.executeUpdate(update);
//                retval=true;
//            }
//        }
//        con.close();
//        return retval;
//    }
//
//    public static void ProductQuantityUpdate(int product_id) throws SQLException, ClassNotFoundException {
//        Connection con=connectToDB();
//        Statement stmt=con.createStatement();
//        ResultSet res=stmt.executeQuery("SELECT * FROM products WHERE id="+product_id);
//        if(res.next())
//        {
//            String query="UPDATE products set quatity="+(res.getInt("quantity")+1)+" WHERE id="+product_id;
//            stmt.executeUpdate(query);
//        }
//        /*
//        else
//        {
//            String query="INSERT INTO products VALUES ("+P.getName()+","+P.getId()+","+P.getPrice()+","+P.getDescription()+",1)";
//            stmt.executeUpdate(query);
//        }
//         */
//    }

    public static Product getProductInfo(int product_id) throws SQLException, ClassNotFoundException {
        Connection con=connectToDB();
        Statement stmt=con.createStatement();
        ResultSet res=stmt.executeQuery("SELECT * FROM products WHERE id="+product_id);
        if(res.next())
        {
            return new Product(res.getString("name"),res.getInt("id"),res.getInt("price"),res.getString("description"),1);
        }
        return null;
    }

    public static JSONArray convert(ResultSet rs) throws SQLException,
            JSONException {
        JSONArray json = new JSONArray();
        ResultSetMetaData rsmd = rs.getMetaData();
        int numColumns = rsmd.getColumnCount();
        while (rs.next()) {

            JSONObject obj = new JSONObject();

            for (int i = 1; i < numColumns + 1; i++) {
                String column_name = rsmd.getColumnName(i);

                if (rsmd.getColumnType(i) == java.sql.Types.ARRAY) {
                    obj.put(column_name, rs.getArray(column_name));
                } else if (rsmd.getColumnType(i) == java.sql.Types.BIGINT) {
                    obj.put(column_name, rs.getLong(column_name));
                } else if (rsmd.getColumnType(i) == java.sql.Types.REAL) {
                    obj.put(column_name, rs.getFloat(column_name));
                } else if (rsmd.getColumnType(i) == java.sql.Types.BOOLEAN) {
                    obj.put(column_name, rs.getBoolean(column_name));
                } else if (rsmd.getColumnType(i) == java.sql.Types.BLOB) {
                    obj.put(column_name, rs.getBlob(column_name));
                } else if (rsmd.getColumnType(i) == java.sql.Types.DOUBLE) {
                    obj.put(column_name, rs.getDouble(column_name));
                } else if (rsmd.getColumnType(i) == java.sql.Types.FLOAT) {
                    obj.put(column_name, rs.getDouble(column_name));
                } else if (rsmd.getColumnType(i) == java.sql.Types.INTEGER) {
                    obj.put(column_name, rs.getInt(column_name));
                } else if (rsmd.getColumnType(i) == java.sql.Types.NVARCHAR) {
                    obj.put(column_name, rs.getNString(column_name));
                } else if (rsmd.getColumnType(i) == java.sql.Types.VARCHAR) {
                    obj.put(column_name, rs.getString(column_name));
                } else if (rsmd.getColumnType(i) == java.sql.Types.CHAR) {
                    obj.put(column_name, rs.getString(column_name));
                } else if (rsmd.getColumnType(i) == java.sql.Types.NCHAR) {
                    obj.put(column_name, rs.getNString(column_name));
                } else if (rsmd.getColumnType(i) == java.sql.Types.LONGNVARCHAR) {
                    obj.put(column_name, rs.getNString(column_name));
                } else if (rsmd.getColumnType(i) == java.sql.Types.LONGVARCHAR) {
                    obj.put(column_name, rs.getString(column_name));
                } else if (rsmd.getColumnType(i) == java.sql.Types.TINYINT) {
                    obj.put(column_name, rs.getByte(column_name));
                } else if (rsmd.getColumnType(i) == java.sql.Types.SMALLINT) {
                    obj.put(column_name, rs.getShort(column_name));
                } else if (rsmd.getColumnType(i) == java.sql.Types.DATE) {
                    obj.put(column_name, rs.getDate(column_name));
                } else if (rsmd.getColumnType(i) == java.sql.Types.TIME) {
                    obj.put(column_name, rs.getTime(column_name));
                } else if (rsmd.getColumnType(i) == java.sql.Types.TIMESTAMP) {
                    obj.put(column_name, rs.getTimestamp(column_name));
                } else if (rsmd.getColumnType(i) == java.sql.Types.BINARY) {
                    obj.put(column_name, rs.getBytes(column_name));
                } else if (rsmd.getColumnType(i) == java.sql.Types.VARBINARY) {
                    obj.put(column_name, rs.getBytes(column_name));
                } else if (rsmd.getColumnType(i) == java.sql.Types.LONGVARBINARY) {
                    obj.put(column_name, rs.getBinaryStream(column_name));
                } else if (rsmd.getColumnType(i) == java.sql.Types.BIT) {
                    obj.put(column_name, rs.getBoolean(column_name));
                } else if (rsmd.getColumnType(i) == java.sql.Types.CLOB) {
                    obj.put(column_name, rs.getClob(column_name));
                } else if (rsmd.getColumnType(i) == java.sql.Types.NUMERIC) {
                    obj.put(column_name, rs.getBigDecimal(column_name));
                } else if (rsmd.getColumnType(i) == java.sql.Types.DECIMAL) {
                    obj.put(column_name, rs.getBigDecimal(column_name));
                } else if (rsmd.getColumnType(i) == java.sql.Types.DATALINK) {
                    obj.put(column_name, rs.getURL(column_name));
                } else if (rsmd.getColumnType(i) == java.sql.Types.REF) {
                    obj.put(column_name, rs.getRef(column_name));
                } else if (rsmd.getColumnType(i) == java.sql.Types.STRUCT) {
                    obj.put(column_name, rs.getObject(column_name)); // must be a custom mapping consists of a class that implements the interface SQLData and an entry in a java.util.Map object.
                } else if (rsmd.getColumnType(i) == java.sql.Types.DISTINCT) {
                    obj.put(column_name, rs.getObject(column_name)); // must be a custom mapping consists of a class that implements the interface SQLData and an entry in a java.util.Map object.
                } else if (rsmd.getColumnType(i) == java.sql.Types.JAVA_OBJECT) {
                    obj.put(column_name, rs.getObject(column_name));
                } else {
                    obj.put(column_name, rs.getString(i));
                }
            }

            json.put(obj);
        }

        return json;
    }
    public static ResultSet Data_to_ResultSet(){
        try {
            Connection conn = connectToDB();
            String Query = "SELECT * FROM products";
            Statement St = conn.createStatement();
            ResultSet Rs = St.executeQuery(Query);
            return Rs;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

