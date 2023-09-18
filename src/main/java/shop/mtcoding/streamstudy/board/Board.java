package shop.mtcoding.streamstudy.board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.streamstudy.user.User;

@NoArgsConstructor
@Getter @Setter
public class Board {
    private Integer id;
    private String title;
    private String content;
    private String author;
    private User user;

    @Builder
    public Board(Integer id, String title, String content, String author, User user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.user = user;
    }
    
}