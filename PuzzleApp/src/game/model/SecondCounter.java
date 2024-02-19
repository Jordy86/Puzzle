package game.model;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static main.Main.label;

public class SecondCounter {
    private int seconds = 0;
    private ScheduledExecutorService scheduler;

    public SecondCounter() {
        scheduler = Executors.newSingleThreadScheduledExecutor();
    }

    public void start() {
        if (seconds == 0) {
            scheduler = Executors.newSingleThreadScheduledExecutor();
            scheduler.scheduleAtFixedRate(() -> {
                seconds++;
                label.setText(secondsToTime());
            }, 0, 1, TimeUnit.SECONDS);
        }
    }

    public void stop() {
        scheduler.shutdown();
    }

    public int getSeconds() {
        return seconds;
    }

    public String secondsToTime() {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int remainingSeconds = seconds % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, remainingSeconds);
    }

    public static String secondsToTime(int seconds) {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int remainingSeconds = seconds % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, remainingSeconds);
    }
}
