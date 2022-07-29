package dio.bookstore.configuration;

import dio.bookstore.model.Author;
import dio.bookstore.model.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Book getLivro() {
        return new Book();
    }

    @Bean
    public Author getAutorLivro() {
        return new Author();
    }
}
