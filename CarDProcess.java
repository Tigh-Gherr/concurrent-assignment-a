
public class CarDProcess extends CarProcess {
    public CarDProcess(int i, Junction junction, Activity activity) {
        super("D" + i, junction, activity);
    } // End constructor

    @Override
    protected int[] getLeftPath() {
        return new int[]{4, 5, 11};
    } // End getLeftPath

    @Override
    protected int[] getForwardPath() {
        return new int[]{4, 5, 6, 7};
    } // End getForwardPath

    @Override
    protected int[] getRightPath() {
        return new int[]{4, 5, 6, 1, 9};
    } // End getRightPath
} // End CarDProcess
