package MallPack;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "mall")
public class mallHome extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.sendRedirect("mallHome.jsp");
        PrintWriter out=response.getWriter();
        ArrayList<Product> list= null;
        try {
            list = common.DButilsProduct.getProducts();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        out.println("<!DOCTYPE html><html><body>");
        for(Product p :list){
            out.println("<form action='test' method='POST'>");
            out.println(p.Name);
            out.println("<input type='hidden' value='"+p.id+"' name='id'>");
            out.println("<input type='submit' value='Add to cart'>");
            out.println("</form>\n");
        }
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
