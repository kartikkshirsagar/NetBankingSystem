package loginPackage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "login")
public class Login extends HttpServlet {

    boolean isCorrect(String user, String pass) {
        if (user.equals("root") && pass.equals("root")) {

            return true;
        } else {
            return false;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("uname");
        String pass = request.getParameter("pass");
        PrintWriter pw = response.getWriter();
        if (isCorrect(name, pass)) {
            pw.println("Correct");
            HttpSession sess = request.getSession();
            sess.setAttribute("uname", name);
            //response.sendRedirect("index.jsp");
            response.sendRedirect("home.jsp");
            //redirect to dashboard page
        } else {
            //redirect to auth fail
            response.sendRedirect("AuthFail.html");
        }
    }
}

