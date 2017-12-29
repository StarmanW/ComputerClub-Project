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
    private char eventType;
    private Date eventDate;
    private String eventTime;
    private String eventLocation;
    private ArrayList<Collaborator> eventColab;
    private ArrayList<Item> sponsoredItem;
    private ArrayList<Member> parpicipant;
    private String additionalNotes;

    //No-arg constructor
    public Event() {

    }

    //Parameterized constructor
    public Event(String eventID, String eventName, char eventType, Date eventDate, String eventTime, String eventLocation, ArrayList<Collaborator> eventColab, ArrayList<Item> sponsoredItem, ArrayList<Member> parpicipant, String additionalNotes) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.eventType = eventType;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventLocation = eventLocation;
        this.eventColab = eventColab;
        this.sponsoredItem = sponsoredItem;
        this.parpicipant = parpicipant;
        this.additionalNotes = additionalNotes;
    }

    //Setters
    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventType(char eventType) {
        this.eventType = eventType;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public void setEventColab(ArrayList<Collaborator> eventColab) {
        this.eventColab = eventColab;
    }

    public void setSponsoredItem(ArrayList<Item> sponsoredItem) {
        this.sponsoredItem = sponsoredItem;
    }

    public void setParpicipant(ArrayList<Member> parpicipant) {
        this.parpicipant = parpicipant;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    
    //Getters
    public String getEventID() {
        return eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public char getEventType() {
        return eventType;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public ArrayList<Collaborator> getEventColab() {
        return eventColab;
    }

    public ArrayList<Item> getSponsoredItem() {
        return sponsoredItem;
    }

    public ArrayList<Member> getParpicipant() {
        return parpicipant;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

}
