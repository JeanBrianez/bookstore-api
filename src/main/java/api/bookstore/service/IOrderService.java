package api.bookstore.service;

import api.bookstore.model.Order;
import api.bookstore.request.OrderForm;

import java.util.List;
import java.util.Optional;

public interface IOrderService {
    Order create(OrderForm form);
    List<Order> getAll();
    Optional<Order> findById(long id);
    Optional<Order> update(Long id, OrderForm formUpdate);
    void delete(Long id);
}
