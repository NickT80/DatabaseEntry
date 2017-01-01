import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Nick Taylor on 12/31/2016.
 */

public class DatabaseStatement {
    Connection c = null;
    Statement stmt = null;

    public void DatabaseStatement(JTextField name) throws SQLException {

        stmt = c.createStatement();

        String sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                + "VALUES (1, '"+name.toString()+"', 32, 'California', '500000');";
        stmt.executeUpdate(sql);
    }

    public void DatabaseStatementClose(){
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}