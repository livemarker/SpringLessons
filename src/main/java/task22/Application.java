package task22;

import task22.menus.AdminMenu;
import task22.menus.MainMenu;
import task22.menus.ShopMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        // DBWorker dbW =new DBWorker();
       // VTBShop vs = new VTBShop();
       // MainMenu.run();
       // new AdminMenu().run();
        new ShopMenu(new User("a","a","a","a")).run();

    }
}
//CREATE TABLE Products(id INT, name VARCHAR, price DECIMAL);