package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public enum GameView {

    NumberGuess("숫자를 입력해주세요 : "),
    MatchAll("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RestartOrEnd("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");

    private final String viewLine;

    GameView(String viewLine) {
        this.viewLine = viewLine;
    }

    public void println() {
        System.out.println(viewLine);
    }

    public String printAndRad() {
        System.out.print(viewLine);
        return Console.readLine();
    }

    public String printlnAndRead() {
        System.out.println(viewLine);
        return Console.readLine();
    }

    public static void showGuessResult(String result) {
        System.out.println(result);
    }
}
