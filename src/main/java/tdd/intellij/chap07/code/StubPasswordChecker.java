package tdd.intellij.chap07.code;

public class StubPasswordChecker implements WeakPasswordChecker {

    private boolean weak;

    public void setWeak(boolean weak) {
        this.weak = weak;
    }

    @Override
    public boolean checkPasswordWeak(String pw) {
        return weak;
    }
}
