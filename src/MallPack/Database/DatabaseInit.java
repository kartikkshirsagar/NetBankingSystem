package MallPack.Database;

import MallPack.Items.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class DatabaseInit {
    private List<Items> getItemsList()
    {
        List<Items> EItems = new ArrayList<>();
        EItems.add(new Items(1,"Redmi Note 8 Pro", "8 GB RAM, Front(8 MP)/ Rear(13 MP), 64 GB internal storage, Android 9.0", ItemCate.Mobile, 22540));
        EItems.add(new Items(2,"Redmi Note 5 Pro","6 GB RAM,Front(8MP)/Rear(25MP),64 GB internal storage,Android 9",ItemCate.Mobile,18000));
        EItems.add(new Items(3, "Asus", "15.6 inch, 4GB RAM, 1 TB HHD, Windows 10, i5 10th Generation ", ItemCate.Laptop, 56700));
        EItems.add(new Items(4, "Samsung S8", "16 GB RAM, Front(8 MP)/ Rear(13 MP), 64 GB internal storage, Android 7.0, Face configuration", ItemCate.Mobile, 16880));
        EItems.add(new Items(5, "Samsung J7", "8 GB RAM, Front(8 MP)/ Rear(13 MP), 32 GB internal storage, Android 8.0, Finger print Lock", ItemCate.Mobile,21900));
        EItems.add(new Items(6, "HP", "15.6 inch, 4GB RAM, 1 TB HHD + 256 SSD, Windows 10, i3 8th Generation", ItemCate.Laptop, 45700));
        EItems.add(new Items(7, "Lenovo", "15 inch, 4GB RAM, 1 TB HHD. Windows 10, i5 8th generation", ItemCate.Laptop, 36000));
        EItems.add(new Items(8,"JBL","headphone bass with mic T480 series utra hd voice",ItemCate.Accessories,1750));
        EItems.add(new Items(9,"Sony","earbud with mic ultra hd voice bass",ItemCate.Accessories,5500));
        EItems.add(new Items(10,"Asus","Rog series 16GB RAM 1650Ti NVIDIA 6GB 1TB SSD i9 10th gen",ItemCate.Laptop,130000));
        EItems.add(new Items(11,"Acer","Predator series 16GB RAM 1650Ti NVIDIA 6GB 1TB SSD i9 10th gen",ItemCate.Laptop,142000));
        EItems.add(new Items(12,"Poco","F1 6GB RAM Front 16MP Rear 32MP snapdragon 750",ItemCate.Mobile,19000));
        EItems.add(new Items(13,"rog","Mouse with sensetivity clutch key 4 extra mouse key",ItemCate.Accessories,3000));
        return EItems;
    }
    public void initializeDatabase(){
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mall","root","root");) {
            try (PreparedStatement prepStm = conn.prepareStatement("DROP TABLE IF EXISTS items;")) {
                prepStm.execute();
            }

            try (PreparedStatement prepStm = conn.prepareStatement("DROP TABLE IF EXISTS orders;")) {
                prepStm.execute();
            }

            try (PreparedStatement prepStm = conn.prepareStatement("CREATE TABLE items (id int primary key, name varchar(30), description varchar(150), category varchar(30), price float);")) {
                prepStm.execute();
            }

            List<Items> itemsList = getItemsList();
            for (Items items : itemsList) {
                try (PreparedStatement prepStm = conn.prepareStatement("INSERT INTO items (id, name, description, category, price) values (?,?,?,?,?);");) {
                    prepStm.setInt(1, items.getId());
                    prepStm.setString(2, items.getName());
                    prepStm.setString(3, items.getDescription());
                    prepStm.setString(4, items.getCategory().toString());
                    prepStm.setDouble(5, items.getPrice());
                    prepStm.execute();
                }
            }

            try (PreparedStatement prepStm = conn.prepareStatement("CREATE TABLE orders (id int auto_increment primary key, customer varchar(30), contents varchar(255), status varchar(20));")) {
                prepStm.execute();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
