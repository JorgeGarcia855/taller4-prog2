package co.edu.unbosque.model.services;

import co.edu.unbosque.model.dtos.Visit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public final class VisitService {
    /**
     * Muestra la vista al veterinario del usuario especificado por la identificacion de la mascota.
     * @param conn La coneccion a la base de datos local.
     * @param petId La identificacion de la mascota.
     * @throws SQLException Cuando hay un error al conectarse a la base de datos.
     */
    public static void showVisitsByID(Connection conn, int petId) throws SQLException {
        List<Visit> visits = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            String sql = "SELECT * FROM Visit WHERE pet_id = "+petId;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int visit_id = rs.getInt("visit_id");
                String created_at = rs.getString("created_at");
                String type = rs.getString("type");
                String description = rs.getString("description");
                String vet_id = rs.getString("vet_id");
                int pet_id = rs.getInt("pet_id");
                visits.add(new Visit(visit_id, created_at, type, description, vet_id, pet_id));
            }
            visits.forEach(System.out::println);
            rs.close();
        }
    }
}
