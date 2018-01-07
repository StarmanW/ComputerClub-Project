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
@WebServlet(name = "ProcessRegistrationEventParticipant", urlPatterns = {"/ProcessRegistrationEventParticipant"})
public class ProcessRegistrationEventParticipant extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        //Get all parameters value from request
        String[] memberIDList = request.getParameterValues("memberID");

        session.setAttribute("memberIDList", memberIDList);
        
        response.sendRedirect("registerEvent.jsp");
    }

}
