
public class CarCProcess extends CarProcess {
    public CarCProcess(int i, Junction junction, Activity activities) {
        super("C" + i, junction, activities);
    } // End constructor

    @Override
    protected int[] getLeftPath() {
        return new int[]{10, 2, 3};
    } // End getLeftPath

    @Override
    protected int[] getForwardPath() {
        return new int[]{10, 2, 5, 11};
    } // End getForwardPath

    @Override
    protected int[] getRightPath() {
        return new int[]{10, 2, 5, 6, 7};
    } // End getRightPath
} // End CarCProcess
