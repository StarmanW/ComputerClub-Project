package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.*;
import dataAccess.*;
import model.*;

/**
 * @author StarmanW
 * 
 * Contributed by Chong JH
 * 
 */
@WebServlet(name = "ProcessRegistrationEvent", urlPatterns = {"/ProcessRegistrationEvent"})
public class ProcessRegistrationEvent extends HttpServlet {

    //DAs declaration
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
            //Local variable declaration
            int successEventItemInsert = 0;
            int successEventCollaboratorInsert = 0;
            int successEventMemberInsert = 0;
            
            //Remove the temporary event object
            request.getSession().removeAttribute("tempEvent");
            
            //Get the length of each list for verification below
            String[] itemIDList = (String[]) request.getSession().getAttribute("itemIDList");
            String[] collabIDList = (String[]) request.getSession().getAttribute("collabIDList");
            String[] memberIDList = (String[]) request.getSession().getAttribute("memberIDList");

            //Instantiate all DA and generate the latest event ID
            instantiateAllDA();
            String eventID = generateEventID();

            //Get INSERT success count
            int successEventInsert = insertEvent(request, eventID);

            //Get INSERT success count if each of the list is not null
            if (itemIDList != null) {
                successEventItemInsert = insertEventItem(request, eventID);
            }
            if (collabIDList != null) {
                successEventCollaboratorInsert = insertEventCollaborator(request, eventID);
            }
            if (memberIDList != null) {
                successEventMemberInsert = insertEventMember(request, eventID);
            }

            //Insert validation
            if ((successEventInsert == 1)
                    || ((itemIDList != null && successEventItemInsert == itemIDList.length)
                    || (collabIDList != null && successEventCollaboratorInsert == collabIDList.length)
                    || (memberIDList != null && successEventMemberInsert == memberIDList.length))) {
                response.sendRedirect(request.getSession().getAttribute("requestURL") + "?success");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Method to instantiate all DA object
    private void instantiateAllDA() {
        collaboratorDA = new CollaboratorDA();
        memberDA = new MemberDA();
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
        String eventDate = request.getParameter("eDate");
        String eventStartTime = request.getParameter("eventStartTime");
        String eventEndTime = request.getParameter("eventEndTime");
        String eventLocation = request.getParameter("eventLocation");
        int eventType = Integer.parseInt(request.getParameter("eventType"));

        //Create the new Event object and insert the new event record
        Event event = new Event(eventID, eventName, eventType, eventDate, eventStartTime, eventEndTime, eventLocation);
        try {
            eventDA.createRecord(event);
            successEventInsert++;
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
                eventCollaboratorDA.createRecord(eventCollaborator);
                successEventCollaboratorInsert++;
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
                eventItemDA.createRecord(eventItem);
                successEventItemInsert++;
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
            eventMemberList = eventMemberDA.selectAllEventMemberList();

            if (!eventMemberList.isEmpty()) {
                int lastID = Integer.parseInt(eventMemberList.get(eventMemberList.size() - 1).getEventMemberID().substring(2, 6));
                eventItemID = String.format("EM%04d", (lastID + 1));
            } else {
                eventItemID = String.format("EM%04d", 1);
            }
            EventMember eventMember = new EventMember(eventItemID, memberDA.selectRecord(memberIDList[i]), eventDA.selectRecord(eventID));
            try {
                eventMemberDA.createRecord(eventMember);
                successEventMemberInsert++;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return successEventMemberInsert;
    }
}
