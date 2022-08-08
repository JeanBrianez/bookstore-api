package dio.bookstore.service.Impl;

import dio.bookstore.model.Order;
import dio.bookstore.model.form.OrderForm;
import dio.bookstore.model.form.OrderUpdateForm;
import dio.bookstore.repository.OrderRepository;
import dio.bookstore.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderRepository repository;

    @Override
    public Order create(OrderForm form) {
        return null;
    }

    @Override
    public List<Order> getAll() {
        return null;
    }

    @Override
    public Order get(Long id) {
        return null;
    }

    @Override
    public Order update(Long id, OrderUpdateForm formUpdate) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
