package dio.bookstore.service.Impl;

import dio.bookstore.model.Author;
import dio.bookstore.model.form.AuthorForm;
import dio.bookstore.model.form.AuthorUpdateForm;
import dio.bookstore.repository.AuthorRepository;
import dio.bookstore.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements IAuthorService {

    @Autowired
    private AuthorRepository repository;

    @Override
    public Author create(AuthorForm form) {
        return null;
    }

    @Override
    public List<Author> getAll() {
        return null;
    }

    @Override
    public Author get(Long id) {
        return null;
    }

    @Override
    public Author update(Long id, AuthorUpdateForm formUpdate) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
