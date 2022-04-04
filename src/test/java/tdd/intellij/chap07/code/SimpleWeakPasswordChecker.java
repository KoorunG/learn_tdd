package tdd.intellij.chap07.code;

public class SimpleWeakPasswordChecker implements WeakPasswordChecker {

    @Override
    public boolean checkPasswordWeak(String pw) {
        return pw.length() < 5;
    }
}
