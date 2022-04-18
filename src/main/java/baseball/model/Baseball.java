package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

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
}
