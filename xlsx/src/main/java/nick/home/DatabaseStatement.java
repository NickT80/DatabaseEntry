package nick.home;


import nick.POI.ReadXLSX;
import org.apache.poi.xssf.usermodel.XSSFCell;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Nick Taylor on 12/31/2016.
 */

public class DatabaseStatement {
    Connection c = null;
    Statement stmt = null;
    XSSFCell name;
    XSSFCell name2;
    XSSFCell cost;
    XSSFCell cost2;

    public String DataRC () throws IOException {
            ArrayList myData = ReadXLSX.readXLSXFile();
            name = (XSSFCell) myData.get(0);
            name2 = (XSSFCell) myData.get(1);
            cost = (XSSFCell) myData.get(2);
            cost2 = (XSSFCell) myData.get(3);
            return null;
        }

    public void DatabaseStatement() throws SQLException, IOException {

        System.out.println("Attempting to create a statement.");
        try {
            stmt = c.createStatement();
            String sqlStatement = "CREATE TABLE CONTRACTS " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " COST           INT     NOT NULL";
            stmt.executeUpdate(sqlStatement);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void AddData() throws SQLException {
        stmt = c.createStatement();
        System.out.println("Attempting to add data.");
        String sqlAdd = "INSERT INTO PEOPLE (ID,NAME,COST) "
                + "VALUES (ID,'" + name + "', '" + cost + "');";
        String sqlAdd2 = "INSERT INTO PEOPLE (ID,NAME,COST) "
                + "VALUES (ID,'" + name2 + "', '" + cost2 + "');";
        stmt.executeUpdate(sqlAdd);
        stmt.executeUpdate(sqlAdd2);
    }

    public void DatabaseStatementClose() {
        try {
            stmt.close();
            System.out.println("Statement closed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void RetrieveData() throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT * FROM CONTRACTS;");
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int cost = rs.getInt("cost");
            System.out.println("ID = " + id);
            System.out.println("NAME = " + name);
            System.out.println("AGE = " + cost);
            System.out.println();
        }
        rs.close();
    }
}
