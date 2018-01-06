package dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Login;

/**
 *
 * @author StarmanW
 */
public class LoginDA {

    //Data fields declaration
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private final String dbUrl = "jdbc:derby://localhost:1527/computerclubdb";
    private final String dbUser = "nbuser";
    private final String dbPass = "nbuser";
    String tableName = " LOGIN ";

    public LoginDA() {
        initDBConnection();
    }

    //Method to initialize database connection
    private final void initDBConnection() {
        try {
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Method to retrieve all login details
    public ArrayList<Login> retrieveAllLogin() {
        ArrayList<Login> loginList = new ArrayList<Login>();

        try {
            pstmt = conn.prepareStatement("SELECT * FROM" + tableName);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                loginList.add(new Login(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return loginList;
    }
}
