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

    public GuessStatus guess(Ball ball) {
        if (this.isStrike(ball)) {
            return GuessStatus.Strike;
        }

        if (ball.isBall(value)) {
            return GuessStatus.Ball;
        }

        return GuessStatus.Nothing;
    }

    private boolean isStrike(Object object) {
        Ball ball = (Ball) object;
        return position == ball.getPosition() &&
                value == ball.getValue();
    }

    private boolean isBall(int guessValue) {
        return value == guessValue;
    }

    public int getPosition() {
        return position;
    }

    public int getValue() {
        return value;
    }
}
