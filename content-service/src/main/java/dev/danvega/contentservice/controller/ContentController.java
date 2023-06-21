package dev.danvega.contentservice.controller;

import dev.danvega.contentservice.model.Article;
import dev.danvega.contentservice.service.ArticleClient;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    public final ArticleClient articleClient;

    public ContentController(ArticleClient articleClient) {
        this.articleClient = articleClient;
    }

    @GetMapping("/articles")
    public ResponseEntity<List<Article>> findAllArticles() {
        return articleClient.findAll();
    }

    @GetMapping("/articles/{id}")
    public Optional<Article> findById(@PathVariable Integer id) {
        return articleClient.findOne(id);
    }

    @PostMapping("/articles")
    public void create(@RequestBody Article article) {
        articleClient.create(article);
    }

    @PutMapping("/articles/{id}")
    public void update(@RequestBody Article article, @PathVariable Integer id) {
        articleClient.update(article,id);
    }

    @DeleteMapping("/articles/{id}")
    public void delete(@PathVariable Integer id) {
        articleClient.delete(id);
    }

}
