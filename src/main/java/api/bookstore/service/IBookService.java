package api.bookstore.service;

import api.bookstore.model.Book;
import api.bookstore.request.BookForm;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    Book create(BookForm form);
    List<Book> getAll();
    Optional<Book> findById(long id);
    Optional<Book> update(Long id, BookForm formUpdate);
    void delete(Long id);
    List<Book> getBooksFromPublisher(Long id);
    List<Book> getByPrice(String price);
}
