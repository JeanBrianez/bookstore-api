package dio.bookstore.controller;

import dio.bookstore.model.Author;
import dio.bookstore.model.form.AuthorForm;
import dio.bookstore.service.Impl.AuthorServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@Api
public class AuthorController {

    @Autowired
    private AuthorServiceImpl service;

    @GetMapping
    public List<Author> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Author create(@RequestBody AuthorForm form) {
        return service.create(form);
    }
}
