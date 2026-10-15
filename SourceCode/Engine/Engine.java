package SourceCode.Spawner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.LockSupport;

public class Engine {
    private final RoadNetwork network;
    private final List<Spawner> spawners;
    private final long runSeed;
    private boolean running = false;
    private boolean paused = false;
    private long tickCount = 0;
    private int tickRate = 60;

    public Engine(RoadNetwork network, List<Spawner> spawners, long runSeed) {
        this.network = network;
        this.spawners = spawners;
        this.runSeed = runSeed;
    }

    public void step() {
        if (!paused) {
            for (Spawner spawner : spawners) {
                spawner.step();
            }
            network.step();
            tickCount++;
        }
    }

    public void setTickRate(int tickRate) { this.tickRate = tickRate; }
    public int getTickRate() { return tickRate; }

public void run() {
        running = true;
        Thread t = new Thread(() -> {
            long nextTick = System.nanoTime();
            while (running) {
                // Convert updates per second into the time budget for one simulation tick.
                long tickNanos = 1_000_000_000L / Math.max(1, tickRate);
                step();
                nextTick += tickNanos;
                // Sleep only for the remaining budget; reset if a tick already ran late.
                long waitNanos = nextTick - System.nanoTime();
                if (waitNanos > 0) LockSupport.parkNanos(waitNanos);
                else nextTick = System.nanoTime();
            }
        }, "sim-loop");
        t.setDaemon(true);
        t.start();
    }

    public void shutdown() {
        running = false;
    }

    public void setPaused(boolean paused) { this.paused = paused; }
    public boolean isPaused() { return paused; }
    public long getTickCount() { return tickCount; }
    public long getRunSeed() { return runSeed; }
    public RoadNetwork getNetwork() { return network; }
}