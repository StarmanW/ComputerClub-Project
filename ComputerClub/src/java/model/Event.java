/**
 *
 * @author Kyj
 */
package model;

import java.util.ArrayList;
import java.util.Date;

public class Event {

    private String eventID;
    private String eventName;
    private int eventType;
    private String eventDate;
    private String eventTime;
    private String eventLocation;

    //No-arg constructor
    public Event() {

    }

    //Parameterized constructor
    public Event(String eventID, String eventName, int eventType, String eventDate, String eventTime, String eventLocation) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.eventType = eventType;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventLocation = eventLocation;
    }

    //Setters
    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    //Getters
    public String getEventID() {
        return eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public int getEventType() {
        return eventType;
    }
    
    public String getEventTypeString() {
       String eventTypeString = null;
       
       switch(eventType) {
           case 1:
               eventTypeString = "Others";
               break;
           case 2:
               eventTypeString = "Event Exhibitions";
               break;
           case 3:
               eventTypeString = "Workshops/Talks";
               break;
           case 4:
               eventTypeString = "Educational Visit/Trips";
               break;
           case 5:
               eventTypeString = "Competitions";
               break;
            default:
                break;
       }
       
       return eventTypeString;
    }
    
    public String getEventDate() {
        return eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public String getEventLocation() {
        return eventLocation;
    }

}
