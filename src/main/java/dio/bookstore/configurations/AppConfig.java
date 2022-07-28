package dio.bookstore.configurations;

import dio.bookstore.models.Author;
import dio.bookstore.models.BookAuthor;
import dio.bookstore.models.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Book getLivro() {
        return new Book();
    }

    @Bean
    public BookAuthor getAutorLivro() {
        return new Author();
    }
}
