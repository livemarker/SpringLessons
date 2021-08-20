package task22.menus;

import org.w3c.dom.ls.LSOutput;
import task22.User;

import java.sql.SQLException;
import java.util.Scanner;

public class AccountMenu {
    private User user;
    private Scanner sc = new Scanner(System.in);
    private static AccountMenu accountMenu;

    private AccountMenu(User user) {
        this.user = user;
    }

    public static AccountMenu create(User user) {
        if (accountMenu == null) {
            accountMenu = new AccountMenu(user);
        }
        return accountMenu;
    }

    public void run() throws SQLException {
        accountWindow();
        System.out.println();
        System.out.println("Меню аккаунта ");
        System.out.println("1.  Магазин");
        System.out.println("2.  Информация о профиле");
        System.out.println("4.  Моя корзина");
        System.out.println("5.  Мои заказы");
        System.out.println("6.  Тех. поддержка");
        System.out.println("7.  Админка");
        int choice = sc.nextInt();
        if (choice == 1) {
            new ShopMenu(user).run();
        } else if (choice == 2) {
            new ProfileMenu(user).run();
        } else if (choice == 3) {
        } else if (choice == 4) {
        } else if (choice == 5) {
        } else if (choice == 6) {
        } else if (choice == 7) {
            if (user.getFirstName().equals("admin") && user.getLastName().equals("admin")) {
                new AdminMenu().run();
            } else {
                System.out.println("Вы не являетесь администратором, выберите другой пункт меню");
                AccountMenu.create(user).run();
            }
        } else {
            System.out.println("Выберите правильный пункт меню");
            try {
                Thread.sleep(200);
            } catch (Exception e) {
            }
            run();
        }
    }

    private void accountWindow() {
        System.out.println("-------------------------");
        System.out.println("Добро пожаловать " + user.getFirstName() + " " + user.getLastName());
    }

}
//CREATE TABLE users (id INT, Имя varchar, Фамилия varchar, Адрес varchar, Телефон varchar);