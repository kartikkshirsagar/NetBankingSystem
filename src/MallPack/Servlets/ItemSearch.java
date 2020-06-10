package MallPack.Servlets;

import MallPack.Database.DataConnection;
import MallPack.Database.ItemFunc;
import MallPack.Items.Items;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ItemSearch extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");

        String searchitem = request.getParameter("searchitem");
        ItemFunc itemf = DataConnection.getItemFunc();
        List<Items> itemsList = itemf.find(searchitem);
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body>");
            out.println("<h1>Net Banking Portal:\n</h1>");
            out.println("<h2>Your searched related Items are:</h2><ul>");
            for (Items item : itemsList) {
                out.println("<li>" + item + "</li>");
            }
            out.println("</ul></body>");
            out.println("</html>");
        }
    }
}
