package MallPack.Database;

import java.sql.*;
import java.util.*;
import MallPack.Items.*;

public class ItemFunc {
    public ItemFunc(){
        DatabaseInit init=new DatabaseInit();
        init.initializeDatabase();
    }
    private List<Items> buildItems(ResultSet results) throws SQLException {
        List<Items> items = new ArrayList<>();
        while (results.next()) {
            Items item = new Items();
            item.setId(results.getInt("id"));
            item.setDescription(results.getString("description"));
            item.setName(results.getString("name"));
            item.setPrice(results.getDouble("price"));
            item.setCategory(ItemCate.valueOf(results.getString("category")));
            items.add(item);
        }
        return items;
    }
    public List<Items>  getFullItems() {
        List<Items> items = null;
        try (	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mall","root","Karan@123");
                 Statement stm = conn.createStatement();
                 ResultSet results = stm.executeQuery("SELECT * FROM items");
        ) {
            items = buildItems(results);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return items;
    }

    public List<Items> find(String searchString) {
        List<Items> items = null;
        try (	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mall","root","Karan@123");
                 PreparedStatement stm = conn.prepareStatement("SELECT * FROM items WHERE name LIKE ? OR description LIKE ?");
        ) {

            stm.setString(1, "%" + searchString + "%");
            stm.setString(2, "%" + searchString + "%");

            ResultSet results = stm.executeQuery();
            items = buildItems(results);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return items;
    }

    public Items getItem(int id) {
        List<Items> items = null;
        try (	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb","root","root");
                 PreparedStatement stm = conn.prepareStatement("SELECT * FROM items WHERE id = ?");
        ) {

            stm.setInt(1, id);

            ResultSet results = stm.executeQuery();
            items = buildItems(results);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return items.get(0);
    }


    public Order newOrder(String customer) {
        Order order = new Order();
        order.setStatus("pending");
        order.setCustomer(customer);
        try (	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb","root","root");
                 PreparedStatement stm = conn.prepareStatement("INSERT INTO orders (status, customer) values (?,?)", Statement.RETURN_GENERATED_KEYS);
        ) {
            stm.setString(1, order.getStatus());
            stm.setString(2,  order.getCustomer());
            stm.execute();

            try(ResultSet generatedKeys = stm.getGeneratedKeys()) {
                generatedKeys.next();
                order.setId(generatedKeys.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return order;
    }

    private Map<Items,Integer> convertContentsToOrderMap(String contents) {
        Map<Items,Integer> orderMap = new HashMap<Items,Integer>();
        if (contents == null || contents.equals("")) {
            return orderMap;
        }
        String[] items = contents.split(":");
        for (int i = 0; i < items.length; i++) {
            String key = items[i].split(",")[0];
            String value = items[i].split(",")[1];
            Items item = getItem(Integer.valueOf(key));
            orderMap.put(item, Integer.valueOf(value));
        }
        return orderMap;
    }

    private String convertOrderMapToContents(Map<Items,Integer> orderMap) {
        String contents = "";
        if (orderMap.keySet().size() == 0) {
            return contents;
        }
        for (Items item : orderMap.keySet() ) {
            contents = contents + item.getId() + "," + orderMap.get(item) + ":";
        }
        contents = contents.substring(0, contents.length()-1);
        return contents;
    }

    public void addToOrder(Long id, Items item, int quantity) {
        try (	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb","root","root");
                 Statement stm = conn.createStatement();
                 ResultSet res = stm.executeQuery("SELECT * FROM orders WHERE ID = " + id);
                 PreparedStatement stmUpdate = conn.prepareStatement("UPDATE orders SET contents = ? WHERE id = ?");
        ) {
            res.next();
            String contents = res.getString("contents");
            Map<Items, Integer> orderMap = convertContentsToOrderMap(contents);
            if (orderMap.get(item) != null) {
                orderMap.put(item, orderMap.get(item) + quantity);
            }
            else {
                orderMap.put(item, quantity);
            }
            contents = convertOrderMapToContents(orderMap);
            stmUpdate.setString(1, contents);
            stmUpdate.setLong(2, id);
            stmUpdate.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Double getOrderTotal(Long id) {
        double d = 0d;
        try (	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb","root","root");
                 Statement stm = conn.createStatement();
                 ResultSet res = stm.executeQuery("SELECT * FROM orders WHERE id = " + id);
        ) {
            res.next();
            Map<Items,Integer> orderMap = convertContentsToOrderMap(res.getString("contents"));
            for (Items item : orderMap.keySet()) {
                d += item.getPrice() * orderMap.get(item);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return d;
    }
}
