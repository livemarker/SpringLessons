package task22.DAO;

import task22.entity.User;
import task22.menus.AccountMenu;
import task22.menus.MainMenu;

import java.sql.*;

public class ProfileMenuDAO {
    Connection connection = new DBWorker().getConnection();

    public ProfileMenuDAO() throws SQLException {
    }

    public void changeInfo(User user, String firstNameTemp, String lastNameTemp,
                           String addressTemp, String phoneNumberTemp) throws SQLException {

        String update = "UPDATE users SET  first_name= '" + firstNameTemp + "'," +
                " last_name = \'" + lastNameTemp + "\'," +
                " address = \'" + addressTemp + "\'," +
                " phone_number = \'" + phoneNumberTemp + "\' " +
                "WHERE first_name = \'" + user.getFirstName() + "\'" +
                " AND last_name = \'" + user.getLastName() + "\';";

        PreparedStatement ps = connection.prepareStatement(update);
        ps.executeUpdate();
        MainMenu.run();
    }

    public void delProfile(User user) throws SQLException {

        String delete = "DELETE FROM users WHERE first_name = \'" + user.getFirstName() + "\' " +
                "AND last_name = \'" + user.getLastName() + "\';";

        PreparedStatement ps = connection.prepareStatement(delete);
        ps.executeUpdate();

    }
}

