package tdd.intellij.chap07.code;

import java.util.HashMap;
import java.util.Map;

public class MemoryUserRepository implements UserRepository {

    private Map<String, User> users = new HashMap<>();  // Map으로 회원을 저장하는 가짜 대역(Fake)

    @Override
    public void save(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public User findById(String id) {
        return users.get(id);
    }
}
