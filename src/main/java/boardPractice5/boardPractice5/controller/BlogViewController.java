package boardPractice5.boardPractice5.controller;

import boardPractice5.boardPractice5.domain.Article;
import boardPractice5.boardPractice5.dto.ArticleListViewResponse;
import boardPractice5.boardPractice5.dto.ArticleViewResponse;
import boardPractice5.boardPractice5.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Locale;

@Controller
@RequiredArgsConstructor
public class BlogViewController {
    private final BlogService blogService;

    // list
    @GetMapping("/articles")
    public String articleList(Model model) {
        List<ArticleListViewResponse> articleList = blogService.list()
                .stream().map(ArticleListViewResponse :: new).toList();

        model.addAttribute("articles", articleList);
        return "blog/articleList";
    }
    // article -> 삭제 버튼 여기 포함
    @GetMapping("/articles/{id}")
    public String getArticleView(Model model, @PathVariable long id) {
        Article article =blogService.getArticle(id);
        model.addAttribute("article", new ArticleViewResponse(article));
        return "blog/article";
    }
    // 등록 수정 페이지만 보여주기!! 실제 작동은 api Controller에 적은 애들을 사용할거다!!
    @GetMapping("/new-article")
    public String addOrEditArticle(Model model, @RequestParam(required = false) Long id) {
        if(id == null) {
            model.addAttribute("article", new ArticleViewResponse());
        } else {
            Article article = blogService.getArticle(id);
            model.addAttribute("article", new ArticleViewResponse(article));

        }
        return "blog/new-article";
    }
}
