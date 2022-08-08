package dio.bookstore.controller;

import dio.bookstore.model.OrderItem;
import dio.bookstore.model.form.OrderItemForm;
import dio.bookstore.service.Impl.OrderItemServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders/item")
@Api
public class OrderItemController {

    @Autowired
    private OrderItemServiceImpl service;

    @GetMapping
    public List<OrderItem> getAll() {
        return service.getAll();
    }

    @PostMapping
    public OrderItem create(@RequestBody OrderItemForm form) {
        return service.create(form);
    }
}
