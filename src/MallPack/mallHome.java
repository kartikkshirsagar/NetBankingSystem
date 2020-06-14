package MallPack;
import common.DButilsProduct;
import org.json.JSONArray;
import org.json.JSONException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static common.DButilsProduct.convert;

@WebServlet(name = "mall")
public class mallHome extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //response.sendRedirect("mallHome.jsp");
//        HttpSession sess=request.getSession();
//        if(sess.getAttribute("uname")==null)
//        {
//            response.sendRedirect("index.jsp");
//            return;
//        }
        HttpSession sess=request.getSession();
        if(sess.getAttribute("keyword")==null)
        {
            PrintWriter out=response.getWriter();
            ResultSet Rs = DButilsProduct.Data_to_ResultSet();
            try {
                JSONArray Arr = DButilsProduct.convert(Rs);
                out.println(Arr.toString());
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        else
        {
            String keyword= (String) sess.getAttribute("keyword");
            sess=request.getSession();
            sess.removeAttribute("keyword");
            System.out.println("else");
            PrintWriter out=response.getWriter();
            ArrayList<Product> list=new ArrayList<Product>();
            try {
                Connection con=common.connectDB.connectToDB();
                Statement stmt=con.createStatement();
                ResultSet res=stmt.executeQuery("SELECT * FROM products WHERE name LIKE '%"+keyword+"%' OR description LIKE '%"+keyword+"%';");
                JSONArray Arr=convert(res);
                out.println(Arr.toString());
            /*while(res.next())
            {
                list.add(new Product(res.getString("name"),res.getInt("id"),res.getInt("price"),res.getString("description"),1));
            }*/
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
