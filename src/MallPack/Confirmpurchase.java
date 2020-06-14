package MallPack;

import PayPackage.Account;
import common.DButilsBank;
import common.DButilsCart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class Confirmpurchase extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sess=request.getSession();
        Account User=null;
        PrintWriter out = response.getWriter();
        int amount=Integer.parseInt(request.getParameter("amount").trim());
        String Username=sess.getAttribute("uname").toString();
        try {
            User= DButilsBank.getAccObj(Username);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(User.getBalance() >= amount) {
            //It is possible to withdraw
            User.setBalance(User.getBalance() - amount);
            try {
                DButilsBank.UpdateBal(User);
                DButilsCart.DropCart(Username);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
//            out.println("Your order is received and your current balance is ");
//            out.println(User.getBalance());
            response.sendRedirect("Thanks.jsp");
        }
        else
        {
            response.sendRedirect("withdrawError.jsp");
        }
    }
}
