package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public enum GameView {

    NumberGuess("숫자를 입력해주세요 : ");

    private final String viewLine;

    GameView(String viewLine) {
        this.viewLine = viewLine;
    }

    public String showGuessInput() {
        System.out.print(viewLine);
        return Console.readLine();
    }

    public static void showGuessResult(String result) {
        System.out.println(result);
    }
}
