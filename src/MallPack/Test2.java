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

@WebServlet(name = "test2")
public class Test2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sess = request.getSession();
        String username = sess.getAttribute("uname").toString();
//        if(request.getParameter("remove") !=null) {
            int id = Integer.parseInt(request.getParameter("id"));

            try {
                common.DButilsCart.removeFromCart(username, id);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
//        }
//        else if(request.getParameter("purchase")!=null)
//        {
//            PrintWriter out=response.getWriter();
//            try{
//                ArrayList<Product> products= new ArrayList<>();
//                products=common.DButilsCart.getCart(username);
//                for(int i=0;i<products.size();i++)
//                {
//                    Product p = products.get(i);
//                    out.println(p.Quantity*p.price);
//                }
//                //////////////product purchased//////////////
//
//            }
//             catch (SQLException throwables) {
//                throwables.printStackTrace();
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//        }
        response.sendRedirect("cart");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
