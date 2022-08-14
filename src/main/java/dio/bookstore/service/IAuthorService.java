package dio.bookstore.service;

import dio.bookstore.model.Author;
import dio.bookstore.model.Book;
import dio.bookstore.model.form.AuthorForm;
import dio.bookstore.model.form.AuthorUpdateForm;

import java.util.List;
import java.util.Optional;

public interface IAuthorService {
    Author create(AuthorForm form);
    List<Author> getAll();
    Author get(Long id);
    Optional<Author> update(Long id, AuthorUpdateForm formUpdate);
    void delete(Long id);
    List<Book> getBooksFromAuthor(Long id);

    Optional<Author> findById(long id);
}
