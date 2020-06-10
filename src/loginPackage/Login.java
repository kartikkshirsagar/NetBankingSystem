package loginPackage;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "login")
public class Login extends HttpServlet {

    boolean isCorrect(String user, String pass) throws SQLException, ClassNotFoundException {
        Connection con=common.connectDB.connectToDB();
        Statement stmt=con.createStatement();
        try{
            ResultSet rs = stmt.executeQuery("SELECT * FROM login WHERE username='"+user+"';");
            rs.next();
            //String username=rs.getString("username");
            String password=rs.getString("password");
            if(pass.equals(password))
            {
                System.out.println("x");
                return true;
            }

        }catch (Exception e)
        {
            return false;
        }
    return false;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("uname");
        String pass = request.getParameter("pass");
        PrintWriter pw = response.getWriter();
        System.out.println("in dopost");
        try {
            if (!isCorrect(name, pass)) {
                //redirect to auth fail
                System.out.println("in if cond");
                response.sendRedirect("AuthFail.html#mymodal");
            } else {
                pw.println("Correct");
                HttpSession sess = request.getSession();
                sess.setAttribute("uname", name);
                //response.sendRedirect("index.jsp");
                response.sendRedirect("home.jsp");
                //response.sendRedirect("another.html");
                //redirect to dashboard page
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

