package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RandomValueTest {

    @DisplayName("생성 랜덤번호 사이즈 테스트")
    @Test
    void randomValueSize() {
        RandomValue randomValue = new RandomValue();
        List<Integer> values = randomValue.create();

        assertThat(values.size()).isEqualTo(Baseball.BALL_SIZE);
    }

    @DisplayName("생성 랜덤번호 중복여부 테스트")
    @RepeatedTest(100)
    void randomValueUnique() {
        RandomValue randomValue = new RandomValue();
        List<Integer> values = randomValue.create();

        boolean isDifferent =
                values.get(0) != values.get(1) &&
                values.get(0) != values.get(2) &&
                values.get(1) != values.get(2);

        assertThat(isDifferent).isTrue();
    }
}