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

        PrintWriter out = response.getWriter();
        try {
            ArrayList<Product> products = new ArrayList<>();
            products = common.DButilsCart.getCart(username);
            int total=0;
            for (int i = 0; i < products.size(); i++) {
                Product p = products.get(i);
                out.println(p.Quantity * p.price);
                total=total+(p.Quantity*p.price);
            }
            //////////////product purchased//////////////
            out.println("your total is "+total);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
