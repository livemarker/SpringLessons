package task22.menus;

import task22.DAO.ProfileMenuDAO;
import task22.User;

import java.sql.SQLException;
import java.util.Scanner;

public class ProfileMenu {
    private User user;
    private Scanner sc = new Scanner(System.in);

    public ProfileMenu(User user) {
        this.user = user;
    }

    public void run() throws SQLException {
        System.out.println("-------------------");
        startWindow();
        System.out.println(user.toString());
        System.out.println("");
        System.out.println("1.  Изменить информацию");
        System.out.println("2.  Удалить профиль");
        System.out.println("3.  Вернуться в меню аккаунта");

        int choice = sc.nextInt();
        if (choice == 1) {
            changeInfo();
            run();
        } else if (choice == 2) {
            delProfile();
        } else if (choice == 3) {
            AccountMenu.create(user).run();
        } else {
            System.out.println("Выберите правильный пункт меню");
            try {
                Thread.sleep(200);
            } catch (Exception e) {
            }
            run();
        }
    }

    private void startWindow() {
        System.out.println("Информация о профиле:");
    }

    private void changeInfo() throws SQLException {
        new ProfileMenuDAO().changeInfo(user);
    }

    private void delProfile() throws SQLException {
        new ProfileMenuDAO().delProfile(user);

    }
}
