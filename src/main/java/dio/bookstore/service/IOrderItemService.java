package dio.bookstore.service;

import dio.bookstore.model.OrderItem;
import dio.bookstore.model.form.OrderItemForm;
import dio.bookstore.model.form.OrderItemUpdateForm;

import java.util.List;

public interface IOrderItemService {
    OrderItem create(OrderItemForm form);
    List<OrderItem> getAll();
    OrderItem get(Long id);
    OrderItem update(Long id, OrderItemUpdateForm formUpdate);
    void delete(Long id);
}
