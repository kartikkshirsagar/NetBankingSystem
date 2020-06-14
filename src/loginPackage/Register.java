package loginPackage;

import common.DButilsLogin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "register")
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name= request.getParameter("name");
        String username=request.getParameter("username");
        String pass=request.getParameter("pass");
        PrintWriter out = response.getWriter();
//        System.out.println("x");
        try {
            DButilsLogin.InsertLogin(username,pass);
            DButilsLogin.InsertAcc(name);
            out.println("success");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            out.println("failure");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            out.println("failure");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
