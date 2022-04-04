package tdd.intellij.chap07.code;

public class VirtualEmailNotifier implements EmailNotifier {

    @Override
    public void sendRegisterEmail(String email) {
        System.out.println("email : " + email);
    }
}
