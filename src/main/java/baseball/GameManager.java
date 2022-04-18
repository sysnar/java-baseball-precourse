package baseball;

import baseball.controller.GameController;
import baseball.model.Baseball;
import baseball.model.GuessResult;
import baseball.model.RandomValue;

public class GameManager {

    private Baseball baseball;
    private static final GuessResult guessResult = GuessResult.getGuessResult();
    private static final GameController controller = GameController.getController();

    public GameManager() {}

    public void init() {
        baseball = new Baseball(new RandomValue().create());
        controller.start(baseball);
    }
}
