package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ChongJH
 */
@WebServlet(name = "ProcessRegistrationEventCollab", urlPatterns = {"/ProcessRegistrationEventCollab"})
public class ProcessRegistrationEventCollab extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        //Get all parameters value from request
        String[] collabIDList = request.getParameterValues("collabID");

        session.setAttribute("collabIDList", collabIDList);
        
        response.sendRedirect("registerEvent.jsp");
    }
}
