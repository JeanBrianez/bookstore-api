package dio.bookstore.service;

import dio.bookstore.model.Book;
import dio.bookstore.model.form.BookForm;
import dio.bookstore.model.form.BookUpdateForm;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    Book create(BookForm form);
    Book get(Long id);
    Optional<Book> update(Long id, BookUpdateForm formUpdate);
    void delete(Long id);
    List<Book> getBooksFromPublisher(Long id);
    List<Book> getAll(String price);

    Optional<Book> findById(long id);
}
