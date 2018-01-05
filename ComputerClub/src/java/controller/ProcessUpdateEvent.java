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
 */
@WebServlet(name = "ProcessUpdateEvent", urlPatterns = {"/ProcessUpdateEvent"})
public class ProcessUpdateEvent extends HttpServlet {

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
            int successEventItemUpdate = 0;
            int successEventCollaboratorUpdate = 0;
            int successEventMemberUpdate = 0;

            //Instantiate all DA and generate the latest event ID
            instantiateAllDA();

            //Get INSERT success count
            int successEventUpdate = updateEvent(request);

            //Get INSERT success count if each of the list is not null
//            if (itemIDList != null) {
//                successEventItemUpdate = updateEventItem(request);
//            }
            if (collabIDList != null) {
                successEventCollaboratorUpdate = updateEventCollaborator(request);
            }
//            if (memberIDList != null) {
//                successEventMemberUpdate = updateEventMember(request);
//            }

            //Update validation
            if ((successEventUpdate == 1)
//                    && ((itemIDList != null && successEventItemUpdate == itemIDList.length)
//                    || (collabIDList != null && successEventCollaboratorUpdate == collabIDList.length)
//                    || (memberIDList != null && successEventMemberUpdate == memberIDList.length))
                    ) {
                response.sendRedirect("updateEvent.jsp?success&eventID=" + request.getSession().getAttribute("eventID"));
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
            successEventUpdate = eventDA.updateRecord(event);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return successEventUpdate;
    }

//    //Method to insert EventCollaborator
//    private int updateEventCollaborator(HttpServletRequest request) throws ServletException, IOException {
//        int successEventCollaboratorInsert = 0;
//
//        String[] collabIDList = (String[]) request.getSession().getAttribute("collabIDList");
//        ArrayList<EventCollaborator> eventCollaboratorList = null;
//        String eventCollaboratorID = null;
//
//        //For loop to create new EventMember object and insert all records
//        for (int i = 0; i < collabIDList.length; i++) {
//            eventCollaboratorList = eventCollaboratorDA.selectAllEventCollabList();
//
//            if (!eventCollaboratorList.isEmpty()) {
//                int lastID = Integer.parseInt(eventCollaboratorList.get(eventCollaboratorList.size() - 1).getEventColladID().substring(2, 6));
//                eventCollaboratorID = String.format("EC%04d", (lastID + 1));
//            } else {
//                eventCollaboratorID = String.format("EC%04d", 1);
//            }
//
//            EventCollaborator eventCollaborator = new EventCollaborator(eventCollaboratorID, eventDA.selectRecord(eventID), collaboratorDA.selectRecord(collabIDList[i]));
//            try {
//                eventCollaboratorDA.createRecord(eventCollaborator);
//                successEventCollaboratorInsert++;
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
//        return successEventCollaboratorInsert;
//    }
//
//    //Method to insert EventItem
//    private int updateEventItem(HttpServletRequest request) throws ServletException, IOException {
//        int successEventItemInsert = 0;
//
//        String[] itemIDList = (String[]) request.getSession().getAttribute("itemIDList");
//        ArrayList<EventItem> eventItemList = null;
//        String eventItemID = null;
//
//        //For loop to create new EventItem object and insert all records
//        for (int i = 0; i < itemIDList.length; i++) {
//            eventItemList = eventItemDA.selectAllEventItemList();
//
//            if (!eventItemList.isEmpty()) {
//                int lastID = Integer.parseInt(eventItemList.get(eventItemList.size() - 1).getEventItemID().substring(2, 6));
//                eventItemID = String.format("EI%04d", (lastID + 1));
//            } else {
//                eventItemID = String.format("EI%04d", 1);
//            }
//            EventItem eventItem = new EventItem(eventItemID, eventDA.selectRecord(eventID), itemDA.selectRecord(itemIDList[i]));
//            try {
//                eventItemDA.createRecord(eventItem);
//                successEventItemInsert++;
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
//        return successEventItemInsert;
//    }
//
//    //Method to insert EventMember
//    private int updateEventMember(HttpServletRequest request) {
//        int successEventMemberInsert = 0;
//
//        String[] memberIDList = (String[]) request.getSession().getAttribute("memberIDList");
//        ArrayList<EventMember> eventMemberList = null;
//        String eventItemID = null;
//
//        //For loop to create new EventCollaborator object and insert all records
//        for (int i = 0; i < memberIDList.length; i++) {
//            eventMemberList = eventMemberDA.selectAllEventMemberList();
//
//            if (!eventMemberList.isEmpty()) {
//                int lastID = Integer.parseInt(eventMemberList.get(eventMemberList.size() - 1).getEventMemberID().substring(2, 6));
//                eventItemID = String.format("EM%04d", (lastID + 1));
//            } else {
//                eventItemID = String.format("EM%04d", 1);
//            }
//            EventMember eventMember = new EventMember(eventItemID, memberDA.selectRecord(memberIDList[i]), eventDA.selectRecord(eventID));
//            try {
//                eventMemberDA.createRecord(eventMember);
//                successEventMemberInsert++;
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
//        return successEventMemberInsert;
//    }
}
