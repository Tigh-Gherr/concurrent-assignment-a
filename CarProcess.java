public abstract class CarProcess extends Thread {
    private String name;
    private Activity activities;
    private Direction direction;
    private Junction junction;

    private static MageeSemaphore activitySemaphore = new MageeSemaphore(1);

    public CarProcess(String name, Junction junction, Activity activities) {
        // Instantiate object
        this.name = name;
        this.activities = activities;
        this.junction = junction;

        // Select random direction
        this.direction = Direction.randomDirection();
    } // End CarProcess

    @Override
    public void run() {
        // Decide action sequence based on direction
        switch (direction) {
            case LEFT:
                navigate(getLeftPath());
                break;
            case FORWARD:
                navigate(getForwardPath());
                break;
            case RIGHT:
                navigate(getRightPath());
                break;
            default:
                System.out.println("Invalid Direction.");
        } // End switch
    } // End run

    /*     Used for plotting car paths      */
    protected abstract int[] getLeftPath();
    protected abstract int[] getForwardPath();
    protected abstract int[] getRightPath();

    // Navigates a car across its path
    private void navigate(int[] path) {
        // Enter the junction
        enter(path[0]);
        for (int i = 1; i < path.length; i++) {
            // Move across each pair of sections
            moveSection(path[i - 1], path[i]);
            try { Thread.sleep((long) (Math.random() * 10)); }
            catch (InterruptedException ignored) {}
        } // End for
        // Exit the junction
        exit(path[path.length - 1]);
    } // End navigate

    // Car enters the junction
    private void enter(int section) {
        // Wait until the entry location is free
        junction.acquireSection(section);
        activitySemaphore.acquire();
        // Create section name
        junction.enter(name, section);
        activities.addMessage("Car " + name + " is approaching slot " + section);
        activities.addEntry(section, direction.toString());
        // Wait until a spot on the central junction is free
        activitySemaphore.release();
        junction.acquireCentralBox();
    } // End enter

    // Car moves from one section to another
    private void moveSection(int from, int to) {
        // Wait until the desired section is free
        junction.acquireSection(to);
        activitySemaphore.acquire();

        // Move to the desired section
        activities.addMessage("Car " + name + " is approaching slot " + to);
        junction.moveCar(from, to);
        activities.addMovedTo(to);

        // Release previous section
        activitySemaphore.release();
        junction.releaseSection(from);
    } // End moveSection

    // Car exits the junction
    private void exit(int section) {
        // Free up a central junction slot
        junction.releaseCentralBox();
        activitySemaphore.acquire();

        // Clear the occupied section
        junction.exit(section);
        activities.addMessage("Car " + name + " is leaving the junction");
        activities.addExit(name);
        activitySemaphore.release();

        // Release the occupied section
        junction.releaseSection(section);
    } // End exit
} // CarProcess
