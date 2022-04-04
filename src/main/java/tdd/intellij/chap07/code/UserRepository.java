package tdd.intellij.chap07.code;

/**
 * UserRepository : 유저 정보를 저장하는 레포지토리
 *
 * 1. DB를 사용할 수는 없기 때문에 가짜 객체인 MemoryUserRepository '대역'을 사용할 것
 * 2. UserRepository 인터페이스 사용, 구현체로 MemoryUserRepository 사용
 * 3. 이미 중복된 유저(key : id)가 존재한다면 DupIdException 예외를 던질 것
 */
public interface UserRepository {

     void save(User user);          // user 저장
     User findById(Long id);      // id로 user 검색
}
