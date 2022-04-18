package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomValue {

    private List<Integer> randomValues;

    public RandomValue() {
        this.randomValues = new ArrayList<>();
    }

    public List<Integer> create() {
        for (int i = 0; i < Baseball.BALL_SIZE; i++) {
            randomValues.add(random());
        }
        return randomValues;
    }

    private Integer random() {
        int result = Randoms.pickNumberInRange(1, 9);

        if (randomValues.contains(result)) {
            return random();
        }

        return result;
    }
}
