package dio.bookstore.configuration;

import dio.bookstore.model.Author;
import dio.bookstore.repository.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(AuthorRepository authorRepository) {

        return args -> {
           //authorRepository.save(new Author());
        };
    }
}
