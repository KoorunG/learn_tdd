package tdd.intellij.chap07.code;

/**
 * WeakPasswordChecker : 암호가 약한지 검사
 *
 * 1. 테스트 대상이 UserRegister 이므로, WeakPasswordChecker는 '대역'을 사용할 것
 *    (실제 동작 구현은 필요하지 않으므로 Stub 대역으로 될 것이다)
 * 2. WeakPasswordChecker 인터페이스 사용, 구현체로 StubPasswordChecker 사용
 * 3. 암호가 약하다고 판단되면 WeakPasswordException 예외를 던질 것
 */
public interface WeakPasswordChecker {
    boolean checkPasswordWeak(String pw);   // 1. 암호 검사 메소드
}
