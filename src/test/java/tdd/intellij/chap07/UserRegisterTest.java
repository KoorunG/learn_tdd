package tdd.intellij.chap07;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import tdd.intellij.chap07.code.*;
import tdd.intellij.chap07.exception.DupIdException;
import tdd.intellij.chap07.exception.WeakPasswordException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserRegisterTest {

    private UserRegister userRegister;
    private final StubPasswordChecker stubPasswordChecker = new StubPasswordChecker();
    private final MemoryUserRepository fakeRepository = new MemoryUserRepository();
    private final SpyEmailNotifier spyNotifier = new SpyEmailNotifier();

    @BeforeEach
    void setUp(){
        userRegister = new UserRegister(stubPasswordChecker, fakeRepository, spyNotifier);
    }

    @Test
    @DisplayName("약한 암호면 가입을 실패함")
    void weakPassword() {
        stubPasswordChecker.setWeak(true);                  // '암호가 약하다고 응답하도록' 설정

        assertThrows(WeakPasswordException.class, () -> {
            userRegister.register("id", "pw", "email@email.com");     // executable
        });
    }

    @Test
    @DisplayName("동일 ID를 가진 회원이 존재하면 가입을 실패함")
    void duplicatedUserExist() {
        fakeRepository.save(new User("id", "pw", "email@email.com"));

        assertThrows(DupIdException.class, () -> {
            userRegister.register("id", "pw", "email@email.com");
        });
    }

    @Test
    @DisplayName("중복되는 ID가 존재하지 않으면 가입 성공")
    void nonDuplicatedIdRegister() {
        User user1 = new User("id1");
        User user2 = new User("id2");

        fakeRepository.save(user1);
        fakeRepository.save(user2);

        User findUser = fakeRepository.findById("id2");
        assertThat(findUser).isEqualTo(user2);
    }

    @Test
    @DisplayName("회원가입에 성공하면 이메일로 회원가입 안내 메일 발송")
    void sendEmailIfRegisterSuccess(){

        // 등록을 성공하면
        userRegister.register("id","pw","email@test.com");

        assertThat(spyNotifier.isCalled()).isTrue();
        assertThat(spyNotifier.getEmail()).isEqualTo("email@test.com");

    }
}
