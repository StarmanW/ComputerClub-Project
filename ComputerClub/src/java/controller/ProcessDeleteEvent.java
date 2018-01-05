package controller;

import dataAccess.EventCollaboratorDA;
import dataAccess.EventDA;
import dataAccess.EventItemDA;
import dataAccess.EventMemberDA;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Event;

/**
 *
 * @author StarmanW
 */
@WebServlet(name = "ProcessDeleteEvent", urlPatterns = {"/ProcessDeleteEvent"})
public class ProcessDeleteEvent extends HttpServlet {

    //DAs declaration
    EventDA eventDA;
    EventItemDA eventItemDA;
    EventCollaboratorDA eventCollaboratorDA;
    EventMemberDA eventMemberDA;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //If eventToDelete attribute is empty, redirect back to deleteEvent.jsp?eventID=
        if (request.getSession().getAttribute("eventToDelete") == null) {
            response.sendRedirect("deleteEvent.jsp?eventID=");
        } else {
            //Get member object from session
            Event event = (Event) request.getSession().getAttribute("eventToDelete");
            HttpSession session = request.getSession();

            try {
                //Execute member deletion
                eventDA = new EventDA();
                eventItemDA = new EventItemDA();
                eventMemberDA = new EventMemberDA();
                eventCollaboratorDA = new EventCollaboratorDA();

                boolean successDeleteEI = eventItemDA.deleteRecordByEventID(event.getEventID());
                boolean successDeleteEM = eventMemberDA.deleteRecordByEventID(event.getEventID());
                boolean successDeleteEC = eventCollaboratorDA.deleteRecordByEventID(event.getEventID());
                int successDeleteE = eventDA.deleteRecord(event.getEventID());
                if (successDeleteE == 1 && successDeleteEC && successDeleteEI && successDeleteEM) {
                    response.sendRedirect("deleteEventStatus.jsp?success");
                }
            } catch (Exception ex) {
                session.setAttribute("errorMsg", ex.getMessage());
                response.sendRedirect("deleteEventStatus.jsp?error");
                ex.printStackTrace();
            }
        }
    }
}
