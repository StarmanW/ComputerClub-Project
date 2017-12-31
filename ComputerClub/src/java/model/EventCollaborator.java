package model;

/**
 *
 * @author ChongJH
 */
public class EventCollaborator {
    
    private String eventColladID;
    private Event event;
    private Collaborator collaborator;

    //No-arg constructor
    public EventCollaborator() {
    }

    //Parameterized constructor
    public EventCollaborator(String eventColladID, Event event, Collaborator collaborator) {
        this.eventColladID = eventColladID;
        this.event = event;
        this.collaborator = collaborator;
    }

    //Setters
    public void setEventColladID(String eventColladID) {
        this.eventColladID = eventColladID;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setCollaborator(Collaborator collaborator) {
        this.collaborator = collaborator;
    }

    //Getters
    public String getEventColladID() {
        return eventColladID;
    }

    public Event getEvent() {
        return event;
    }

    public Collaborator getCollaborator() {
        return collaborator;
    }
    
}
