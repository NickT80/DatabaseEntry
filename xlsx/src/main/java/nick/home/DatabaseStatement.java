package nick.home;


import nick.POI.ReadXLSX;
import org.apache.poi.xssf.usermodel.XSSFCell;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Nick Taylor on 12/31/2016.
 */

public class DatabaseStatement{

    XSSFCell name;
    XSSFCell name2;
    XSSFCell cost;
    XSSFCell cost2;


    public String DataRC() throws IOException {
        ArrayList myData = ReadXLSX.readXLSXFile();
        name  = (XSSFCell) myData.get(0);
        name2 = (XSSFCell) myData.get(1);
        cost  = (XSSFCell) myData.get(2);
        cost2 = (XSSFCell) myData.get(3);

        return null;
    }

    Statement stmt = null;

    public void DatabaseStatement(DatabaseConn conn) throws SQLException, IOException {

        System.out.println(name);
        stmt = conn.createStatement();

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
                + "VALUES (name,'"+name+"', 32, 'California', '100000');";
        stmt.executeUpdate(sql);
    }

    public void DatabaseStatementClose(){
        try {
            stmt.close();
            System.out.println("Statement closed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}