package dio.bookstore.controller;

import dio.bookstore.model.Publisher;
import dio.bookstore.model.form.PublisherForm;
import dio.bookstore.service.Impl.PublisherServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publishers")
@Api
public class PublisherController {

    @Autowired
    private PublisherServiceImpl service;

    @GetMapping
    public List<Publisher> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Publisher create(@RequestBody PublisherForm form) {
        return service.create(form);
    }
}
