package dio.bookstore.controller;

import dio.bookstore.model.Order;
import dio.bookstore.model.form.OrderForm;
import dio.bookstore.service.Impl.OrderServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@Api
public class OrderController {

    @Autowired
    private OrderServiceImpl service;

    @GetMapping
    public List<Order> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Order create(@RequestBody OrderForm form) {
        return service.create(form);
    }
}
