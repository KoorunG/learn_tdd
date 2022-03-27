package tdd.intellij.chap02;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tdd.intellij.chap02.code.PasswordStrength;
import tdd.intellij.chap02.code.PasswordStrengthMeter;

import static org.assertj.core.api.Assertions.*;
import static tdd.intellij.chap02.code.PasswordStrength.*;

public class PasswordStrengthMeterTest {

    /**
     * 조건
     * 1. 길이가 8글자 이상
     * 2. 0부터 9 사이의 숫자를 포함
     * 3. 대문자 포함
     * => 조건을 모두 만족하면 '강함', 2개를 만족하면 '보통', 1개 이하를 만족하면 '약함'
     */

    // 암호검사기 객체 선언
    PasswordStrengthMeter meter = new PasswordStrengthMeter();

    @Test
    @DisplayName("모든 조건을 만족하면 강도 : 강함")
    void meetsAllCriteria_Then_Strong(){
        validatePassword("ab12!@AB", STRONG);
        validatePassword("abc1!Add", STRONG);
    }

    @Test
    @DisplayName("길이만 8글자 미만이고 나머지 모든 조건을 충족")
    void meetsAllCriteria_except_for_Length_Then_Normal() {
        validatePassword("ab12!A", NORMAL);
    }

    @Test
    @DisplayName("숫자를 포함하지 않고 나머지 모든 조건을 충족")
    void meetsAllCriteria_except_for_Number_Then_Normal() {
        validatePassword("abcd!ABC", NORMAL);
    }

    @Test
    @DisplayName("null이 입력된 경우")
    void meetsAllCriteria_args_null_Then_Invalid() {
        validatePassword(null, INVALID);    // 부적절한 값이 입력될 경우 INVALID를 리턴하도록
    }

    @Test
    @DisplayName("빈 값이 입력된 경우")
    void meetsAllCriteria_args_empty_Then_Invalid() {
        validatePassword("", INVALID);
    }

    @Test
    @DisplayName("대문자를 포함하지 않고 나머지 조건을 충족하는 경우")
    void meetsAllCriteria_except_for_Uppercase_Then_Normal() {
        validatePassword("ab123cccdf", NORMAL);
    }

    @Test
    @DisplayName("길이가 8글자 이상인 조건만 충족하는 경우")
    void meetsOnlyLengthCriteria_Then_Weak() {
        validatePassword("asdasdddd", WEAK);
    }

    @Test
    @DisplayName("숫자 포함 조건만 충족하는 경우")
    void meetsOnlyNumberCriteria_Then_Weak() {
        validatePassword("12312", WEAK);
    }

    @Test
    @DisplayName("대문자 포함 조건만 만족하는 경우")
    void meetsOnlyUpperCriteria_Then_Weak() {
        validatePassword("ABSDFF", WEAK);
    }

    @Test
    @DisplayName("아무 조건도 만족하지 않는 경우")
    void meetsNoCriteria_Then_Weak() {
        validatePassword("abc", WEAK);
    }

    // 검증메소드
    private void validatePassword(String password, PasswordStrength passwordStrength) {
        PasswordStrength result = meter.meter(password);
        assertThat(result).isEqualTo(passwordStrength);
    }
}
