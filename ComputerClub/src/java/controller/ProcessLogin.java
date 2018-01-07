package controller;

import dataAccess.LoginDA;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Login;
import model.SHA256Hashing;

/**
 *
 * @author Samuel Wong Kim Foong
 * 
 * Contributed by ChongJH
 */
@WebServlet(name = "ProcessLogin", urlPatterns = {"/ProcessLogin"})
public class ProcessLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginDA loginDA = new LoginDA();
        SHA256Hashing sha256Hashing = new SHA256Hashing();
        ArrayList<Login> loginList = loginDA.retrieveAllLogin();

        boolean loginSuccess = false;
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();

        for (int i = 0; i < loginList.size(); i++) {
            if (sha256Hashing.getHashedText(userName).equals(loginList.get(i).getUserName()) && sha256Hashing.getHashedText(password).equals(loginList.get(i).getUserPassword())) {
                session.setAttribute("userName", userName);
                
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
