/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.records;

import java.sql.*;

/**
 *
 * @author perle
 */

public class InsertRecords {

    // nom JDBC driver et url base de donnees
    static final String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    static final String DB = "jdbc:derby://localhost:1527/etudiants";

    static final String USER = "root";
    static final String PWD = "root";

    public static void main(String[] args) {
        Connection co = null;
        Statement state = null;
        try {
            // JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            System.out.println("Connection a la base de donnees");
            co = DriverManager.getConnection(DB, USER, PWD);

            state = co.createStatement();

            String sql = "INSERT INTO ROOT.MIAGE(ID, MIAGE) "
                    + "values (1, 'Aix-Marseille'),\n"
                    + "(2, 'Amiens'),\n"
                    + "(3, 'Bordeaux'),\n"
                    + "(4, 'Grenoble'),\n"
                    + "(5, 'Guadeloupe'),\n"
                    + "(6, 'Lille'),\n"
                    + "(7, 'Mulhouse'),\n"
                    + "(8, 'Nancy'),\n"
                    + "(9, 'Nantes'),\n"
                    + "(10, 'Nice'),\n"
                    + "(11, 'Orléans'),\n"
                    + "(12, 'Paris - Dauphine'),\n"
                    + "(13, 'Paris - Descartes'),\n"
                    + "(14, 'Paris - Evry'),\n"
                    + "(15, 'Paris - Nanterre'),\n"
                    + "(16, 'Paris - Orsay'),\n"
                    + "(17, 'Paris - Sorbonne'),\n"
                    + "(18, 'Rennes'),\n"
                    + "(19, 'Toulouse')";
            state.executeUpdate(sql);

            sql = "INSERT INTO ROOT.ADMINISTRATEURS(ID, MAIL, PASS) "
                    + "values (1,'admin@gmail.com','admin')";
            state.executeUpdate(sql);

            System.out.println("Insersion des données ..");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                System.out.println("Arret de la base de donnees");
                if (state != null) {
                    state.close();
                }
            } catch (SQLException e) {
            }
            try {
                if (co != null) {
                    co.close();
                }
            } catch (SQLException sqlEx) {
                System.out.println(sqlEx.getMessage());
            }
        }
        System.out.println("Fin du programme");
    }
}
