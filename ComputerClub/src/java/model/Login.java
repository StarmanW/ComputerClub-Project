package model;

/**
 *
 * @author Samuel Wong King Foong
 */
public class Login {
    
    //Data fields declaration
    private String userName;
    private String userPassword;
    private String userRights;
    
    //Parameterized constructor
    public Login(String userName, String userPassword, String userRights) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRights = userRights;
    }

    //Setters
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserRights(String userRights) {
        this.userRights = userRights;
    }

    //Getters
    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserRights() {
        return userRights;
    }
}
