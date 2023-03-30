package api.bookstore.controller;

import api.bookstore.model.Order;
import api.bookstore.service.Impl.OrderServiceImpl;
import api.bookstore.request.OrderForm;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:4200")
@Api
public class OrderController {

    @Autowired
    private OrderServiceImpl service;

    @GetMapping
    public List<Order> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable long id) { return service.findById(id);}

    @PostMapping
    public Order create(@RequestBody OrderForm form) {
        return service.create(form);
    }

    @PutMapping("/{id}")
    public Optional<Order> update(@Valid @RequestBody OrderForm form, @PathVariable long id){
        return service.update(id, form);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
