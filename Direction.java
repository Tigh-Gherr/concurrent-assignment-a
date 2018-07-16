
import java.util.Random;

// Directions which a car can take.
public enum Direction {
    LEFT,
    FORWARD,
    RIGHT;

    // Generate a random direction
    public static Direction randomDirection() {
        return values()[new Random().nextInt(values().length)];
    } // End randomDirection
} // End Direction
