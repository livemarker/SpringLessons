package task22.menus;

import task22.DAO.ProfileMenuDAO;
import task22.entity.User;

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
        System.out.println("Информация о профиле:");
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

    private void changeInfo() throws SQLException {
        System.out.println("-------------------");
        System.out.println("Изменение данных");
        System.out.println("Текущее имя: " + user.getFirstName() + " изменить на ");
        String firstNameTemp = sc.next();

        System.out.println("Текущая фамилия: " + user.getLastName() + " изменить на ");
        String lastNameTemp = sc.next();

        System.out.println("Текущий адрес: " + user.getAddress() + " изменить на ");
        String addressTemp = sc.next();

        System.out.println("Текущее телефон: " + user.getPhoneNumber() + " изменить на ");
        String phoneNumberTemp = sc.next();
        new ProfileMenuDAO().changeInfo(user, firstNameTemp, lastNameTemp, addressTemp, phoneNumberTemp);
    }

    private void delProfile() throws SQLException {
        System.out.println("-------------------");
        System.out.println("Вы действительно хотите удалить профиль?");
        System.out.println("1.  Да");
        System.out.println("2.  Нет");
        int choice = sc.nextInt();

        if (choice == 1) {
            new ProfileMenuDAO().delProfile(user);
        } else if (choice == 2) {
            AccountMenu.create(user);

        } else {
            System.out.println("Выберите правильный пункт меню");
            try {
                Thread.sleep(200);
            } catch (Exception e) {
            }
        }
    }
}
