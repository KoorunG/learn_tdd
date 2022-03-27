package tdd.intellij.chap02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    @DisplayName("계산기의 더하기 연산 검증")
    void plus() {
        int result = Calculator.plus(1,2);
        assertThat(result).isEqualTo(3);

        assertThat(Calculator.plus(4,1)).isEqualTo(5);
    }
}
