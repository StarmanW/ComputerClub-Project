package controller;

import dataAccess.CollaboratorDA;
import dataAccess.EventCollaboratorDA;
import dataAccess.EventDA;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.EventCollaborator;

/**
 *
 * @author StarmanW
 */
@WebServlet(name = "ProcessUpdateEventCollab", urlPatterns = {"/ProcessUpdateEventCollab"})
public class ProcessUpdateEventCollab extends HttpServlet {

    EventCollaboratorDA eventCollaboratorDA;
    EventDA eventDA;
    CollaboratorDA collaboratorDA;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String eventID = (String) request.getSession().getAttribute("eventID");
        instantiateDAs();

        if (request.getParameter("add") != null) {
            String collabID = request.getParameter("add");
            addNewEventCollaborator(collabID, eventID);
            response.sendRedirect(request.getSession().getAttribute("requestURL") + "?successAdd&eventID=" + eventID);
        } else if (request.getParameter("delete") != null) {
            String collabID = request.getParameter("delete");
            deleteEventCollaborator(eventID, collabID);
            response.sendRedirect(request.getSession().getAttribute("requestURL") + "?successDelete&eventID=" + eventID);
        }
    }

    //Method to instantiate all DAs
    private void instantiateDAs() {
        eventCollaboratorDA = new EventCollaboratorDA();
        eventDA = new EventDA();
        collaboratorDA = new CollaboratorDA();
    }

    //Method to perform insertion on EventCollaborator
    private void addNewEventCollaborator(String collabID, String eventID) {
        ArrayList<EventCollaborator> eventCollaboratorList = null;
        String eventCollaboratorID = null;

        //Create new EventCollaborator object and insert record
        eventCollaboratorList = eventCollaboratorDA.selectAllEventCollabList();

        if (!eventCollaboratorList.isEmpty()) {
            int lastID = Integer.parseInt(eventCollaboratorList.get(eventCollaboratorList.size() - 1).getEventColladID().substring(2, 6));
            eventCollaboratorID = String.format("EC%04d", (lastID + 1));
        } else {
            eventCollaboratorID = String.format("EC%04d", 1);
        }

        EventCollaborator eventCollaborator = new EventCollaborator(eventCollaboratorID, eventDA.selectRecord(eventID), collaboratorDA.selectRecord(collabID));
        try {
            eventCollaboratorDA.createRecord(eventCollaborator);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Method to perform deletion on EventCollaborator
    private void deleteEventCollaborator(String eventID, String collabID) {
        try {
            eventCollaboratorDA.deleteRecordByCollabEventID(eventID, collabID);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
