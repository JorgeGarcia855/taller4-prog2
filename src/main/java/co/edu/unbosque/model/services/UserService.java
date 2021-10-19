package co.edu.unbosque.model.services;

import co.edu.unbosque.model.dtos.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public final class UserService {
    /**
     * Muestra una lista de usuarios filtrada por el rol.
     * @param conn La coneccion a la base de datos local.
     * @param rol El rol del usuario.
     * @throws SQLException Cuando hay un error al conectarse a la base de datos.
     */
    public static void showUsersByRole(Connection conn, String rol) throws SQLException {
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
            users.forEach(System.out::println);
            rs.close();
        }
    }
}
