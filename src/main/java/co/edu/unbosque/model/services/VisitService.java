package co.edu.unbosque.model.services;

import co.edu.unbosque.model.dtos.Visit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public final class VisitService {
    private final Connection conn;
    public VisitService(Connection conn) {
        this.conn = conn;
    }

    public void showVisitsByID(int petId) throws SQLException {
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

            for (Visit visit: visits){
                System.out.println(visit.toString());
            }
            rs.close();
        }
    }

    public static VisitService getInstance(Connection conn) {
        return new VisitService(conn);
    }
}
