package tdd.intellij.chap02.code;

public class PasswordStrengthMeter {

    static int count = 0;

    public PasswordStrength meter(String value) {

        // null이 입력된 경우 && 빈 값이 입력된 경우
        if(value == null || value.isEmpty()) {
            return PasswordStrength.INVALID;
        }

        // 조건 실행
        isContainsUpper(value);
        isContainsNum(value);
        isSatisfyLength(value);

        switch (count) {
            case 0: case 1 :
                count = 0;              // 조건 검사 후 count 초기화
                return PasswordStrength.WEAK;
            case 2 :
                count = 0;
                return PasswordStrength.NORMAL;
            default:
                count = 0;
                return PasswordStrength.STRONG;
        }

//        // 길이가 8글자 이상인 조건만 만족하는 경우
//        if(isSatisfyLength(value) && !isContainsNum(value) && !isContainsUpper(value)) {
//            return PasswordStrength.WEAK;
//        }
//
//        // 숫자 포함 조건만 만족하는 경우
//        if(isContainsNum(value) && !isSatisfyLength(value) && !isContainsUpper(value)) {
//            return PasswordStrength.WEAK;
//        }
//
//        // 대문자 포함 조건만 만족하는 경우
//        if(!isContainsNum(value) && !isSatisfyLength(value) && isContainsUpper(value)) {
//            return PasswordStrength.WEAK;
//        }
//
//        // 길이가 8글자 미만인 경우
//        if(!isSatisfyLength(value)) {
//            return PasswordStrength.NORMAL;
//        }
//
//        // 숫자를 포함하지 않는 경우
//        if(!isContainsNum(value)){
//            return PasswordStrength.NORMAL;
//        }
//
//        // 대문자를 포함하지 않는 경우
//        if(!isContainsUpper(value)) {
//            return PasswordStrength.NORMAL;
//        }
//        // 모두 만족하는 경우
//        return PasswordStrength.STRONG;

    }


    // 숫자를 포함하는지 여부를 체크하는 메소드
    private void isContainsNum(String value) {
        for(char ch : value.toCharArray()){
            if(ch >= '0' && ch <= '9'){
                count += 1;
                break;
            }
        }
    }

    // 대문자를 포함 여부를 체크하는 메소드
    private void isContainsUpper(String value) {
        for(char ch : value.toCharArray()){
            if(Character.isUpperCase(ch)){
                count += 1;
                break;
            }
        }
    }

    // 길이 여부를 체크하는 메소드
    private void isSatisfyLength(String value) {
        if (value.length() >= 8){
            count += 1;
        }
    }
}
