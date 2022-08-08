package dio.bookstore.controller;

import dio.bookstore.model.Costumer;
import dio.bookstore.model.form.CostumerForm;
import dio.bookstore.service.Impl.CostumerServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/costumers")
@Api
public class CostumerController {

    @Autowired
    private CostumerServiceImpl service;

    @GetMapping
    public List<Costumer> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Costumer create(@RequestBody CostumerForm form) {
        return service.create(form);
    }
}
