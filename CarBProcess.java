
public class CarBProcess extends CarProcess {
    public CarBProcess(int i, Junction junction, Activity activity) {
        super("B" + i, junction, activity);
    } // End constructor

    @Override
    protected int[] getLeftPath() {
        return new int[]{0, 1, 9};
    } // End getLeftPath

    @Override
    protected int[] getForwardPath() {
        return new int[]{0, 1, 2, 3};
    } // End getForwardPath

    @Override
    protected int[] getRightPath() {
        return new int[]{0, 1, 2, 5, 11};
    } // End getRightPath
} // End CarBProcess
