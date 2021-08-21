package task22.DAO;

import task22.entity.Ticket;
import task22.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SupportDAO {
    private static SupportDAO supportDAO;
    private Connection connection = new DBWorker().getConnection();

    private SupportDAO() throws SQLException {
    }

    public static SupportDAO create() throws SQLException {
        if (supportDAO == null) {
            supportDAO = new SupportDAO();
        }
        return supportDAO;
    }

    public void addTicket(User user, String topic, String text) throws SQLException {
        String tableName = "support_tickets";

        String create =
                " create table if not exists " + tableName +
                        "(number_ticket INT," +
                        " name VARCHAR," +
                        " lastName VARCHAR," +
                        " topic VARCHAR," +
                        "text VARCHAR," +
                        " status VARCHAR);";
        PreparedStatement pss = connection.prepareStatement(create);
        pss.executeUpdate();

        int id = generator(tableName);
        String add = " INSERT INTO " + tableName + " values (?,?,?,?,?,?);";

        PreparedStatement ps = connection.prepareStatement(add);
        ps.setInt(1, id);
        ps.setString(2, user.getFirstName());
        ps.setString(3, user.getLastName());
        ps.setString(4, topic);
        ps.setString(5, text);
        ps.setString(6, "Обращение принято");
        ps.executeUpdate();
    }

    private int generator(String table) throws SQLException {
        String number_ticket = "number_ticket";
        String sql = "SELECT * FROM " + table +
                " WHERE " + number_ticket + " = (SELECT max(" + number_ticket + ") FROM " + table + ");";

        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            return resultSet.getInt(1) + 1;
        }
        return 1;
    }

    public List<Ticket> getTicket(User user) throws SQLException {
        List<Ticket> tickets = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM support_tickets" +
                "  WHERE name=\'" + user.getFirstName() + "\' " +
                "AND lastname=\'" + user.getLastName() + "\';");

        Ticket ticket;
        while (rs.next()) {
            ticket = new Ticket(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6));

            tickets.add(ticket);
        }
        return tickets;
    }
}
