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

        String create =
                " create table if not exists products (id INT, name VARCHAR, price DECIMAL, category varchar);";
        String q = " INSERT INTO products values(?,?,?,?);";
        PreparedStatement pss = connection.prepareStatement(create);
        pss.executeUpdate();
        PreparedStatement ps = connection.prepareStatement(q);
        ps.setInt(1, generator("products"));
        ps.setString(2, name);
        ps.setDouble(3, price);
        ps.setString(4, category);
        ps.executeUpdate();
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
        ResultSet rs = statement.executeQuery("SELECT category FROM products");

        String category;
        while (rs.next()) {
            category = rs.getString(1);
            productsCategory.add(category);
        }

        return productsCategory;
    }

    public List<Product> getProducts(String nameCategory) throws SQLException {
        List<Product> products = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT *FROM products WHERE category='" + nameCategory + "';");


        Product product;
        while (rs.next()) {
            product = new Product(rs.getString(2)
                    , rs.getDouble(3)
                    , rs.getString(4));
            products.add(product);
        }
        return products;
    }
}
