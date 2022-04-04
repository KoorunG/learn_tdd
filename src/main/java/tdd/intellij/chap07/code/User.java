package tdd.intellij.chap07.code;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String pw;
    private String email;

    public User(Long id) {
        this.id = id;
    }

    public User(Long id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    public User(Long id, String pw, String email) {
        this.id = id;
        this.pw = pw;
        this.email = email;
    }
}