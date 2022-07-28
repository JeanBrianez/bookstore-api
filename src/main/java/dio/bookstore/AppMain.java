package dio.bookstore;

import dio.bookstore.configurations.AppConfig;
import dio.bookstore.models.Author;
import dio.bookstore.models.Book;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

@SpringBootApplication
public class AppMain {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);

		Book book = factory.getBean(Book.class);
		book.setName("Harry Potter");
		book.setCode("D34FD");

		Author author = factory.getBean(Author.class);
		author.setAuthorName("J.K. Rowling");

		book.exibir();

		factory.close();
	}

}
