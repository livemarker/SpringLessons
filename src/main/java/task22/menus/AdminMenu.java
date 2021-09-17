package task22.menus;


import task22.DAO.ShopDAO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminMenu {
    private Scanner sc = new Scanner(System.in);
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void run() throws SQLException {
        System.out.println("------------------");
        System.out.println("Админ меню:");
        System.out.println("1.  Добавить товар");
        System.out.println("2.  Зайти как пользователь");
        int choice = sc.nextInt();

        if (choice == 1) {
            try {
                System.out.println("Добавление товара:");
                System.out.println("Укажите название:");
                String name = br.readLine();
                System.out.println("Укажите цену:");
                double price = sc.nextDouble();
                System.out.println("Укажите категорию:");
                String category = sc.next();

                ShopDAO.create().add(name, price, category);
                System.out.println("Товар добавлен");
                run();
            } catch (Exception e) {
            }
        }
        if (choice == 2) {

        }
    }
}
