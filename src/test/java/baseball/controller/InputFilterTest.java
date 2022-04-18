package baseball.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputFilterTest {

    private final InputFilter inputFilter = new InputFilter();

    @DisplayName("정상입력 테스트")
    @Test
    void normalInput() {
        assertThat(inputFilter.toNumberList("123")).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @DisplayName("입력값이 없는 경우 예외 발생")
    @Test
    void emptyInput() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> inputFilter.toNumberList(""));
        assertThat(thrown.getMessage()).isEqualTo("ERROR: 사용자 입력값이 존재하지 않습니다.");
    }

    @DisplayName("입력한 숫자 갯수가 3보다 적을 경우 예외 발생")
    @Test
    void sizeLackInput() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> inputFilter.toNumberList("12"));
        assertThat(thrown.getMessage()).isEqualTo("ERROR: 사용자는 반드시 3개의 숫자를 입력해야 합니다.");
    }

    @DisplayName("입력한 숫자 갯수가 3보다 많을 경우 예외 발생")
    @Test
    void sizeOverInput() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> inputFilter.toNumberList("12345"));
        assertThat(thrown.getMessage()).isEqualTo("ERROR: 사용자는 반드시 3개의 숫자를 입력해야 합니다.");
    }

    @DisplayName("입력값에 동일한 숫자가 있는 경우 예외 발생")
    @Test
    void duplicatedInput() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> inputFilter.toNumberList("112"));
        assertThat(thrown.getMessage()).isEqualTo("ERROR: 입력 숫자는 각각 다른 수여야 합니다.");
    }

    @DisplayName("입력한 숫자가 1 ~ 9 사이의 정수가 아닌 경우 예외 발생")
    @Test
    void outOfRangeInput() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> inputFilter.toNumberList("012"));
        assertThat(thrown.getMessage()).isEqualTo("ERROR: 사용자 입력값은 1 ~ 9 사이여야 합니다.");
    }

    @DisplayName("입력한 값이 숫자가 아닌 경우 예외 발생")
    @Test
    void characterInput() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> inputFilter.toNumberList("문자열")
        );
        assertThat(thrown.getMessage()).isEqualTo("ERROR: 사용자 입력값은 반드시 정수여야 합니다.");
    }

    @DisplayName("게임 재시작/종료 키워드가 아닌 경우 예외 발생")
    @Test
    void noneRestartInput() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> inputFilter.isRestart("9"));
        assertThat(thrown.getMessage()).isEqualTo("ERROR: 올바른 숫자를 입력해주세요.");
    }
}
