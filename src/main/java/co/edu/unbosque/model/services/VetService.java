package co.edu.unbosque.model.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class VetService {
    /**
     * Cuenta la cantidad de veterinarios en la base de datos.
     * @param conn La coneccion a la base de datos local.
     * @throws SQLException Cuando hay un error al conectarse a la base de datos.
     */
    public static void countVets(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()){
            String sql = "SELECT COUNT(*) AS count FROM Vet";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            System.out.println("Hay "+rs.getInt("count")+" veterinarios.");
            rs.close();
        }
    }
}
