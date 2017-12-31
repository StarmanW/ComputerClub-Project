package model;

/**
 *
 * @author ChongJH
 */
public class EventMember {

    private String eventMemberID;
    private Event event;
    private Member member;

    //No-arg constructor
    public EventMember() {
    }

    //Parameterized constructor
    public EventMember(String eventMemberID, Member member, Event event) {
        this.eventMemberID = eventMemberID;
        this.event = event;
        this.member = member;
    }

    //Setters
    public void setEventMemberID(String eventMemberID) {
        this.eventMemberID = eventMemberID;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    //Getters
    public String getEventMemberID() {
        return eventMemberID;
    }

    public Event getEvent() {
        return event;
    }

    public Member getMember() {
        return member;
    }
    
}
