package controller;

import dataAccess.LoginDA;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Login;
import model.SHA256Hashing;

/**
 *
 * @author StarmanW
 */
@WebServlet(name = "ProcessLogin", urlPatterns = {"/ProcessLogin"})
public class ProcessLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginDA loginDA = new LoginDA();
        SHA256Hashing sha256Hasing = new SHA256Hashing();
        ArrayList<Login> loginList = loginDA.retrieveAllLogin();
        
        boolean loginSuccess = false;
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        for (int i = 0; i < loginList.size(); i++) {
            if (sha256Hasing.getHashedText(userName).equals(loginList.get(i).getUserName()) && sha256Hasing.getHashedText(password).equals(loginList.get(i).getUserPassword())) {
                if (loginList.get(i).getUserRights().equals("admin")) {
                    response.sendRedirect("homepage.jsp");
                    loginSuccess = true;
                    break;
                } else if (loginList.get(i).getUserRights().equals("member")) {
                    response.sendRedirect("memberPages/homepage.jsp");
                    loginSuccess = true;
                    break;
                }
            }
        }
        
        if (!loginSuccess) {
            response.sendRedirect("index.jsp?invalid");
        }
    }
}
