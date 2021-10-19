package co.edu.unbosque.model.services;

import co.edu.unbosque.model.dtos.PetCase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public final class PetCaseService {
    /**
     * Actualiza el reglon especificado por el usuario.
     * @param conn La coneccion a la base de datos local.
     * @param petCase El caso de la mascota.
     * @throws SQLException Cuando hay un error al conectarse a la base de datos.
     */
    public static void updatePetCase(Connection conn, PetCase petCase) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            String sql = "UPDATE PetCase SET created_at = '"+petCase.getCreated_at()+"'," +
                    " type = '"+petCase.getType()+"'," +
                    " description = '"+petCase.getDescription()+"'" +
                    " WHERE pet_id = "+petCase.getPet_id();
            int rowUpdated = stmt.executeUpdate(sql);
            System.out.println("Rows updated: "+rowUpdated);
        }
    }
}
