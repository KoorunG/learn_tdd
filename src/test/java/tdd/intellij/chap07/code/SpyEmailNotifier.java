package tdd.intellij.chap07.code;

public class SpyEmailNotifier implements EmailNotifier {

    private boolean called = false;
    private String email;

    public boolean isCalled() {
        return called;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void sendRegisterEmail(String email) {
        this.email = email;
        this.called = true;     // called 여부를 설정한다.
    }
}
