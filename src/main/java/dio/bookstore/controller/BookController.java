package dio.bookstore.controller;

import dio.bookstore.model.Book;
import dio.bookstore.model.form.BookForm;
import dio.bookstore.service.Impl.BookServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@Api
public class BookController {

    @Autowired
    private BookServiceImpl service;

    @GetMapping
    public List<Book> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Book create(@RequestBody BookForm form) {
        return service.create(form);
    }
}
