package MallPack;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@WebServlet(name = "Search")
public class Search extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword=request.getParameter("keyword");
        PrintWriter out=response.getWriter();
        ArrayList<Product> list=new ArrayList<Product>();
        try {
            Connection con=common.connectDB.connectToDB();
            Statement stmt=con.createStatement();
            ResultSet res=stmt.executeQuery("SELECT * FROM products WHERE name LIKE '%"+keyword+"%' OR description LIKE '%"+keyword+"%';");
            while(res.next())
            {
                list.add(new Product(res.getString("name"),res.getInt("id"),res.getInt("price"),res.getString("description"),1));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        out.println("<!DOCTYPE html><html><body>");
        for(Product p :list){
            out.println("<form action='test' method='POST'>");
            out.println(p.Name);
            out.println("<br>");
            out.println(p.description);
            out.println("<input type='hidden' value='"+p.id+"' name='id'>");
            out.println("<input type='submit' value='Add to cart'>");
            out.println("</form>\n");
        }
        out.println("</body></html>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
