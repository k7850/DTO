package shop.mtcoding.streamstudy.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class BoardListDTO {
    private Integer id;
    private String title;
    private String author;


    public BoardListDTO(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.author = board.getAuthor();
    }

    
}
