package api.bookstore.controller;

import api.bookstore.model.OrderItem;
import api.bookstore.service.Impl.OrderItemServiceImpl;
import api.bookstore.request.OrderItemForm;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders/item")
@CrossOrigin(origins = "http://localhost:4200")
@Api
public class OrderItemController {

    @Autowired
    private OrderItemServiceImpl service;

    @GetMapping
    public List<OrderItem> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<OrderItem> getOrderItem(@PathVariable long id) { return service.findById(id);}

    @PostMapping
    public OrderItem create(@RequestBody OrderItemForm form) {
        return service.create(form);
    }

    @PutMapping("/{id}")
    public Optional<OrderItem> update(@Valid @RequestBody OrderItemForm form, @PathVariable long id){
        return service.update(id, form);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
