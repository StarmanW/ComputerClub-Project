package controller;

import dataAccess.EventCollaboratorDA;
import dataAccess.EventDA;
import dataAccess.EventItemDA;
import dataAccess.EventMemberDA;
import dataAccess.ItemDA;
import dataAccess.MemberDA;
import dataAccess.CollaboratorDA;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.EventCollaborator;
import model.EventMember;
import model.EventItem;
import model.Event;

/**
 *
 * @author StarmanW
 */
@WebServlet(name = "ProcessRegistrationEvent", urlPatterns = {"/ProcessRegistrationEvent"})
public class ProcessRegistrationEvent1 extends HttpServlet {

    private EventDA eventDA;
    private EventCollaboratorDA eventCollaboratorDA;
    private EventMemberDA eventMemberDA;
    private EventItemDA eventItemDA;
    private ItemDA itemDA;
    private MemberDA memberDA;
    private CollaboratorDA collaboratorDA;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            instantiateAllDA();

            String eventID = generateEventID();

            int successEventInsert = insertEvent(request, eventID);
            int successEventItemInsert = insertEventItem(request, eventID);
            int successEventCollaboratorInsert = insertEventCollaborator(request, eventID);
            int successEventMemberInsert = insertEventMember(request, eventID);

            //Insert validation
            //STUB
            //if (all success insert value is correct) { redirect back to registerEvent.jsp?success }
            /**
             * ***Why check itemIDList?******
             */
            if ((successEventInsert == 1) && (successEventItemInsert == itemIDList.length - 1)) {
                response.sendRedirect("registerEvent.jsp?success");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Method to instantiate all DA object
    private void instantiateAllDA() {
        eventDA = new EventDA();
        eventCollaboratorDA = new EventCollaboratorDA();
        eventMemberDA = new EventMemberDA();
        eventItemDA = new EventItemDA();
        itemDA = new ItemDA();
    }

    //Method to generate ID for latest Event
    private String generateEventID() {
        //Retrieve all event records
        //Substring the value from last record and +1 to generate the latest value
        //for the new Event record
        String eventID = null;
        ArrayList<Event> eventList = eventDA.selectAllEventsList();

        if (!eventList.isEmpty()) {
            int lastID = Integer.parseInt(eventList.get(eventList.size() - 1).getEventID().substring(1, 5));
            eventID = String.format("E%04d", (lastID + 1));
        } else {
            eventID = String.format("E%04d", 1);
        }

        return eventID;
    }

    //Method to insert event
    private int insertEvent(HttpServletRequest request, String eventID) throws ServletException, IOException {
        int successEventInsert = 0;

        String eventName = request.getParameter("eventName");
        String eventDate = request.getParameter("eventDate");
        String eventStartTime = request.getParameter("eventStartTime");
        String eventEndTime = request.getParameter("eventEndTime");
        String eventLocation = request.getParameter("eventLocation");
        int eventType = Integer.parseInt(request.getParameter("eventType"));

        //Create the new Event object and insert the new event record
        Event event = new Event(eventID, eventName, eventType, eventDate, eventStartTime, eventEndTime, eventLocation);
        try {
            successEventInsert = eventDA.createRecord(event);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return successEventInsert;
    }

    //Method to insert EventCollaborator
    private int insertEventCollaborator(HttpServletRequest request, String eventID) throws ServletException, IOException {
        int successEventCollaboratorInsert = 0;

        String[] collabIDList = (String[]) request.getSession().getAttribute("collabIDList");
        ArrayList<EventCollaborator> eventCollaboratorList = null;
        String eventCollaboratorID = null;

        //For loop to create new EventMember object and insert all records
        for (int i = 0; i < collabIDList.length; i++) {
            eventCollaboratorList = eventCollaboratorDA.selectAllEventCollabList();

            if (!eventCollaboratorList.isEmpty()) {
                int lastID = Integer.parseInt(eventCollaboratorList.get(eventCollaboratorList.size() - 1).getEventColladID().substring(2, 6));
                eventCollaboratorID = String.format("EC%04d", (lastID + 1));
            } else {
                eventCollaboratorID = String.format("EC%04d", 1);
            }

            EventCollaborator eventCollaborator = new EventCollaborator(eventCollaboratorID, eventDA.selectRecord(eventID), collaboratorDA.selectRecord(collabIDList[i]));

            try {
                successEventCollaboratorInsert = eventCollaboratorDA.createRecord(eventCollaborator);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

        return successEventCollaboratorInsert;

    }

    //Method to insert EventItem
    private int insertEventItem(HttpServletRequest request, String eventID) throws ServletException, IOException {
        int successEventItemInsert = 0;

        String[] itemIDList = (String[]) request.getSession().getAttribute("itemIDList");
        ArrayList<EventItem> eventItemList = null;
        String eventItemID = null;

        //For loop to create new EventItem object and insert all records
        for (int i = 0; i < itemIDList.length; i++) {
            eventItemList = eventItemDA.selectAllEventItemList();

            if (!eventItemList.isEmpty()) {
                int lastID = Integer.parseInt(eventItemList.get(eventItemList.size() - 1).getEventItemID().substring(2, 6));
                eventItemID = String.format("EI%04d", (lastID + 1));
            } else {
                eventItemID = String.format("EI%04d", 1);
            }

            EventItem eventItem = new EventItem(eventItemID, eventDA.selectRecord(eventID), itemDA.selectRecord(itemIDList[i]));

            try {
                successEventItemInsert = eventItemDA.createRecord(eventItem);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return successEventItemInsert;
    }

    //Method to insert EventMember
    private int insertEventMember(HttpServletRequest request, String eventID) {
        int successEventMemberInsert = 0;

        String[] memberIDList = (String[]) request.getSession().getAttribute("memberIDList");
        ArrayList<EventMember> eventMemberList = null;
        String eventItemID = null;

        //For loop to create new EventCollaborator object and insert all records
        for (int i = 0; i < memberIDList.length; i++) {

            if (!eventMemberList.isEmpty()) {
                int lastID = Integer.parseInt(eventMemberList.get(eventMemberList.size() - 1).getEventMemberID().substring(2, 6));
                eventItemID = String.format("EM%04d", (lastID + 1));
            } else {
                eventItemID = String.format("EM%04d", 1);
            }

            EventMember eventMember = new EventMember(eventItemID, memberDA.selectRecord(memberIDList[i]), eventDA.selectRecord(eventID));

            try {
                successEventMemberInsert = eventMemberDA.createRecord(eventMember);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
            return successEventMemberInsert;
        }
    }
}
