package loginPackage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import common.DButilsLogin;
import common.DButilsLogin.*;

import common.DButilsLogin.*;

@WebServlet(name = "register")
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name").toString();
        String username=request.getParameter("username");
        String pass=request.getParameter("pass");
        System.out.println("x");
        try {
            DButilsLogin.InsertLogin(username,pass);
            DButilsLogin.InsertAcc(name);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
