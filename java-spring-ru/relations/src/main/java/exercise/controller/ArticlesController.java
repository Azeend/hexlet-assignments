package exercise.controller;

import exercise.dto.ArticleDto;
import exercise.model.Article;
import exercise.repository.ArticleRepository;

import exercise.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;


@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticlesController {

    private final ArticleRepository articleRepository;

    @GetMapping(path = "")
    public Iterable<Article> getArticles() {
        return articleRepository.findAll();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteArticle(@PathVariable long id) {
        articleRepository.deleteById(id);
    }

    // BEGIN
    @PostMapping(path = "")
    public Article createArticle(@RequestBody ArticleDto articleDto) {
        var article = new Article();
        article.setName(articleDto.getName());
        article.setBody(articleDto.getBody());
        article.setCategory(articleDto.getCategory());
        return articleRepository.save(article);
    }

    @PatchMapping(path = "/{id}")
    public Article updateArticle(@PathVariable long id, @RequestBody ArticleDto articleDto) {
        var article = articleRepository.findById(id);
        article.setName(articleDto.getName());
        article.setBody(articleDto.getBody());
        article.setCategory(articleDto.getCategory());
        return articleRepository.save(article);
    }

    @GetMapping(path = "/{id}")
    public Article getArticle(@PathVariable long id) {
        return articleRepository.findById(id);
    }
    // END
}
