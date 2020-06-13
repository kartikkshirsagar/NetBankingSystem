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

@WebServlet(name = "Cart")
public class Cart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        HttpSession sess=request.getSession();
        ArrayList<Product> list= new ArrayList<Product>();
        try {
            list = common.DButilsCart.getCart(sess.getAttribute("uname").toString());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        out.println("<!DOCTYPE html><html><body>");
        for(Product p :list){
            out.println("<form action='test2' method='POST'>");
            out.println(p.Name+" " + p.Quantity);
            out.println("<input type='hidden' value='"+p.id+"' name='id'>");
            out.println("<input type='submit' value='Remove from cart' name='remove'>");
            out.println("</form>\n");
        }
        out.println("<form action='test3' method='POST'>");
        out.println("<input type='submit' value='Confirm Purchase' name='purchase'>");
        out.println("</form>\n");
        out.println("</body></html>");
    }
}
