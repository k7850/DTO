package shop.mtcoding.streamstudy.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class User {
    private Integer id;
    private String username;
    private String password;

    @Builder
    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    } 
}