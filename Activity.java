import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

// JUNCTION LABELING
//
//      |9 !10|
//    0 !1 ! 2! 3
//    7 !6 ! 5! 4
//      |8 !11|

// Represents the road junction activity in a thread-safe CopyOnWriteArrayList<String>
// called activities
// - addMessage(String) adds a message to the record
// - addMovedTo(int) adds a car movement activity to the record
// - addEntry(int, String) adds a car entry activity to the record, and its intended direction
// - addExit(String) adds a car exit activity to the record
// - printActivities() display all the activity history of the car movement
// - roadJunctionString() takes a snapshot of the road junction (with cars) for printing

public class Activity {
    private final List<String> activities;

    private final Junction junction;

    // Constructor for objects of class Activity
    // A reference to the roadJunction is passed as a parameter
    public Activity(Junction junction) {
        activities = new CopyOnWriteArrayList<>();
        this.junction = junction;
    } // End constructor

    public void addMovedTo(int section) {
        // Add an activity message to the activity history
        activities.add("Car " + junction.getSection(section) +
                " moved to [" + section + "]");
        // Add the current state of the road junction to the activity history
        activities.add(roadJunctionString());
    } // End addMovedTo

    public void addEntry(int section, String direction) {
        // Add an activity message to the activity history
        activities.add("Car " + junction.getSection(section) + " has entered at section ["
                + section + "] with the intention of going " + direction);
        // Add the current state of the road junction to the activity history
        activities.add(roadJunctionString());
    } // End addEntry

    public void addExit(String name) {
        // Add an activity message to the activity history
        activities.add("Car [" + name + "] has left the junction");

        // Add the current state of the road junction to the activity history
        activities.add(roadJunctionString());
    } // End addExit

    public void addMessage(String message) {
        // Add an activity message to the activity history
        activities.add(message);
    } // End addMessage

    public void printActivities() {
        // Print all the road junction activity
        System.out.println("ROAD JUNCTION ACTIVITY");
        System.out.println("--- ------------ ---");

        for (String activity : activities) {
            System.out.println(activity);
        } // End for
    } // End printActivities

    private String roadJunctionString() {
        return junction.toString();
    } // End roadJunctionString
} // End Activity
