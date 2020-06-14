package MallPack;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Test")
public class Test extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int product_id = Integer.parseInt(request.getParameter("id"));

        System.out.println("in doPost mall");
        HttpSession session = request.getSession();
        if (session.getAttribute("uname") == null)
        {
            response.sendRedirect("index.jsp");
        }
        else{
            String username=session.getAttribute("uname").toString();
            try {
//                System.out.println("in try dopost");
//                if(!common.DButilsCart.doesTableExist(username))
//                {
////                    System.out.println("Table does not exist");
//                    common.DButilsCart.CreateCart(username);
//                }
                common.DButilsCart.addToCart(username,product_id);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
//        response.sendRedirect("mall");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
