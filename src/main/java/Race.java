import java.util.ArrayList;

public class Race {

    private Car currentLeader;
    private final int durationHours = 24;
    public static final int minimumSpeed = 0;
    public static final int maximumSpeed = 250;

    public Car evaluateLeader(Car car) {
        if (currentLeader == null) {
            currentLeader = car;
        } else if (durationHours * car.speed > durationHours * currentLeader.speed) {
            currentLeader = car;
        }
        return currentLeader;
    }
}

