package tdd.intellij.chap02;

public class Calculator {

    // * 검증이 완료된 로직인 경우 src/test/java -> src/main/java 로 코드를 옮긴다
    public static int plus(int arg1, int arg2) {
//        return 0;
//        return 3;
//        return (arg1 == 4 && arg2 == 1) ? 5 : 3;
        int result = arg1 + arg2;
        System.out.println("result = " + result);
        return result;                              // -> TDD를 통한 점진적인 기능 완성 과정..!
    }
}
