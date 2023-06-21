package dev.danvega.contentservice.service;

import dev.danvega.contentservice.model.Article;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;
import java.util.Optional;

public interface ArticleClient {

    @GetExchange("/articles")
    ResponseEntity<List<Article>> findAll();

    @GetExchange("/articles/{id}")
    Optional<Article> findOne(@PathVariable Integer id);

    @PostExchange("/articles")
    void create(@RequestBody Article article);

    @PutExchange("/articles/{id}")
    void update(@RequestBody Article article, @PathVariable Integer id);

    @DeleteExchange("/articles/{id}")
    void delete(@PathVariable Integer id);
}
