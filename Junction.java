public class Junction {
    // The sections on the junction
    private String[] sections;
    // Semaphores for the individual sections
    private MageeSemaphore[] semaphore;
    // The number of cars that can be on the central box
    private MageeSemaphore numCarsOnJunction;

    public Junction() {
        // Instantiate junction
        sections = new String[12];
        semaphore = new MageeSemaphore[sections.length];

        for(int i = 0; i < semaphore.length; i++) {
            sections[i] = "[..]";
            semaphore[i] = new MageeSemaphore(1);
        }

        numCarsOnJunction = new MageeSemaphore(3);
    } // End constructor

    // Returns the specified junctions section
    public String getSection(int i) {
        return sections[i];
    } // End getSection

    // Performs a P operation on the specified section
    public void acquireSection(int i) {
        semaphore[i].acquire();
    } // End acquireSection

    // Performs a V operation on the specified section
    public void releaseSection(int i) {
        semaphore[i].release();
    } // end releaseSection

    // Performs a P operation on the central box
    public void acquireCentralBox() {
        numCarsOnJunction.acquire();
    } // end acquireCentralBox

    // Performs a V operation on the central box
    public void releaseCentralBox() {
        numCarsOnJunction.release();
    } // end releaseCentralBox

    // Places a car on the junction
    public void enter(String name, int i) {
        sections[i] = "[" + name + "]";
    } // end enter

    // Moves a car on the junction
    public void moveCar(int from, int to) {
        sections[to] = sections[from];
        sections[from] = "[..]";
    } // end moveCar

    // Removes a car from the junction
    public void exit(int i) {
        sections[i] = "[..]";
    } // end exit

    // Gets the number of sections on the junction
    public int numberOfSections() {
        return sections.length;
    } // end numberOfSections

    // Gets a string representation of the junction in its current state
    @Override
    public String toString() {
        return "    " + sections[9] + sections[10] + '\n' +
                sections[0] + sections[1] + sections[2] + sections[3] + '\n' +
                sections[7] + sections[6] + sections[5] + sections[4] + '\n' +
                "    " + sections[8] + sections[11] + '\n';
    } // end toString
} // End Junction
