package nick.home;

import nick.POI.ReadXLSX;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Nick Taylor on 12/30/2016.
 */

public class Main {

    public static void main(String[] args) throws SQLException, IOException{

        ReadXLSX xl = new ReadXLSX();
        xl.readXLSXFile();

        DatabaseConn dbConn = new DatabaseConn();
        dbConn.OpenDatabase();

        DatabaseStatement dbData = new DatabaseStatement();
        dbData.DataRC();

        System.out.println(dbData.name);

        /*try {
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
        *//*try {
            String sql = "CREATE TABLE CALLS" +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " LENGTH         INT     NOT NULL," +
                    " NUMBER         REAL     NOT NULL)";
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }*//*

        System.out.println("Attempting to add data.");
        String sql = "INSERT INTO PEOPLE (ID,NAME,AGE,ADDRESS,SALARY) "
                + "VALUES (6,'Larry', 46, 'Colorado', '5600000')";
        stmt.executeUpdate(sql);

        sql = "INSERT INTO CALLS (ID, NAME, LENGTH, NUMBER) "
                + "VALUES (4,'Nick', '5', '4543333333')";
        stmt.executeUpdate(sql);

        ResultSet rs = stmt.executeQuery( "SELECT * FROM PEOPLE;" );
        while ( rs.next() ) {
            int id = rs.getInt("id");
            String  name = rs.getString("name");
            int age  = rs.getInt("age");
            String  address = rs.getString("address");
            float salary = rs.getFloat("salary");
            System.out.println( "ID = " + id );
            System.out.println( "NAME = " + name );
            System.out.println( "AGE = " + age );
            System.out.println( "ADDRESS = " + address );
            System.out.println( "SALARY = " + salary );
            System.out.println();
        }

        rs = stmt.executeQuery( "SELECT * FROM CALLS;" );
        while ( rs.next() ) {
            int id = rs.getInt("id");
            String  name = rs.getString("name");
            int length  = rs.getInt("length");
            long number = rs.getLong("number");
            System.out.println( "ID = " + id );
            System.out.println( "NAME = " + name );
            System.out.println( "LENGTH in minutes = " + length );
            System.out.println( "NUMBER = " + number);
            System.out.println();
        }

        rs.close();
        stmt.close();
        conn.commit();
        conn.close();*/
    }

   /* public void addPeople(int ID, String NAME, int AGE, int ADDRESS, int SALARY) throws SQLException {
        System.out.println("Attempting to add data.");
        String sql = "INSERT INTO PEOPLE (ID,NAME,AGE,ADDRESS,SALARY) "
                + "VALUES (1,'John', 32, 'California', '100000');";
        stmt.executeUpdate(sql);
    }*/
}