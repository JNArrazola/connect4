package connect4;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

public class Chronometer implements Serializable {
    private int seconds = 0;
    private transient Timer timer;

    public Chronometer() {
        timer = new Timer();
    }

    public void start() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                seconds++;
            }
        }, 1000, 1000); 
    }

    public void stop() {
        timer.cancel();
    }

    public String toString() {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int residualSecs = seconds % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, residualSecs);   
    }
}
