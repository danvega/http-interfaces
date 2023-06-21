package dev.danvega.articlesservice.controller;

import dev.danvega.articlesservice.model.Article;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    private final List<Article> articles = new ArrayList<>();

    @GetMapping
    public List<Article> findAll() throws InterruptedException {
        Thread.sleep(6000);
        return articles;
    }

    @GetMapping("/{id}")
    public Optional<Article> findById(@PathVariable Integer id) {
        return articles.stream().filter(article -> article.id().equals(id)).findFirst();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Article article) {
        this.articles.add(article);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Article article, @PathVariable Integer id) {
        var currentArticle = articles.stream().filter(a -> a.id().equals(id)).findFirst();
        currentArticle.ifPresent(value -> this.articles.set(articles.indexOf(value), article));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        this.articles.removeIf(a -> a.id().equals(id));
    }

    @PostConstruct
    private void init() {
        Article article = new Article(1,"Hello, World!","This is my first post");
        this.articles.add(article);
    }

}
