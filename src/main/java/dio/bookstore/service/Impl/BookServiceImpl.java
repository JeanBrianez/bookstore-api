package dio.bookstore.service.Impl;

import dio.bookstore.model.Author;
import dio.bookstore.model.Book;
import dio.bookstore.model.Publisher;
import dio.bookstore.model.form.BookForm;
import dio.bookstore.model.form.BookUpdateForm;
import dio.bookstore.repository.AuthorRepository;
import dio.bookstore.repository.BookRepository;
import dio.bookstore.repository.PublisherRepository;
import dio.bookstore.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public Book create(BookForm form) {
        Book book = new Book();
        Author author = authorRepository.findById(form.getAuthorId()).get();
        Publisher publisher = publisherRepository.findById(form.getPublisherId()).get();
        book.setTitle(form.getTitle());
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setISBN(form.getISBN());
        book.setLanguage(form.getLanguage());
        book.setGenre(form.getGenre());
        book.setCategory(form.getCategory());
        book.setPublicationYear(form.getPublicationYear());
        book.setImg(form.getImg());
        book.setQuantity(form.getQuantity());
        book.setPrice(form.getPrice());

        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book get(Long id) {
        return null;
    }

    @Override
    public Book update(Long id, BookUpdateForm formUpdate) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
