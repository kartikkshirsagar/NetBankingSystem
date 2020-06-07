package PayPackage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "depositUser")
public class depositUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sess=request.getSession();
        int amount=Integer.parseInt(request.getParameter("amount"));
        Account User=(Account)sess.getAttribute("User");

        //Now database updation code
        User.setBalance(User.getBalance()+amount);
        TestArrayInit.UpdateList(User);
        sess.removeAttribute("User");
        sess.setAttribute("User",User);
        //Show success message(maybe popup)
        response.sendRedirect("home.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
