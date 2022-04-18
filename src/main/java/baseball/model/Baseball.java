package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Baseball {

    public static final int MAX_BALL_RANGE = 9;
    public static final int MIN_BALL_RANGE = 1;
    public static final int BALL_SIZE = 3;

    private final List<Ball> ballList;

    public Baseball(List<Integer> randomValues) {
        this.ballList = generateBaseball(randomValues);
    }

    private ArrayList<Ball> generateBaseball(List<Integer> randomValues) {
        ArrayList<Ball> ballList = new ArrayList<>();

        for (int i = 0; i < BALL_SIZE; i++) {
            ballList.add(new Ball(i + 1, randomValues.get(i)));
        }

        return ballList;
    }

    public GuessResult guessBaseball(List<Integer> userGuess) {
        Baseball userBalls = new Baseball(userGuess);
        GuessResult result = GuessResult.getGuessResult();

        for (Ball ball : ballList) {
            GuessStatus status = userBalls.guessBall(ball);
            result.update(status);
        }

        return result;
    }

    public GuessStatus guessBall(Ball ball) {
        int statusCode = 0;

        for (int i = 0; i < BALL_SIZE; i++) {
            statusCode += ballList.get(i).guess(ball).getResult();
        }

        return getGuessStatus(statusCode);
    }

    private GuessStatus getGuessStatus(int statusCode) {
        if (statusCode == GuessStatus.Nothing.getResult()) {
            return GuessStatus.Nothing;
        }

        if (statusCode == GuessStatus.Ball.getResult()) {
            return GuessStatus.Ball;
        }

        return GuessStatus.Strike;
    }
}
