package task22.DAO;

import task22.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShopDAO {
    private Connection connection = new DBWorker().getConnection();
    private static ShopDAO shopDAO;

    private ShopDAO() throws SQLException {
    }

    public static ShopDAO create() throws SQLException {
        if (shopDAO == null) {
            shopDAO = new ShopDAO();
        }
        return shopDAO;
    }

    public void add(String name, double price, String category) throws SQLException {
        boolean updateFlag = true;

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT сategory FROM products");

        String update = "INSERT INTO " + category + " values (?,?,?);";

        while (resultSet.next()) {
            if (resultSet.getString(1).equals(category)) {
                PreparedStatement ps = connection.prepareStatement(update);
                ps.setInt(1, generator(category));
                ps.setString(2, name);
                ps.setDouble(3, price);
                ps.executeUpdate();
                updateFlag = false;
            }
        }
        if (updateFlag) {
            String create =
                    " CREATE TABLE " + category + "(id INT, name VARCHAR, price DECIMAL);" +
                            " INSERT INTO " + category + " values (?,?,?);" +
                            " INSERT INTO products values (?,?)";
            PreparedStatement ps = connection.prepareStatement(create);

            ps.setInt(1, 1);
            ps.setString(2, name);
            ps.setDouble(3, price);
            ps.setInt(4, generator("products"));
            ps.setString(5, category);
            ps.executeUpdate();
        }
    }

    private int generator(String table) throws SQLException {
        String id = "id";

        String sql = "SELECT * FROM " + table +
                " WHERE " + id + " = (SELECT max(" + id + ") FROM " + table + ");";

        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {

            return resultSet.getInt(1) + 1;
        }
        return 1;
    }

    public List<String> getCategoryProducts() throws SQLException {
        List<String> productsCategory = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT сategory FROM products");

        String category;
        while (rs.next()) {
            category = rs.getString(1);
            productsCategory.add(category);
        }
        return productsCategory;
    }

    public List<Product> getProducts(int index) throws SQLException {
        List<Product> products = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT сategory FROM products WHERE id=" + index + ";");
        String category = null;

        while (rs.next()) {
            category = rs.getString(1);
        }
        rs = statement.executeQuery("SELECT * FROM " + category + ";");

        Product product;
        while (rs.next()) {
            product = new Product(rs.getString(2), rs.getDouble(3), category);
            products.add(product);
        }
        return products;
    }
}
