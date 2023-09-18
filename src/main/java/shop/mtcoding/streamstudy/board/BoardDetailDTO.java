package shop.mtcoding.streamstudy.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter
public class BoardDetailDTO {
    private Integer id;
    private String title;
    private String content;
    private String author;

    public BoardDetailDTO(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.author = board.getAuthor();
    }
    
}