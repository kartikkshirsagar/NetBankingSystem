package MallPack;

import MallPack.Product;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "test3")
public class Test3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sess = request.getSession();
        String username = sess.getAttribute("uname").toString();
        int total=0;
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html><html><body>");
        try {
            ArrayList<Product> products = new ArrayList<>();
            products = common.DButilsCart.getCart(username);

            for (int i = 0; i < products.size(); i++) {
                Product p = products.get(i);
                out.println("total price of  ");
                out.println(p.Name);
                out.println(" ");
                out.println(p.Quantity * p.price);
                out.println("\n\n");
                total=total+(p.Quantity*p.price);
            }
            //////////////product purchased//////////////
            out.println("your total is "+total);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        try  {
//            out.println("<meta http-equiv=\"Refresh\" content=\"3;url=confirmpurchase\">");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        out.println("<form action='confirmpurchase' method='POST'>");
        out.println("<input type='hidden' value='"+total+"' name='amount'>");
        out.println("<input type='submit' value='Confirm Purchase' name='purchase'>");
        out.println("</form>\n");
        out.println("</body></html>");
        response.setContentType("text/html;charset=UTF-8");

    }



}
