package task22;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;
import task22.entity.User;
import task22.menus.MainMenu;
import task22.menus.ShopMenu;

import java.sql.SQLException;


public class Application {
    public static void main(String[] args) throws SQLException {
        MainMenu.run();
        //new ShopMenu(new User("q","q")).run();

    }
}
