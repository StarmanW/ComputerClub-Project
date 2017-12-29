
package dataAccess;

import java.sql.*;
import java.util.ArrayList;
import model.Member;
import model.Name;

/**
 *
 * @author StarmanW
 */
public class MemberDA {

    //Data fields declaration
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private final String dbUrl = "jdbc:derby://localhost:1527/computerclubdb";
    private final String dbUser = "nbuser";
    private final String dbPass = "nbuser";
    private ProgrammeDA programmeDA;
    
    //No-arg constructor
    public MemberDA() {
        initDBConnection();
    }
    
    //Method to initialize database connection
    private final void initDBConnection() {
        try {
             conn = DriverManager.getConnection(dbUrl, dbUser, dbUser);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    //Method to retrieve all records
    public ArrayList<Member> retrieveAllMembers() {
        ArrayList<Member> members = new ArrayList<Member>();
        
        try {
            pstmt = conn.prepareCall("SELECT * FROM MEMBERS");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                members.add(new Member(
                        rs.getString(1), programmeDA.retrieveProgramme(rs.getString(2)), new Name(rs.getString(3), rs.getString(4)), 
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9).charAt(0), rs.getBoolean(10), 
                        rs.getInt(11), rs.getString(12)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return members;
    }
}
