package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallTest {

    @DisplayName("1 ~ 9 사이의 숫자 생성 테스트")
    @Test
    void ballCreationTest() {
        Ball normalBall = new Ball(1, 9);
        assertThat(normalBall.isValid()).isTrue();

        Ball bigBall = new Ball(1, 10);
        assertThat(bigBall.isValid()).isFalse();

        Ball smallBall = new Ball(1, 0);
        assertThat(smallBall.isValid()).isFalse();
    }

    @DisplayName("스트라이크 테스트")
    @Test
    void strike_test() {
        Ball answer = new Ball(1, 9);
        GuessStatus result = answer.guess(new Ball(1, 9));

        assertThat(result).isEqualTo(GuessStatus.Strike);
    }

    @DisplayName("볼 테스트")
    @Test
    void ball_test() {
        Ball answer = new Ball(1, 9);
        GuessStatus result = answer.guess(new Ball(2, 9));

        assertThat(result).isEqualTo(GuessStatus.Ball);
    }

    @DisplayName("낫싱 테스트")
    @Test
    void nothing_test() {
        Ball answer = new Ball(1, 9);
        GuessStatus result = answer.guess(new Ball(1, 1));

        assertThat(result).isEqualTo(GuessStatus.Nothing);
    }
}