package MallPack.Servlets;

import MallPack.Database.DataConnection;
import MallPack.Database.ItemFunc;
import MallPack.Items.Order;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class OrderRecv extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        resp.setContentType("text/html;charset=UTF-8");

        ItemFunc itemData = DataConnection.getItemFunc();
        Order order = itemData.newOrder(req.getUserPrincipal().getName());
        int maxItems = itemData.getFullItems().size();
        try(PrintWriter out = resp.getWriter()){

            for (int i=1;i<=maxItems;i++)
            {
                String quantity;
                quantity=req.getParameter("item_"+i);
                try {
                    int q = Integer.parseInt(quantity);
                    if (q > 0) {

                        itemData.addToOrder(order.getId(), itemData.getItem(i), q);
                    }
                } catch (NumberFormatException e) {

                }
            }
            Double total=0d;
            total = itemData.getOrderTotal(order.getId());
            out.println(total);
            HttpSession sess =req.getSession();
            sess.setAttribute("total",total);
        }
    }
}
