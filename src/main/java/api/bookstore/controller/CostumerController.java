package api.bookstore.controller;

import api.bookstore.service.Impl.CostumerServiceImpl;
import api.bookstore.model.Costumer;
import api.bookstore.request.CostumerForm;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/costumers")
@CrossOrigin(origins = "http://localhost:4200")
@Api
public class CostumerController {

    @Autowired
    private CostumerServiceImpl service;

    @GetMapping
    public List<Costumer> getAll() {
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Costumer> getCostumer(@PathVariable long id) { return service.findById(id);}

    @PostMapping
    public Costumer create(@RequestBody CostumerForm form) {
        return service.create(form);
    }

    @PutMapping("/{id}")
    public Optional<Costumer> update(@Valid @RequestBody CostumerForm form, @PathVariable long id){
        return service.update(id, form);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
