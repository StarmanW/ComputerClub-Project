package controller;

import dataAccess.EventDA;
import dataAccess.EventItemDA;
import dataAccess.ItemDA;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.EventItem;

/**
 *
 * @author StarmanW
 */
@WebServlet(name = "ProcessUpdateEventItem", urlPatterns = {"/ProcessUpdateEventItem"})
public class ProcessUpdateEventItem extends HttpServlet {

    
    EventItemDA eventItemDA;
    EventDA eventDA;
    ItemDA itemDA;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String eventID = (String) request.getSession().getAttribute("eventID");
        instantiateDAs();

        if (request.getParameter("add") != null) {
            String itemID = request.getParameter("add");
            addNewEventItem(itemID, eventID);
            response.sendRedirect(request.getSession().getAttribute("requestURL") + "?successAdd&eventID=" + eventID);
        } else if (request.getParameter("delete") != null) {
            String itemID = request.getParameter("delete");
            deleteEventItem(eventID, itemID);
            response.sendRedirect(request.getSession().getAttribute("requestURL") + "?successDelete&eventID=" + eventID);
        }
    }
    
    //Method to instantiate all DAs
    private void instantiateDAs() {
        eventItemDA = new EventItemDA();
        eventDA = new EventDA();
        itemDA = new ItemDA();
    }

    //Method to perform insertion on EventItem
    private void addNewEventItem(String itemID, String eventID) {
        ArrayList<EventItem> eventItemList = null;
        String eventItemID = null;

        //Create new EventItem object and insert record
        eventItemList = eventItemDA.selectAllEventItemList();

        if (!eventItemList.isEmpty()) {
            int lastID = Integer.parseInt(eventItemList.get(eventItemList.size() - 1).getEventItemID().substring(2, 6));
            eventItemID = String.format("EI%04d", (lastID + 1));
        } else {
            eventItemID = String.format("EI%04d", 1);
        }

        EventItem eventItem = new EventItem(eventItemID, eventDA.selectRecord(eventID), itemDA.selectRecord(itemID));
        try {
            eventItemDA.createRecord(eventItem);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Method to perform deletion on EventItem
    private void deleteEventItem(String eventID, String itemID) {
        try {
            eventItemDA.deleteRecordByItemID(eventID, itemID);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
