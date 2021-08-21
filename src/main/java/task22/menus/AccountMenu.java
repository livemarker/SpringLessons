package task22.menus;

import task22.entity.User;

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
        System.out.println("-------------------------");
        System.out.println("Добро пожаловать " + user.getFirstName() + " " + user.getLastName());
        System.out.println();
        System.out.println("Меню аккаунта ");
        System.out.println("1.  Магазин");
        System.out.println("2.  Информация о профиле");
        System.out.println("3.  Моя корзина");
        System.out.println("4.  Мои заказы");
        System.out.println("5.  Тех. поддержка");
        System.out.println("6.  Админка");
        System.out.println();
        System.out.println("Выход -1");
        int choice = sc.nextInt();
        if (choice == 1) {
            new ShopMenu(user).run();
        } else if (choice == 2) {
            new ProfileMenu(user).run();
        } else if (choice == 3) {
            CartMenu.create(user).run();
        } else if (choice == 4) {
            OrderMenu.create(user).run();
        } else if (choice == 5) {
            SupportMenu.create(user).run();
        } else if (choice == 6) {
            if (user.getFirstName().equals("admin") && user.getLastName().equals("admin")) {
                new AdminMenu().run();
            } else {
                System.out.println("Вы не являетесь администратором, выберите другой пункт меню");
                AccountMenu.create(user).run();
            }
        } else if (choice == -1) {
            System.exit(1);
        } else {
            System.out.println("Выберите правильный пункт меню");
            try {
                Thread.sleep(200);
            } catch (Exception e) {
            }
            run();
        }
    }
}
