import java.util.ArrayList;
import java.util.List;

public class Conference {
  private String name;
  private int maxRegistrants;
  private List<Person> attendees;
  private List<Session> sessions;

  Conference(String name, int maxRegistrants) {
    this.name = name;
    this.maxRegistrants = maxRegistrants;
    this.attendees = new ArrayList<Person>(this.maxRegistrants);
    this.sessions = new ArrayList<Session>();
  }

  public String getName() {
    return this.name;
  }

  public int getMaxRegistrants() {
    return this.maxRegistrants;
  }

  public List<Person> getAttendees() {
    return this.attendees;
  }

  public List<Session> getSessions() {
    return this.sessions;
  }

  public boolean register(Person registrant) {
    if(this.attendees.size() >= this.maxRegistrants) {
      return false;
    }

    for(Person person : this.getAttendees()) {
      if(person.getEmail() == registrant.getEmail()) {
        return false;
      }
    }

    this.attendees.add(registrant);
    return true;
  }

  public boolean addSession(Session session) {
    this.sessions.add(session);
    return true;
  }

  public String getSummary() {
    String attendeeList = "";
    for(Person person : this.attendees) {
      attendeeList += person.getFirstName() + " " + person.getLastName() + "\n";
    }

    String sessionList = "";
    for(Session session : this.sessions) {
      sessionList += session.getName() +
          ", facilitated by " +
          session.getFacilitator().getFirstName() +
          " "  + session.getFacilitator().getLastName() + "\n";
    }

    return this.name + "\n" +
        "Number of Attendees: " + this.attendees.size() +
        "===Attendees===" +
        attendeeList +
        "Number of Sessions: " + this.sessions.size() +
        sessionList;
  }
}
