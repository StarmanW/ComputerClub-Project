package model;

/**
 *
 * @author ChongJH
 */
public class EventItem {
    private String eventItemID;
    private Event event;
    private Item item;

    //No-arg constructor
    public EventItem() {
    }

    //Parameterized constructor

    public EventItem(String eventItemID, Event event, Item item) {
        this.eventItemID = eventItemID;
        this.event = event;
        this.item = item;
    }

    //Setters
    public void setEventItemID(String eventItemID) {
        this.eventItemID = eventItemID;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    //Getters
    public String getEventItemID() {
        return eventItemID;
    }

    public Event getEvent() {
        return event;
    }

    public Item getItem() {
        return item;
    }

}
