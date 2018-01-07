package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import javax.servlet.http.*;
import dataAccess.*;
import model.*;

/**
 * @author StarmanW
 * 
 */
@WebServlet(name = "ProcessUpdateEvent", urlPatterns = {"/ProcessUpdateEvent"})
public class ProcessUpdateEvent extends HttpServlet {

    //DAs declaration
    private EventDA eventDA;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //Get UPDATE success count
            int successEventUpdate = updateEvent(request);

            //Update validation
            if ((successEventUpdate == 1)) {
                response.sendRedirect(request.getSession().getAttribute("requestURL") + "?success&eventID=" + request.getSession().getAttribute("eventID"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Method to insert event
    private int updateEvent(HttpServletRequest request) throws ServletException, IOException {
        int successEventUpdate = 0;
        
        String eventID = (String) request.getSession().getAttribute("eventID");
        String eventName = request.getParameter("eventName");
        String eventDate = request.getParameter("eDate");
        String eventStartTime = request.getParameter("eventStartTime");
        String eventEndTime = request.getParameter("eventEndTime");
        String eventLocation = request.getParameter("eventLocation");
        int eventType = Integer.parseInt(request.getParameter("eventType"));

        //Create the new Event object and insert the new event record
        Event event = new Event(eventID, eventName, eventType, eventDate, eventStartTime, eventEndTime, eventLocation);
        try {
            eventDA = new EventDA();
            successEventUpdate = eventDA.updateRecord(event);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return successEventUpdate;
    }
}
