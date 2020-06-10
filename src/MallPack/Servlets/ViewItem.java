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

public class ViewItem extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        ItemFunc itemf = DataConnection.getItemFunc();
        List<Items> itemList = itemf.getFullItems();
        try(PrintWriter out = response.getWriter()){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Net Banking Portal</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Net Banking Portal<h1>");
            out.println("<h2>List of All available items:</h2>");
            out.println("<ul>");
            for(Items item: itemList){
                out.println("<li>" + item + "</li>");
            }

            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
