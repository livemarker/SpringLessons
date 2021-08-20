package task22.DAO;

import task22.User;
import task22.menus.AccountMenu;

import java.sql.*;
import java.util.Scanner;

public class ProfileMenuDAO {
    Connection connection = new DBWorker().getConnection();
    Scanner sc = new Scanner(System.in);

    public ProfileMenuDAO() throws SQLException {
    }

    public void changeInfo(User user) throws SQLException {
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

        String update = "UPDATE users SET  \"Имя\"= \'" + firstNameTemp + "\'," +
                " \"Фамилия\" = \'" + lastNameTemp + "\'," +
                " \"Адрес\" = \'" + addressTemp + "\'," +
                " \"Телефон\" = \'" + phoneNumberTemp + "\' " +
                "WHERE \"Имя\" = \'" + user.getFirstName() + "\'" +
                " AND \"Фамилия\" = \'" + user.getLastName() + "\';";

        PreparedStatement ps = connection.prepareStatement(update);
        ps.executeUpdate();
        AccountMenu.create(user).run();
    }

    public void delProfile(User user) throws SQLException {
        System.out.println("-------------------");
        System.out.println("Вы действительно хотите удалить профиль?");
        System.out.println("1.  Да");
        System.out.println("2.  Нет");
        int choice = sc.nextInt();

        if (choice == 1) {
            String delete = "DELETE FROM users WHERE \"Имя\" = \'" + user.getFirstName() + "\' AND \"Фамилия\" = \'" + user.getLastName() + "\';";

            PreparedStatement ps = connection.prepareStatement(delete);
            ps.executeUpdate();
            AccountMenu.create(user).run();
        } else if (choice == 2) {
            AccountMenu.create(user);

        } else {
            System.out.println("Выберите правильный пункт меню");
            try {
                Thread.sleep(200);
            } catch (Exception e) {
            }
            delProfile(user);
        }
    }
}
