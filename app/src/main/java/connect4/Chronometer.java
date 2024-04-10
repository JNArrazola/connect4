package connect4;

import java.io.Serializable;

public class Chronometer implements Serializable {
    private long startTime;
    private long totalTime = 0;

    public void start(){
        startTime = System.currentTimeMillis();
    }

    public void stop() {
        totalTime+= System.currentTimeMillis() - startTime;
    }

    public long getCurrentTime() {
        return totalTime;
    }

    @Override
    public String toString() {
        long time = getCurrentTime();
        long seconds = time / 1000;
        long miliseconds = time % 1000;
        long minutes = seconds / 60;
        seconds %= 60;
        return String.format("%02d:%02d:%03d", minutes, seconds, miliseconds);
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getStartTime() {
        return startTime;
    }
}
