package baseball.controller;

import java.util.ArrayList;
import java.util.List;

public class InputFilter {

    public List<Integer> toNumberList(String userInput) {
        return stringToNumberList(validate(userInput));
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

    private ArrayList<Integer> stringToNumberList(String userInput) {
        ArrayList<Integer> result = new ArrayList<>();
        String[] numberCharArray = userInput.split("");

        for (String numberChar : numberCharArray) {
            result.add(Integer.parseInt(numberChar));
        }

        return result;
    }

    private String validate(String input) {
        validateEmpty(input);
        validateOutOfBound(input);
        validateCharacter(input);
        validateEqualNumber(input);
        validateRange(input);

        return input;
    }

    private void validateEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("ERROR: 사용자 입력값이 존재하지 않습니다.");
        }
    }

    private void validateOutOfBound(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("ERROR: 사용자는 반드시 3개의 숫자를 입력해야 합니다.");
        }
    }

    private void validateCharacter(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("ERROR: 사용자 입력값은 반드시 정수여야 합니다.");
        }
    }

    private void validateEqualNumber(String input) {
        List<Integer> list = stringToNumberList(input);
        if (list.get(0) == list.get(1) || list.get(0) == list.get(2) || list.get(1) == list.get(2)) {
            throw new IllegalArgumentException("ERROR: 입력 숫자는 각각 다른 수여야 합니다.");
        }
    }

    private void validateRange(String input) {
        for (Integer value : stringToNumberList(input)) {
            suitRange(value);
        }
    }

    private void suitRange(int value) {
        if (value > 9 || value <= 0) {
            throw new IllegalArgumentException("ERROR: 사용자 입력값은 1 ~ 9 사이여야 합니다.");
        }
    }
}
