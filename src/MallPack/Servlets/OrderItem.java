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

public class OrderItem extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ItemFunc itemData= DataConnection.getItemFunc();
        List<Items> itemList = itemData.getFullItems();

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");

            out.println("<body>");
            out.println("<h1>ABC's Online Electronic Portal</h1>");
            out.println("<h2>The products list are:</h2><form action='order_received.html' method='POST'><ul>");

            for (Items items : itemList) {
                out.println("<li>" + items + "&nbsp;&nbsp;&nbsp; <input type='text' name='item_" + items.getId() + "'/> </li>");
            }

            out.println("</ul>");
            out.println("<input type='submit'/>");
            out.println("</form></body>");
            out.println("</html>");
        }
    }

}
