package task22.DAO;

import task22.entity.Order;
import task22.entity.Product;
import task22.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class OrderDAO {
    Connection connection = new DBWorker().getConnection();

    public OrderDAO() throws SQLException {
    }

    public List<Order> getOrderList(User user) throws SQLException {
        List<Order> orders = new ArrayList<>();
        String tableName = "orders";

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM " + tableName + ";");

        Order order;
        while (rs.next()) {
            order = new Order(rs.getInt(1),
                    rs.getString(2),
                    rs.getDouble(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7));
            orders.add(order);
        }
        return orders;
    }

    public void addOrder(User user, List<Product> products) throws SQLException {
        String tableName = "orders";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM  users " +
                "WHERE first_name=\'" + user.getFirstName() + "\' " +
                "AND  last_name=\'" + user.getLastName() + "\'");

        String create =
                " create table if not exists " + tableName +
                        "(order_number INT," +
                        " name_Product VARCHAR," +
                        " price DECIMAL," +
                        " category VARCHAR," +
                        " first_name VARCHAR," +
                        " last_name VARCHAR," +
                        " status VARCHAR);";
        PreparedStatement pss = connection.prepareStatement(create);
        pss.executeUpdate();

        int id = generator(tableName);
        String add = " INSERT INTO " + tableName + " values (?,?,?,?,?,?,?);";
        while (resultSet.next()) {
            for (Product p : products) {
                PreparedStatement ps = connection.prepareStatement(add);
                ps.setInt(1, id);
                ps.setString(2, p.getName());
                ps.setDouble(3, p.getPrice());
                ps.setString(4, p.getCategory());
                ps.setString(5,user.getFirstName());
                ps.setString(6,user.getLastName());
                ps.setString(7, "Подготовка к отправке");
                ps.executeUpdate();
            }
        }
    }

    private int generator(String table) throws SQLException {
        String order_number = "order_number";
        String sql = "SELECT * FROM " + table +
                " WHERE " + order_number + " = (SELECT max(" + order_number + ") FROM " + table + ");";

        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            return resultSet.getInt(1) + 1;
        }
        return 1;
    }
}
