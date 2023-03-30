package api.bookstore.service;

import api.bookstore.model.Book;
import api.bookstore.model.Author;
import api.bookstore.request.AuthorForm;

import java.util.List;
import java.util.Optional;

public interface IAuthorService {
    Author create(AuthorForm form);
    List<Author> getAll();
    Optional<Author> findById(long id);
    Optional<Author> update(Long id, AuthorForm formUpdate);
    void delete(Long id);
    List<Book> getBooksFromAuthor(Long id);
}
