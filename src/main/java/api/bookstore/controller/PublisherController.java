package api.bookstore.controller;

import api.bookstore.service.Impl.PublisherServiceImpl;
import api.bookstore.model.Publisher;
import api.bookstore.request.PublisherForm;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/publishers")
@CrossOrigin(origins = "http://localhost:4200")
@Api
public class PublisherController {

    @Autowired
    private PublisherServiceImpl service;

    @GetMapping
    public List<Publisher> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Publisher> getPublisher(@PathVariable long id) { return service.findById(id);}

    @PostMapping
    public Publisher create(@Valid @RequestBody PublisherForm form) {
        return service.create(form);
    }

    @PutMapping("/{id}")
    public Optional<Publisher> update(@Valid @RequestBody PublisherForm form, @PathVariable long id){
        return service.update(id, form);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
