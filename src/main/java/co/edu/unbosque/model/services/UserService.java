package co.edu.unbosque.model.services;

import co.edu.unbosque.model.dtos.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public final class UserService {
    private final Connection conn;
    public UserService (Connection conn) {
        this.conn = conn;
    }

    public void showUsersByRole(String rol) throws SQLException {
        List<User> users = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            String sql = "SELECT * FROM UserApp WHERE role = '"+rol+"'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String role = rs.getString("role");
                users.add(new User(username, password, email, role));
            }
            for (User user: users) {
                System.out.println(user.toString());
            }
            rs.close();
        }
    }

    public static UserService getInstance(Connection conn) {
        return new UserService(conn);
    }
}
