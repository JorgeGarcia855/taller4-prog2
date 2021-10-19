package co.edu.unbosque.model.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class VetService {
    private final Connection conn;
    public VetService(Connection conn) {
        this.conn = conn;
    }

    public void countVets() throws SQLException {
        try (Statement stmt = conn.createStatement()){
            String sql = "SELECT COUNT(*) AS count FROM Vet";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            System.out.println("Hay "+ rs.getInt("count")+" veterinarios.");
            rs.close();
        }
    }

    public static VetService getInstance(Connection conn) {
        return new VetService(conn);
    }
}
