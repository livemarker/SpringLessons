package task22.menus;

import task22.DAO.UserDAO;
import task22.entity.User;

import java.sql.SQLException;
import java.util.Scanner;

public class MainMenu {
    private static Scanner sc = new Scanner(System.in);

    public static void run() throws SQLException {
        System.out.println("Добро пожаловать в ВТБ магазин");
        System.out.println("Для совершения покупок, войдите в личный кабинет");
        System.out.println("1.  войти в аккаунт");
        System.out.println("2.  зарегистрироваться");
        System.out.println();
        System.out.println("3.  выход");

        int choice = sc.nextInt();
        if (choice == 1) {
            authorization();
        } else if (choice == 2) {
            registration();
        } else if (choice == 3) {
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

    static private void authorization() throws SQLException {
        System.out.println("Чтобы войти в аккаунт введите имя и фамилию ");
        System.out.println("Введите имя: ");
        String name = sc.next();
        System.out.println("Введите Фамилию: ");
        String lastName = sc.next();
        AccountMenu.create(new UserDAO(new User(name, lastName)).load()).run();
    }

    static private void registration() throws SQLException {
        System.out.println("Введите имя: ");
        String name = sc.next();
        System.out.println("Введите Фамилию: ");
        String lastName = sc.next();
        System.out.println("Введите адрес: ");
        String address = sc.next();
        System.out.println("Введите номер телефона: ");
        String phone = sc.next();

        new UserDAO(new User(name, lastName, address, phone)).save();
        System.out.println("Вы успешно зарегистрированы ");
        authorization();
    }
}
