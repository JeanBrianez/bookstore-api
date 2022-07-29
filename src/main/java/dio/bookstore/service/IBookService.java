package dio.bookstore.service;

import dio.bookstore.model.Book;
import dio.bookstore.model.form.BookForm;
import dio.bookstore.model.form.BookUpdateForm;

import java.util.List;

public interface IBookService {
    Book create(BookForm form);
    List<Book> getAll();
    Book get(Long id);
    Book update(Long id, BookUpdateForm formUpdate);
    void delete(Long id);
}
