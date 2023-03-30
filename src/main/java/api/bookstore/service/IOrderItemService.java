package api.bookstore.service;

import api.bookstore.model.OrderItem;
import api.bookstore.request.OrderItemForm;

import java.util.List;
import java.util.Optional;

public interface IOrderItemService {
    OrderItem create(OrderItemForm form);
    List<OrderItem> getAll();
    Optional<OrderItem> findById(long id);
    Optional<OrderItem> update(Long id, OrderItemForm formUpdate);
    void delete(Long id);
}
