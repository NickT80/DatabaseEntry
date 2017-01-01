import javax.swing.*;
import java.sql.SQLException;

/**
 * Created by Nick Taylor on 12/31/2016.
 */

public class DataEntryGUI extends JFrame {
    private JTextField textField1;
    private JPanel rootPanel;
    private JButton saveNameAndPassButton;

    public JTextField getTextField1() {
        return textField1;
    }

    public void setTextField1(JTextField textField1) {
        this.textField1 = textField1;
    }

    public DataEntryGUI(){

        setContentPane(rootPanel);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);

        saveNameAndPassButton.addActionListener(e -> {

            System.out.println("Name is : " + textField1);

            DatabaseConn conn = new DatabaseConn();
            DatabaseStatement stmnt = new DatabaseStatement();
            conn.OpenDatabase();

            try {
                stmnt.DatabaseStatement(textField1);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            stmnt.DatabaseStatementClose();
            conn.Commit();
            conn.CloseDatabase();
        });
    }
}
