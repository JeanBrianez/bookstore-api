package dio.bookstore.service.Impl;

import dio.bookstore.model.OrderItem;
import dio.bookstore.model.form.OrderItemForm;
import dio.bookstore.model.form.OrderItemUpdateForm;
import dio.bookstore.repository.OrderItemRepository;
import dio.bookstore.service.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements IOrderItemService {

    @Autowired
    private OrderItemRepository repository;

    @Override
    public OrderItem create(OrderItemForm form) {
        return null;
    }

    @Override
    public List<OrderItem> getAll() {
        return null;
    }

    @Override
    public OrderItem get(Long id) {
        return null;
    }

    @Override
    public OrderItem update(Long id, OrderItemUpdateForm formUpdate) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
