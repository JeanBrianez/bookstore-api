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

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
    public Book get(Long id) {
        return null;
    }

    @Override
    public Optional<Book> update(Long id, BookUpdateForm formUpdate) {
        return bookRepository.findById(id)
                .map(newBook -> {
                    Author author = authorRepository.findById(formUpdate.getAuthorId()).get();
                    Publisher publisher = publisherRepository.findById(formUpdate.getPublisherId()).get();
                    newBook.setTitle(formUpdate.getTitle());
                    newBook.setAuthor(author);
                    newBook.setPublisher(publisher);
                    newBook.setISBN(formUpdate.getISBN());
                    newBook.setLanguage(formUpdate.getLanguage());
                    newBook.setGenre(formUpdate.getGenre());
                    newBook.setCategory(formUpdate.getCategory());
                    newBook.setPublicationYear(formUpdate.getPublicationYear());
                    newBook.setPrice(formUpdate.getPrice());
                    newBook.setQuantity(formUpdate.getQuantity());
                    newBook.setImg(formUpdate.getImg());
                    newBook.setModified(LocalDateTime.now());
                    return bookRepository.save(newBook);
                });
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
    @Override
    public List<Book> getBooksFromPublisher(Long id) {
        return null;
    }

    @Override
    public List<Book> getAll(String price) {
        if (price == null) {
            return bookRepository.findAll();
        }else {
            return bookRepository.findByPrice(Float.parseFloat(price));
        }
    }

    @Override
    public Optional<Book> findById(long id) {
        return bookRepository.findById(id);
    }
}
