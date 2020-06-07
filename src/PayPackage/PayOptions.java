package PayPackage;

import javax.print.DocFlavor;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PayOptions")
public class PayOptions extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sess=request.getSession();
        String task=request.getParameter("submit");
        //System.out.println(task);
        Account User= (Account) sess.getAttribute("User");
        if(task.equals("Deposit"))
        {
            response.sendRedirect("deposit.jsp");
        }
        else if(task.equals("Withdraw"))
        {
            response.sendRedirect("withdraw.jsp");
        }
        else
        {

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
