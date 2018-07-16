public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("STARTED");

        // You can assume that cars approaching the junction will adhere
        // to normal highway protocol.

        // Number of cars for each process to spawn
        final int NUM_CARS = 10;

        // Junction which that cars drive on
        Junction junction = new Junction();

        // Junction to drive on
        Activity activities = new Activity(junction);

        // Create arrays to hold each car
        CarProcess[] carAProcesses = new CarProcess[NUM_CARS];
        CarProcess[] carBProcesses = new CarProcess[NUM_CARS];
        CarProcess[] carCProcesses = new CarProcess[NUM_CARS];
        CarProcess[] carDProcesses = new CarProcess[NUM_CARS];

        // Initialise arrays and start threads
        for(int i = 0; i < NUM_CARS; i++) {
            carAProcesses[i] = new CarAProcess(i, junction, activities);
            carAProcesses[i].start();

            carBProcesses[i] = new CarBProcess(i, junction, activities);
            carBProcesses[i].start();

            carCProcesses[i] = new CarCProcess(i, junction, activities);
            carCProcesses[i].start();

            carDProcesses[i] = new CarDProcess(i, junction, activities);
            carDProcesses[i].start();

        } // End for

        /*** CARS ARE NOW TRAVELLING ***/

        // Wait for all cars to finish navigating before printing out the final message
        for(int i = 0; i < NUM_CARS; i++) {
            carAProcesses[i].join();
            carBProcesses[i].join();
            carCProcesses[i].join();
            carDProcesses[i].join();
        } // End for

        // Print the driving activities
        activities.printActivities();

        // Final message
        System.out.println("All cars have successfully navigated the junction.");
    } // end main
} // End Main
