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
}
