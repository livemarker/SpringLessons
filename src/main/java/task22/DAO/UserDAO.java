package task22.DAO;

import task22.entity.User;
import task22.menus.MainMenu;

import java.sql.*;

public class UserDAO {
    private Connection connection = new DBWorker().getConnection();
    private User user;

    public UserDAO(User user) throws SQLException {
        this.user = user;
    }

    public void save() throws SQLException {

        String add = "INSERT INTO users values (?,?,?,?,?);";

        PreparedStatement ps = connection.prepareStatement(add);
        ps.setInt(1, generator());
        ps.setString(2, user.getFirstName());
        ps.setString(3, user.getLastName());
        ps.setString(4, user.getAddress());
        ps.setString(5, user.getPhoneNumber());
        ps.executeUpdate();
    }

    public User load() throws SQLException {
        String firstName = user.getFirstName();
        String lastName = user.getLastName();

        String find = "SELECT *FROM users WHERE \"Имя\" = \'" + firstName + "\' " +
                "AND \"Фамилия\" = \'" + lastName + "\';";

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(find);

        String address = null;
        String phoneNumber = null;
        while (rs.next()) {
            address = rs.getString(4);
            phoneNumber = rs.getString(5);
        }
        if (address == null) {
            System.out.println("Такого пользователя не существует");
            System.out.println("--------------------");
            MainMenu.run();
        }
        return new User(firstName, lastName, address, phoneNumber);
    }

    private int generator() throws SQLException {
        String sql = "SELECT * FROM users " +
                "WHERE id = (SELECT max(id) FROM users);";

        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            return resultSet.getInt(1) + 1;
        }
        return 1;
    }
}
