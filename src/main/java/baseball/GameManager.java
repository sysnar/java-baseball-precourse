package baseball;

import baseball.controller.GameController;
import baseball.model.Baseball;
import baseball.model.GuessResult;
import baseball.model.RandomValue;
import baseball.view.GameView;

public class GameManager {

    private Baseball baseball;
    private GuessResult guessResult;
    private static final GameController controller = GameController.getController();

    public GameManager() {}

    public void init() {
        baseball = new Baseball(new RandomValue().create());
        guessResult = new GuessResult();

        while (guessResult.isPlaying()) {
            guessResult = controller.start(baseball);
        }

        win();
    }

    private void win() {
        try {
            GameView.MatchAll.println();
            restartOrNot();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            restartOrNot();
        }
    }

    private void restartOrNot() {
        if (controller.restart()) {
            init();
        }
    }
}
