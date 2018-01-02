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
public class ProcessRegistrationEvent extends HttpServlet {

    private EventDA eventDA;
    private EventCollaboratorDA eventCollaboratorDA;
    private EventMemberDA eventMemberDA;
    private EventItemDA eventItemDA;
    private ItemDA itemDA;
    private MemberDA memberDA;
    private CollaboratorDA collaboratorDA;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Get values from request
        String eventName = request.getParameter("eventName");
        String eventDate = request.getParameter("eventDate");
        String eventStartTime = request.getParameter("eventStartTime");
        String eventEndTime = request.getParameter("eventEndTime");
        String eventLocation = request.getParameter("eventLocation");
        int eventType = Integer.parseInt(request.getParameter("eventType"));
        String[] itemIDList = (String[]) request.getSession().getAttribute("itemIDList");
//        String[] memberIDList = (String[]) request.getSession().getAttribute("memberIDList");
//        String[] collabIDList = (String[]) request.getSession().getAttribute("collabIDList");

        //Success variable declaration
        int successEventInsert = 0;
        int successEventItemInsert = 0;
        int successEventMemberInsert = 0;
        int successEventCollaboratorInsert = 0;

        try {
            instantiateAllDA();
            String eventID = generateEventID();

            //Create the new Event object and insert the new event record
            Event event = new Event(eventID, eventName, eventType, eventDate, eventStartTime, eventEndTime, eventLocation);
            successEventInsert = eventDA.createRecord(event);

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
                successEventItemInsert = eventItemDA.createRecord(eventItem);
            }

//            //For loop to create new EventMember object and insert all records
//            for (int i = 0; i < itemIDList.length; i++) {
//                EventMember eventMember = new EventMember(eventID, memberDA.selectRecord(memberIDList[i]), eventDA.selectRecord(eventID));
//                successEventMemberInsert = eventMemberDA.createRecord(eventMember);
//            }
//
//            //For loop to create new EventCollaborator object and insert all records
//            for (int i = 0; i < itemIDList.length; i++) {
//                EventCollaborator eventCollaborator = new EventCollaborator(eventID, eventDA.selectRecord(eventID), collaboratorDA.selectRecord(collabIDList[i]));
//                successEventCollaboratorInsert = eventCollaboratorDA.createRecord(eventCollaborator);
//            }
            //Insert validation
            //STUB
            //if (all success insert value is correct) { redirect back to registerEvent.jsp?success }
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
}
