package controller;

import dataAccess.EventDA;
import dataAccess.EventMemberDA;
import dataAccess.MemberDA;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.EventMember;

/**
 *
 * @author StarmanW
 */
@WebServlet(name = "ProcessUpdateEventMember", urlPatterns = {"/ProcessUpdateEventMember"})
public class ProcessUpdateEventMember extends HttpServlet {

    EventMemberDA eventMemberDA;
    EventDA eventDA;
    MemberDA memberDA;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String eventID = (String) request.getSession().getAttribute("eventID");
        instantiateDAs();

        if (request.getParameter("add") != null) {
            String studID = request.getParameter("add");
            addNewEventParticipant(studID, eventID);
            response.sendRedirect("updateEventParticipants.jsp?successAdd&eventID=" + eventID);
        } else if (request.getParameter("delete") != null) {
            String studID = request.getParameter("delete");
            deleteEventParticipant(studID);
            response.sendRedirect("updateEventParticipants.jsp?successDelete&eventID=" + eventID);
        }    
    }
    
    //Method to instantiate all DAs
    private void instantiateDAs() {
        eventMemberDA = new EventMemberDA();
        eventDA = new EventDA();
        memberDA = new MemberDA();
    }
    
    
    //Method to perform insertion on EventMember
    private void addNewEventParticipant(String studID, String eventID) {
        ArrayList<EventMember> eventMembersList = null;
        String eventMemberID = null;

        //Create new EventCollaborator object and insert record
        eventMembersList = eventMemberDA.selectAllEventMemberList();

        if (!eventMembersList.isEmpty()) {
            int lastID = Integer.parseInt(eventMembersList.get(eventMembersList.size() - 1).getEventMemberID().substring(2, 6));
            eventMemberID = String.format("EM%04d", (lastID + 1));
        } else {
            eventMemberID = String.format("EM%04d", 1);
        }

        EventMember eventMember = new EventMember(eventMemberID, memberDA.selectRecord(studID), eventDA.selectRecord(eventID));
        try {
            eventMemberDA.createRecord(eventMember);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Method to perform deletion on EventMember
    private void deleteEventParticipant(String studID) {
        try {
            eventMemberDA.deleteRecordByMemberID(studID);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
