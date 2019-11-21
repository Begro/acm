package liu.yan.jvm;

import java.util.concurrent.TimeUnit;
import java.util.function.LongConsumer;

public class StopTime extends Thread {

    private static boolean allocateObjects = true;
    public volatile Long lastSleepTimeObj; // public volatile to make sure allocs are not optimized away

    private LongConsumer callback;
    private int resolutionMs;

    private volatile boolean doRun = true;

    public StopTime(LongConsumer callback) {
        this(callback, 10);
    }

    public StopTime(LongConsumer callback, int resolutionMs) {
        super("jvm-hiccup-metter-thread");
        this.callback = callback;
        this.resolutionMs = resolutionMs;
        setDaemon(true);
    }

    @Override
    public void run() {
        final long resolutionNsec = (long)(resolutionMs * 1000L * 1000L);
        try {
            long shortestObservedDeltaTimeNsec = Long.MAX_VALUE;
            long timeBeforeMeasurement = Long.MAX_VALUE;
            while (doRun) {
                TimeUnit.NANOSECONDS.sleep(resolutionNsec);
                if (allocateObjects) {
                    // Allocate an object to make sure potential allocation stalls are measured.
                    lastSleepTimeObj = new Long(timeBeforeMeasurement);
                }
                final long timeAfterMeasurement = System.nanoTime();
                final long deltaTimeNsec = timeAfterMeasurement - timeBeforeMeasurement;
                timeBeforeMeasurement = timeAfterMeasurement;

                if (deltaTimeNsec < 0) {
                    // On the very first iteration (which will not time the loop in it's entirety)
                    // the delta will be negative, and we'll skip recording.
                    continue;
                }

                if (deltaTimeNsec < shortestObservedDeltaTimeNsec) {
                    shortestObservedDeltaTimeNsec = deltaTimeNsec;
                }

                long hiccupTimeNsec = deltaTimeNsec - shortestObservedDeltaTimeNsec;

                callback.accept(hiccupTimeNsec);
            }
        } catch (InterruptedException e) {
            System.err.println("MeterThread terminating...");
        }
    }

    public void terminate() {
        doRun = false;
    }
}