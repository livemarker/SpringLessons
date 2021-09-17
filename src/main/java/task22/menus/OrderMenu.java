package task22.menus;

import task22.DAO.OrderDAO;
import task22.entity.Order;
import task22.entity.Product;
import task22.entity.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class OrderMenu {
    private User user;
    private static OrderMenu orderMenu;
    private Scanner sc = new Scanner(System.in);

    private OrderMenu(User user) {
        this.user = user;
    }

    public static OrderMenu create(User user) {
        if (orderMenu == null) {
            orderMenu = new OrderMenu(user);
        }
        return orderMenu;
    }

    public void run() throws SQLException {
        System.out.println("----------------");
        System.out.println("Меню заказов");
        getOrder();
        System.out.println();
        System.out.println("Для возврата в меню аккаунта: -1");
        int choice = sc.nextInt();
        if (choice == -1) {

        } else {
            run();
        }
    }

    private void getOrder() throws SQLException {
        List<Order> list = new OrderDAO().getOrderList(user);
        int delitel = 1;
        for (int i = 0; i < list.size(); i++) {
            if (delitel != list.get(i).getOrderNumber()) {
                System.out.println();
            }
            System.out.print(list.get(i).toString());
            delitel = list.get(i).getOrderNumber();
        }
    }

    public void addOrder(List<Product> products) throws SQLException {
        new OrderDAO().addOrder(user, products);
    }
}
