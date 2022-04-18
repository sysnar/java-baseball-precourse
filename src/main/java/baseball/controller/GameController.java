package baseball.controller;

import baseball.model.Baseball;
import baseball.model.GuessResult;
import baseball.view.GameView;

import java.util.List;

public class GameController {

    private final static GameController controller = new GameController();
    private final InputFilter inputFilter = new InputFilter();

    private GameController() {
    }

    public static GameController getController() {
        return controller;
    }

    public void start(Baseball baseball) {
        String userGuess = GameView.NumberGuess.showGuessInput();
        List<Integer> numberList = inputFilter.toNumberList(userGuess);
        GuessResult guessResult = baseball.guessBaseball(numberList);

        GameView.showGuessResult(guessResult.result());
    }
}
