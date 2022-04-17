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
}