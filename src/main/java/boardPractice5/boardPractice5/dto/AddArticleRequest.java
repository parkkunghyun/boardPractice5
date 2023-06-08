package boardPractice5.boardPractice5.dto;

import boardPractice5.boardPractice5.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddArticleRequest {
    String title;
    String content;

    public Article toEntity() {
        return Article.builder().title(this.title).content(this.content).build();
    }
}
