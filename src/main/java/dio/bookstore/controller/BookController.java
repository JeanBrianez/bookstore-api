package dio.bookstore.controller;

import dio.bookstore.model.Book;
import dio.bookstore.model.form.BookForm;
import dio.bookstore.model.form.BookUpdateForm;
import dio.bookstore.service.Impl.BookServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "http://localhost:4200")
@Api
public class BookController {

    @Autowired
    private BookServiceImpl service;

    @PostMapping
    public Book create(@Valid @RequestBody BookForm form) {
        return service.create(form);
    }

    @GetMapping
    public List<Book> getAll(@RequestParam(value = "price", required = false)
                                 String price) {
        return service.getAll(price);
    }

    @GetMapping("/{id}")
    public Optional<Book> getBook(@PathVariable long id) { return service.findById(id);}

    @PutMapping("/{id}")
    public Optional<Book> update(@Valid @RequestBody BookUpdateForm form, @PathVariable long id){
        return service.update(id, form);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
