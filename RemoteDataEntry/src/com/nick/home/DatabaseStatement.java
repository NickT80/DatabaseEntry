package com.nick.home;


/**
 * Created by Nick Taylor on 12/31/2016.
 */

public class DatabaseStatement {

    /*Statement stmt = null;

    public void DatabaseStatement(Connection c) throws SQLException {

        stmt = c.createStatement();

        System.out.println("Attempting to create a statement.");
        try {
            String sql = "CREATE TABLE PEOPLE " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " AGE            INT     NOT NULL, " +
                    " ADDRESS        CHAR(50), " +
                    " SALARY         REAL)";
            stmt.executeUpdate(sql);
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void AddData(String name) throws SQLException {
        System.out.println("Attempting to add data.");
        String sql = "INSERT INTO PEOPLE (ID,NAME,AGE,ADDRESS,SALARY) "
                + "VALUES (1,'"+name+"', 32, 'California', '100000');";
        stmt.executeUpdate(sql);
    }

    public void DatabaseStatementClose(){
        try {
            stmt.close();
            System.out.println("Statement closed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

}
