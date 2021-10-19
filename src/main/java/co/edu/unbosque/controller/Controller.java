package co.edu.unbosque.controller;

import co.edu.unbosque.model.dtos.PetCase;
import co.edu.unbosque.model.services.PetCaseService;
import co.edu.unbosque.model.services.UserService;
import co.edu.unbosque.model.services.VetService;
import co.edu.unbosque.model.services.VisitService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Controller {

    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost/taller4-prog2";
    private static final String USER = "postgres";
    private static final String PASS = "";

    public Controller() {
        CLI();
    }

    public void CLI() {
        Scanner scan = new Scanner(System.in).useDelimiter("\n");
        Date date = Calendar.getInstance().getTime();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            Class.forName(JDBC_DRIVER);
            do {
                System.out.println("""
                    Escoja una opcion:
                    1. Consultar lista de usuarios por rol
                    2. Contar la lista de veterinarias
                    3. Consultar visitas registradas de las mascotas
                    4. Registrar nuevo caso
                    5. Salir
                    """);
                switch (scan.nextInt()) {
                    case 1 -> {
                        System.out.print("Ingrese rol: ");
                        UserService.getInstance(conn).showUsersByRole(scan.next());
                    }
                    case 2 -> VetService.getInstance(conn).countVets();
                    case 3 -> {
                        System.out.print("Ingrese id de la mascota: ");
                        VisitService.getInstance(conn).showVisitsByID(scan.nextInt());
                    }
                    case 4 -> {
                        System.out.println("Ingrese tipo de caso: ");
                        String type = scan.next();
                        System.out.println("Ingrese descripcion: ");
                        String description = scan.next();
                        System.out.print("Ingrese id de la mascota: ");
                        int id = scan.nextInt();
                        PetCaseService.getInstance(conn).updatePetCase(
                                new PetCase(df.format(date), type, description, id));
                    }
                    case 5 -> System.exit(0);
                    default -> System.out.println("Ingrese una opcion correcta.");
                }
            } while (true);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void getInstance() {
        new Controller();
    }
}
