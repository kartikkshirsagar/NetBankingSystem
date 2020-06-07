package PayPackage;

import common.DButilsBank;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.AbstractCollection;
import java.util.ArrayList;

@WebServlet(name = "transferUser")
public class transferUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sess=request.getSession();
        //Account User=(Account) sess.getAttribute("User");
        Account User=null;
        String Username=sess.getAttribute("uname").toString();
        //User=TestArrayInit.getDetails(Username);
        try {
            User= DButilsBank.getAccObj(Username);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        int amount=Integer.parseInt(request.getParameter("amount"));
        int Account=Integer.parseInt(request.getParameter("Account"));
        if(User.getBalance() >= amount)
        {
            Boolean found=false;
            ArrayList<Account> List=TestArrayInit.getList();
            for(Account A:List)
            {
                if(A.getAccount_Number()==Account)
                {
                    found=true;
                    User.setBalance(User.getBalance()-amount);
                    A.setBalance(A.getBalance()+amount);
                    TestArrayInit.UpdateList(User);
                    TestArrayInit.UpdateList(A);
                }
            }
            if(found==true)
            {
                //Successful transaction
                response.sendRedirect("home.jsp");
            }
            else
            {
                //Error ,account not found
                response.sendRedirect("transferError1.html");
            }

        }
        else
        {
            //redirect to an error page
            response.sendRedirect("transferError2.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
