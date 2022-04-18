package baseball.controller;

import java.util.ArrayList;
import java.util.List;

public class InputFilter {

    public List<Integer> toNumberList(String userInput) {
        ArrayList<Integer> result = new ArrayList<>();
        String[] numberCharArray = userInput.split("");

        for (String numberChar : numberCharArray) {
            result.add(Integer.parseInt(numberChar));
        }

        return result;
    }

    public boolean isRestart(String restartInput) {
        if (restartInput.equals("1")) {
            return true;
        }

        if (restartInput.equals("2")) {
            return false;
        }

        throw new IllegalArgumentException("ERROR: 올바른 숫자를 입력해주세요.");
    }
}
