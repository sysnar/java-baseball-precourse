package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class BaseballTest {

    @DisplayName("입력값이 스트라이크인 경우")
    @Test
    void guessStrike() {
        Baseball answer = new Baseball(Arrays.asList(1, 2, 3));
        GuessStatus result = answer.guessBall(new Ball(1, 1));

        assertThat(result).isEqualTo(GuessStatus.Strike);
    }

    @DisplayName("입력값이 볼인 경우")
    @Test
    void guessBall() {
        Baseball answer = new Baseball(Arrays.asList(1, 2, 3));
        GuessStatus result = answer.guessBall(new Ball(1, 3));

        assertThat(result).isEqualTo(GuessStatus.Ball);
    }

    @DisplayName("입력값이 아무것도 맞추지 못한 경우")
    @Test
    void guessNothing() {
        Baseball answer = new Baseball(Arrays.asList(1, 2, 3));
        GuessStatus result = answer.guessBall(new Ball(1, 9));

        assertThat(result).isEqualTo(GuessStatus.Nothing);
    }

    @DisplayName("낫싱 - 모든 숫자, 위치가 일치하지 않은 경우")
    @Test
    void nothing() {
        Baseball answer = new Baseball(Arrays.asList(1, 2, 3));
        GuessResult result = answer.guessBaseball(Arrays.asList(9, 8, 7));

        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @DisplayName("3스트라이크 - 모든 숫자, 위치가 일치한 경우")
    @Test
    void strike_three() {
        Baseball answer = new Baseball(Arrays.asList(1, 2, 3));
        GuessResult result = answer.guessBaseball(Arrays.asList(1, 2, 3));

        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @DisplayName("2스트라이크")
    @Test
    void strike_two() {
        Baseball answer = new Baseball(Arrays.asList(1, 2, 3));
        GuessResult result = answer.guessBaseball(Arrays.asList(1, 2, 9));

        assertThat(result.getStrike()).isEqualTo(2);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @DisplayName("1스트라이크 1볼")
    @Test
    void strike_one_ball_one() {
        Baseball answer = new Baseball(Arrays.asList(1, 2, 3));
        GuessResult result = answer.guessBaseball(Arrays.asList(1, 9, 2));

        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @DisplayName("3볼 - 모든 숫자가 일치하고 위치가 다른 경우")
    @Test
    void ball_three() {
        Baseball answer = new Baseball(Arrays.asList(1, 2, 3));
        GuessResult result = answer.guessBaseball(Arrays.asList(3, 1, 2));

        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(3);
    }
}