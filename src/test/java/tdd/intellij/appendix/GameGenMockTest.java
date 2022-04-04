package tdd.intellij.appendix;


import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

/**
 * Mockito 라이브러리 테스트
 */
public class GameGenMockTest {

    @Test
    void mockTest() {
        GameNumGen genMock = mock(GameNumGen.class);
        // Mockito.mock() => 클래스, 인터페이스, 추상클래스에 대해 모의 객체를 생성할 수 있음
        BDDMockito.given(genMock.generate(GameLevel.BEGINNER)).willReturn("123");
        // BDDMockito.given() : 스텁을 정의할 모의 객체의 메소드 호출을 전달
        // .willReturn() : 스텁을 정의한 메소드가 리턴할 값을 지정

        String num = genMock.generate(GameLevel.BEGINNER);
        assertThat("123").isEqualTo(num);
    }

    @Test
    void mockThrowTest() {
        GameNumGen genMock = mock(GameNumGen.class);
        BDDMockito.given(genMock.generate(null)).willThrow(IllegalArgumentException.class);

        assertThrows(IllegalArgumentException.class, () -> {
            genMock.generate(null);
        });
    }
}
