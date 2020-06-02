package loginPackage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("uname");
        String pass=request.getParameter("pass");
        PrintWriter pw=response.getWriter();
        if(name.equals("root") && pass.equals("root"))
        {
            pw.println("Correct");
            //redirect to dashboard page
        }
        else
        {
            //redirect to auth fail
            response.sendRedirect("AuthFail.html");
        }
    }
}
