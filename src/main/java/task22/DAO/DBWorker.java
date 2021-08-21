package task22.DAO;

import java.sql.*;

public class DBWorker {
    private Connection connection;
    private String dburl = "jdbc:postgresql://localhost:5432/VTBShop";
    private String user = "postgres";
    private String pass = "123321";

    public DBWorker() throws SQLException {
        init();
    }

    private void init() throws SQLException {
        this.connection = DriverManager.getConnection(dburl, user, pass);
    }

    public Connection getConnection() {
        return connection;
    }
}
