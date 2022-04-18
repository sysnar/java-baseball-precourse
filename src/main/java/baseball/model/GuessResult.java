package baseball.model;

public class GuessResult {

    private int strike = 0;
    private int ball = 0;

    public void update(GuessStatus status) {
        if (status.isStrike())
            strike++;
        if (status.isBall())
            ball++;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
