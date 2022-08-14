package dio.bookstore.controller;

import dio.bookstore.model.Author;
import dio.bookstore.model.Book;
import dio.bookstore.model.form.AuthorForm;
import dio.bookstore.model.form.AuthorUpdateForm;
import dio.bookstore.service.Impl.AuthorServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
@CrossOrigin(origins = "http://localhost:4200")
@Api
public class AuthorController {

    @Autowired
    private AuthorServiceImpl service;

    @GetMapping
    public List<Author> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Author> getAuthor(@PathVariable long id) { return service.findById(id);}

    @PostMapping
    public Author create(@Valid @RequestBody AuthorForm form) {
        return service.create(form);
    }

    @GetMapping("/books/{id}")
    public List<Book> getBooksFromAuthor(@PathVariable Long id) {
        return service.getBooksFromAuthor(id);
    }

    @PutMapping("/{id}")
    public Optional<Author> update(@Valid @RequestBody AuthorUpdateForm form, @PathVariable long id){
        return service.update(id, form);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
