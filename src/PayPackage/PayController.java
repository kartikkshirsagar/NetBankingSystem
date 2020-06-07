package PayPackage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "paycontroller")
public class PayController extends HttpServlet {
    //Login sends its data here..this will connect to the database and get this users details and forward it to a jsp page
    //which will have the discussed options....
    //This will then redirect to respective pages


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        HttpSession sess=req.getSession();
        Boolean Login=false;
        Account User;
        if(sess!=null)
        {
            //out.println("Welcome,checking");
            ArrayList<Account> List=TestArrayInit.InitArray();
            for(Account A:List)
            {
                if(A.getAccount_Holder().equals(sess.getAttribute("name")));
                {
                    Login=true;
                    User=A;
                    sess.setAttribute("User",User);
                }
            }
            //User contains the data of this person...this will be forwarded to JSP
            if(Login==true)
            {
                //redirect to a JSP displaying User details

                resp.sendRedirect("home.jsp");
            }
        }
        else
        {
            //System.out.println("Error in session");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
