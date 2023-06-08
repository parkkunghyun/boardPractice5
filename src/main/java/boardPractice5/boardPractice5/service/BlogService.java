package boardPractice5.boardPractice5.service;

import boardPractice5.boardPractice5.domain.Article;
import boardPractice5.boardPractice5.dto.AddArticleRequest;
import boardPractice5.boardPractice5.dto.UpdateArticleRequest;
import boardPractice5.boardPractice5.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlogService {
    @Autowired
    private final BlogRepository blogRepository;

    // save
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    // list
    public List<Article> list() {
        return blogRepository.findAll();
    }

    // id
    public Article getArticle(long id) {
        return blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not founded!"));
    }

    // update
    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article findArticle = blogRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("not found"));

        findArticle.update(request.getTitle(), request.getContent());
        return findArticle;
     }

    // delete
    public void delete(long id) {
        blogRepository.deleteById(id);
    }
}
