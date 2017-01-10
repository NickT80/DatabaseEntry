package nick.home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Nick Taylor on 12/31/2016.
 */

public class DatabaseConn {
    Connection conn = null;


    public void OpenDatabase() {

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

