package boardPractice5.boardPractice5.controller;

import boardPractice5.boardPractice5.domain.Article;
import boardPractice5.boardPractice5.dto.AddArticleRequest;
import boardPractice5.boardPractice5.dto.ArticleResponse;
import boardPractice5.boardPractice5.dto.UpdateArticleRequest;
import boardPractice5.boardPractice5.service.BlogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BlogApiController {
    private final BlogService blogService;

    // add
    @PostMapping("/api/articles")
    public ResponseEntity<Article> saveArticle(@RequestBody AddArticleRequest request) {
        Article article = blogService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(article);
    }

    // list
    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> listArticles() {
        List<ArticleResponse> articleList = blogService.list().stream().map(ArticleResponse::new).toList();
        return ResponseEntity.ok().body(articleList);
    }

    // id
    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> getArticle(@PathVariable long id) {
        Article article = blogService.getArticle(id);
        return  ResponseEntity.ok().body(new ArticleResponse(article));
    }

    // update
    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> putArticle(@PathVariable long id, @RequestBody UpdateArticleRequest request) {
        Article article = blogService.update(id,request);
        return ResponseEntity.ok().body(article);
    }

    // delete
    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
        blogService.delete(id);
        return ResponseEntity.ok().build();
    }
}
