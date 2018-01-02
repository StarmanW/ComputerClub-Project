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
@WebServlet(name = "ProcessRegistrationEventItem", urlPatterns = {"/ProcessRegistrationEventItem"})
public class ProcessRegistrationEventItem extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        //Get all parameters value from request
        String[] itemIDList = request.getParameterValues("itemID");

        session.setAttribute("itemIDList", itemIDList);
        
        response.sendRedirect("registerEvent.jsp");
    }

}
