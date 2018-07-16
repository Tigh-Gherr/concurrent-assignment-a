public class CarAProcess extends CarProcess {
    public CarAProcess(int number, Junction junction, Activity activity) {
        super("A" + number, junction, activity);
    } // End constructor

    @Override
    protected int[] getLeftPath() {
        return new int[]{8, 6, 7};
    } // End getLeftPath

    @Override
    protected int[] getForwardPath() {
        return new int[]{8, 6, 1, 9};
    } // End getForwardPath

    @Override
    protected int[] getRightPath() {
        return new int[]{8, 6, 1, 2, 3};
    } // End getRightPath
} // End CarAProcess
