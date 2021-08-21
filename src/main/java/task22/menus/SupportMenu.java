package task22.menus;

import task22.DAO.SupportDAO;
import task22.entity.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

public class SupportMenu {
    private User user;
    private static SupportMenu supportMenu;
    private Scanner sc = new Scanner(System.in);
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private SupportMenu(User user) {
        this.user = user;
    }

    public static SupportMenu create(User user) {
        if (supportMenu == null) {
            supportMenu = new SupportMenu(user);
        }
        return supportMenu;
    }

    public void run() throws SQLException {
        System.out.println("--------------");
        System.out.println("Меню тех. поддержки");
        System.out.println("1. Написать обращение");
        System.out.println("2. Посмотреть отправленные обращения");
        System.out.println("");
        System.out.println("Выйти в меню аккаунта: -1");
        int choice = sc.nextInt();
        if (choice == 1) {
            try {
                createTicket();
            } catch (IOException e) {
            }
        } else if (choice == 2) {
            getTickets();
        } else if (choice == -1) {
            AccountMenu.create(user).run();
        } else {
            run();
        }
    }

    private void createTicket() throws SQLException, IOException {
        System.out.println("");
        System.out.println("Создание обращения, введите тему обращения:");
        String topic = br.readLine();
        System.out.println("Введите сообщение");
        String text = br.readLine();

        SupportDAO.create().addTicket(user, topic, text);
        run();
    }

    private void getTickets() throws SQLException {
        System.out.println("--------------");
        System.out.println("Мои обращения:");
        System.out.println(SupportDAO.create().getTicket(user).toString());
        run();
    }
}
