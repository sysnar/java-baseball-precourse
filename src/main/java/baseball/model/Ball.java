package baseball.model;

public class Ball {

    private final int position;
    private final int value;

    public Ball(int position, int value) {
        this.position = position;
        this.value = value;
    }

    public boolean isValid() {
        return value >= Baseball.MIN_BALL_RANGE && value <= Baseball.MAX_BALL_RANGE;
    }
}
