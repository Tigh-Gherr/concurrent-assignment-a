
import java.util.concurrent.Semaphore;

public class MageeSemaphore extends Semaphore {
    public MageeSemaphore(int i) {
        super(i);
    } // End constructor

    @Override
    public void acquire() {
        try { super.acquire(); }
        catch (InterruptedException ignored) {} // End try/catch
    } // End acquire
} // End MageeSemaphore
