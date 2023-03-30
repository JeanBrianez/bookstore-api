package api.bookstore.service.Impl;

import api.bookstore.model.Book;
import api.bookstore.model.Author;
import api.bookstore.model.Publisher;
import api.bookstore.request.BookForm;
import api.bookstore.repository.AuthorRepository;
import api.bookstore.repository.BookRepository;
import api.bookstore.repository.PublisherRepository;
import api.bookstore.service.IBookService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements IBookService {

    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    private final PublisherRepository publisherRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository,
                           PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

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
    public Optional<Book> findById(long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> update(Long id, BookForm formUpdate) {
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
    public List<Book> getByPrice(String price) {
        if (price == null) {
            return bookRepository.findAll();
        }else {
            return bookRepository.findByPrice(Float.parseFloat(price));
        }
    }
}
