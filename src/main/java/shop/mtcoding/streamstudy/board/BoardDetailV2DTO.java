package shop.mtcoding.streamstudy.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import shop.mtcoding.streamstudy.user.User;

// board(id, title, content), user(id, username), isOwner
@Getter @Setter @ToString
public class BoardDetailV2DTO {
    private Integer id;
    private String title;
    private String content;
    private UserDTO user;
    private boolean isOwner;

    public BoardDetailV2DTO(Board board, Integer sessionId) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.isOwner = board.getUser().getId() == sessionId;
        this.user = new UserDTO(board.getUser());
    }

    @Getter @Setter
    public class UserDTO {
        private Integer id;
        private String username;

        public UserDTO(User user) {
            this.id = user.getId();
            this.username = user.getUsername();
        }
    }


}