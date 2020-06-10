package loginPackage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import common.DButilsLogin;
import common.DButilsLogin.*;

@WebServlet(name = "checkUser")
public class CheckUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw=response.getWriter();
        String username=request.getParameter("username");
        try {
            if(DButilsLogin.ifUserExists(username))
            {
                //username not available
                pw.write("no");
            }
            else
            {
                pw.write("yes");
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            pw.write("error");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
