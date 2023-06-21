package dev.danvega.contentservice.config;

import dev.danvega.contentservice.service.ArticleClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.time.Duration;

@Configuration
public class ClientConfig {

    @Bean
    ArticleClient articleClient() {
        WebClient client = WebClient.builder()
                .baseUrl("http://localhost:8081/api")
                .build();
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(client))
                .blockTimeout(Duration.ofSeconds(7))
                .build();
        return factory.createClient(ArticleClient.class);
    }

}
