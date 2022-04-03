package tdd.intellij.chap07.code;

/**
 * EmailNotifier : 회원가입에 성공하면 메일발송
 *
 * 1. 메일 발송 여부와 가입된 유저에게 메일을 보냈는지를 확인하기 위하여 스파이 대역 사용
 * 2. EmailNotifier 인터페이스 사용, 구현체로 SpyEmailNotifier 사용
 * 3. 발송여부 : called, 발송된 이메일 : email로 필드를 지정하며
 *    메일을 발송 했을 시(sendRegisterEmail) called = true 로 설정한다.
 */
public interface EmailNotifier {

    void sendRegisterEmail(String email);
}
