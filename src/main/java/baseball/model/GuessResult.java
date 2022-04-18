package baseball.model;

public class GuessResult {

    private int strike = 0;
    private int ball = 0;

    public GuessResult() {}

    public boolean isPlaying() {
        return strike != 3;
    }

    public void update(GuessStatus status) {
        if (status.isStrike())
            strike++;
        if (status.isBall())
            ball++;
    }

    public String result() {
        if (hasStrikeAndBall()) {
            return ball + "볼 " + strike + "스트라이크";
        }

        return hasStrikeBallNothing();
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    private String hasStrikeBallNothing() {
        if (isNothing()) {
            return "낫싱";
        }

        if (isBallEmpty()) {
            return strike + "스트라이크";
        }

        return ball + "볼";
    }

    private boolean hasStrikeAndBall() {
        return ball > 0 && strike > 0;
    }

    private boolean isNothing() {
        return ball == 0 && strike == 0;
    }

    private boolean isBallEmpty() {
        return ball == 0;
    }
}
