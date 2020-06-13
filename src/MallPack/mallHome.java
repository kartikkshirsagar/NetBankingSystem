package MallPack;
import common.DButilsProduct;
import org.json.JSONArray;
import org.json.JSONException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "mall")
public class mallHome extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.sendRedirect("mallHome.jsp");
        HttpSession sess=request.getSession();
        if(sess.getAttribute("uname")==null)
        {
            response.sendRedirect("index.jsp");
            return;
        }
        PrintWriter out=response.getWriter();
        ResultSet Rs = DButilsProduct.Data_to_ResultSet();
        try {
            JSONArray Arr = DButilsProduct.convert(Rs);
            out.println(Arr.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
