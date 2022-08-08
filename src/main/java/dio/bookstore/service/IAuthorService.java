package dio.bookstore.service;

import dio.bookstore.model.Author;
import dio.bookstore.model.form.AuthorForm;
import dio.bookstore.model.form.AuthorUpdateForm;

import java.util.List;

public interface IAuthorService {
    Author create(AuthorForm form);
    List<Author> getAll();
    Author get(Long id);
    Author update(Long id, AuthorUpdateForm formUpdate);
    void delete(Long id);
}
