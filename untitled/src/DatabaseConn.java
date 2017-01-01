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
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "encorelink", "");
            conn.setAutoCommit(false);
            System.out.println("Opened database successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void CloseDatabase() {
        try {
            conn.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
    public void Commit(){
        try{
            conn.commit();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
