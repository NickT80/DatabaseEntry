package nick.home;

import nick.POI.ReadXLSX;
import org.apache.poi.xssf.usermodel.XSSFCell;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Nick Taylor on 12/31/2016.
 */

public class DatabaseConn {
    Connection conn = null;
    Statement stmt = null;
    XSSFCell name;
    XSSFCell name2;
    XSSFCell cost;
    XSSFCell cost2;


    public void DataRC () throws IOException {
        ArrayList myData = ReadXLSX.readXLSXFile();
        name = (XSSFCell) myData.get(0);
        name2 = (XSSFCell) myData.get(1);
        cost = (XSSFCell) myData.get(2);
        cost2 = (XSSFCell) myData.get(3);

    }

    public void OpenDatabase() {

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager
                    .getConnection("jdbc:postgresql://192.168.1.224:5432/postgres",
                            "postgres", "");
            conn.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = conn.createStatement();
            System.out.println("inside");
            /*String sqlStatement = "CREATE TABLE CONTRACTS" +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " COST           DOUBLE PRECISION     NOT NULL)";
            stmt.executeUpdate(sqlStatement);*/

            System.out.println("Attempting to add data.");
            String sqlAdd = "INSERT INTO CONTRACTS (ID,NAME,COST) "
                    + "VALUES (1,'" + name + "', '" + cost + "');";
            String sqlAdd2 = "INSERT INTO CONTRACTS (ID,NAME,COST) "
                    + "VALUES (2,'" + name2 + "', '" + cost2 + "');";
            stmt.executeUpdate(sqlAdd);
            stmt.executeUpdate(sqlAdd2);

            System.out.println("Attempting to get data.");
            ResultSet rs = stmt.executeQuery("SELECT * FROM CONTRACTS;");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int cost = rs.getInt("cost");
                System.out.println("ID = " + id);
                System.out.println("NAME = " + name);
                System.out.println("COST = " + cost);
                System.out.println();
            }
            rs.close();
            stmt.close();
            System.out.println("Statement closed");
            conn.commit();
            System.out.println("Committed");

            conn.close();
            System.out.println("Closed Connection to DB");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void CloseDatabase() {
        try {
            System.out.println("Attempting to close");
            conn.close();
            System.out.println("Closed Connection to DB");

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void Commit(){
        try{
            System.out.println("Attempting to commit");
            conn.commit();
            System.out.println("Committed");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

