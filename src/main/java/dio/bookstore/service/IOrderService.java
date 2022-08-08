package dio.bookstore.service;

import dio.bookstore.model.Order;
import dio.bookstore.model.form.OrderForm;
import dio.bookstore.model.form.OrderUpdateForm;

import java.util.List;

public interface IOrderService {
    Order create(OrderForm form);
    List<Order> getAll();
    Order get(Long id);
    Order update(Long id, OrderUpdateForm formUpdate);
    void delete(Long id);
}
