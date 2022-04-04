package tdd.intellij.chap07.code;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tdd.intellij.chap07.exception.DupIdException;
import tdd.intellij.chap07.exception.WeakPasswordException;

@Component
@RequiredArgsConstructor
public class UserRegister {

    private final WeakPasswordChecker passwordChecker;
//    private final UserRepository userRepository;
    private final UserJPARepository repository;
    private final EmailNotifier emailNotifier;

//    public UserRegister(WeakPasswordChecker passwordChecker, UserRepository userRepository, EmailNotifier emailNotifier) {
//        this.passwordChecker = passwordChecker;
//        this.userRepository = userRepository;
//        this.emailNotifier = emailNotifier;
//    }

    public void register(Long id, String pw, String email) {

        if(passwordChecker.checkPasswordWeak(pw)) throw new WeakPasswordException();

        User user = repository.findById(id).orElse(null);        // repository에서 id(key) 로 객체를 검색하여
        if(user != null) throw new DupIdException();    // null이 아니면 예외 발생

        repository.save(new User(id, pw, email));

        emailNotifier.sendRegisterEmail(email);
    }
}
