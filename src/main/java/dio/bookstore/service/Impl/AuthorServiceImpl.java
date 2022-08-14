package dio.bookstore.service.Impl;

import dio.bookstore.model.Author;
import dio.bookstore.model.Book;
import dio.bookstore.model.form.AuthorForm;
import dio.bookstore.model.form.AuthorUpdateForm;
import dio.bookstore.repository.AuthorRepository;
import dio.bookstore.repository.BookRepository;
import dio.bookstore.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements IAuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Author create(AuthorForm form) {
        Author author = new Author();
        author.setFirstName(form.getFirstName());
        author.setLastName(form.getLastName());

        return authorRepository.save(author);
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author get(Long id) {
        return null;
    }

    @Override
    public Optional<Author> update(Long id, AuthorUpdateForm formUpdate) {
        return authorRepository.findById(id)
                .map(newAuthor -> {
                    newAuthor.setFirstName(formUpdate.getFirstName());
                    newAuthor.setLastName(formUpdate.getLastName());
                    newAuthor.setModified(LocalDateTime.now());
                    return authorRepository.save(newAuthor);
                });
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public List<Book> getBooksFromAuthor(Long id) {
        Author author = authorRepository.findById(id).get();
        return author.getAuthorBooks();
    }

    @Override
    public Optional<Author> findById(long id) {
        return authorRepository.findById(id);
    }
}
