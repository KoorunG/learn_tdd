package tdd.intellij.chap07.code;

import org.springframework.stereotype.Component;

@Component
public class VirtualEmailNotifier implements EmailNotifier {

    @Override
    public void sendRegisterEmail(String email) {
        System.out.println("email : " + email);
    }
}
