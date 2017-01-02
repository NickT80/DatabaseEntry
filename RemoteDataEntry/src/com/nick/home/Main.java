package com.nick.home;

import java.sql.*;

/**
 * Created by Nick Taylor on 12/30/2016.
 */
public class Main {
    Connection conn = null;
    Statement stmt = null;
    public static void main(String[] args) throws SQLException {

        //establish connection

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager
                    .getConnection("jdbc:postgresql://192.168.1.224:5432/postgres",
                            "postgres", "");
            conn.setAutoCommit(false);
            System.out.println("Opened database successfully");

        } catch (Exception e) {
            System.out.println(e);
        }

        stmt = conn.createStatement();

        System.out.println("Attempting to create a statement.");
        try {
            String sql = "CREATE TABLE CALLS" +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " LENGTH         INT     NOT NULL," +
                    " NUMBER         REAL     NOT NULL ";
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }



        stmt.close();
        conn.commit();
        conn.close();
    }
    public void addPeople(int ID, String NAME, int AGE, int ADDRESS, int SALARY) throws SQLException {
        System.out.println("Attempting to add data.");
        String sql = "INSERT INTO PEOPLE (ID,NAME,AGE,ADDRESS,SALARY) "
                + "VALUES (1,'John', 32, 'California', '100000');";
        stmt.executeUpdate(sql);
    }
}