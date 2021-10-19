package co.edu.unbosque.model.services;

import co.edu.unbosque.model.dtos.PetCase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public final class PetCaseService {
    private final Connection conn;
    public PetCaseService(Connection conn) {
        this.conn = conn;
    }

    public void updatePetCase(PetCase petCase) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            String sql = "UPDATE PetCase SET created_at = '"+petCase.getCreated_at()+"'," +
                    " type = '"+petCase.getType()+"'," +
                    " description = '"+petCase.getDescription()+"'" +
                    " WHERE pet_id = "+petCase.getPet_id();
            int rowUpdated = stmt.executeUpdate(sql);
            System.out.println("Rows updated: "+rowUpdated);
        }
    }

    public static PetCaseService getInstance(Connection conn) {
        return new PetCaseService(conn);
    }
}
