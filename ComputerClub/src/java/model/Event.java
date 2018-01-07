/**
 *
 * @author Kyj
 */
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event implements Comparable<Event> {

    private String eventID;
    private String eventName;
    private int eventType;
    private String eventDate;
    private String eventStartTime;
    private String eventEndTime;
    private String eventLocation;

    //No-arg constructor
    public Event() {

    }

    //Parameterized constructor
    public Event(String eventID, String eventName, int eventType, String eventDate, String eventStartTime, String eventEndTime, String eventLocation) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.eventType = eventType;
        this.eventDate = eventDate;
        this.eventStartTime = eventStartTime;
        this.eventEndTime = eventEndTime;
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

    public void setEventStartTime(String eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public void setEventEndTime(String eventEndTime) {
        this.eventEndTime = eventEndTime;
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

        switch (eventType) {
            case 1:
                eventTypeString = "Others";
                break;
            case 2:
                eventTypeString = "Event Exhibition";
                break;
            case 3:
                eventTypeString = "Workshop/Talk";
                break;
            case 4:
                eventTypeString = "Educational Visit/Trip";
                break;
            case 5:
                eventTypeString = "Competition";
                break;
            default:
                break;
        }

        return eventTypeString;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getEventStartTime() {
        return eventStartTime;
    }

    public String getEventEndTime() {
        return eventEndTime;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    @Override
    public int compareTo(Event event) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        
        Date parsedDate1 = null;
        Date parsedDate2 = null;
        
        try {
            parsedDate1 = parser.parse(getEventDate());
            parsedDate2 = parser.parse(event.getEventDate());
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
        if (parsedDate1 == null || parsedDate2 == null) {
            return 0;
        }
        
        return parsedDate1.compareTo(parsedDate2);
    }

}
