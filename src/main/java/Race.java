import java.util.ArrayList;

public class Race {

    Car currentLeader;
    int durationHours = 24;

    public Car getLeader(Car car) {
        if (currentLeader == null) {
            currentLeader = car;
        } else if (durationHours * car.speed > durationHours * currentLeader.speed) {
            currentLeader = car;
        }
        return currentLeader;
    }
}

