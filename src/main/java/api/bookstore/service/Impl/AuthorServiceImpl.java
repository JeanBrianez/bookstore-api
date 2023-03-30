package api.bookstore.service.Impl;

import api.bookstore.model.Book;
import api.bookstore.model.Author;
import api.bookstore.request.AuthorForm;
import api.bookstore.repository.AuthorRepository;
import api.bookstore.repository.BookRepository;
import api.bookstore.service.IAuthorService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements IAuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

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
    public Optional<Author> findById(long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Optional<Author> update(Long id, AuthorForm formUpdate) {
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
}
