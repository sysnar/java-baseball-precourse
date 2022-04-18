package baseball.model;

public enum GuessStatus {
    Nothing(0),
    Ball(1),
    Strike(2);

    private final int result;

    GuessStatus(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    public boolean isStrike() {
        return this == Strike;
    }

    public boolean isBall() {
        return this == Ball;
    }
}
