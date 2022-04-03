package tdd.intellij.chap07.code;

import tdd.intellij.chap07.exception.DupIdException;
import tdd.intellij.chap07.exception.WeakPasswordException;

public class UserRegister {

    private WeakPasswordChecker passwordChecker;
    private UserRepository userRepository;
    private EmailNotifier emailNotifier;

    public UserRegister(WeakPasswordChecker passwordChecker, UserRepository userRepository, EmailNotifier emailNotifier) {
        this.passwordChecker = passwordChecker;
        this.userRepository = userRepository;
        this.emailNotifier = emailNotifier;
    }

    public void register(String id, String pw, String email) {

        if(passwordChecker.checkPasswordWeak(pw)) throw new WeakPasswordException();

        User user = userRepository.findById(id);        // repository에서 id(key) 로 객체를 검색하여
        if(user != null) throw new DupIdException();    // null이 아니면 예외 발생

        userRepository.save(new User(id, pw, email));

        emailNotifier.sendRegisterEmail(email);
    }
}
