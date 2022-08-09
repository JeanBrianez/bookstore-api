package dio.bookstore.service.Impl;

import dio.bookstore.model.Book;
import dio.bookstore.model.Order;
import dio.bookstore.model.OrderItem;
import dio.bookstore.model.form.OrderItemForm;
import dio.bookstore.model.form.OrderItemUpdateForm;
import dio.bookstore.repository.BookRepository;
import dio.bookstore.repository.OrderItemRepository;
import dio.bookstore.repository.OrderRepository;
import dio.bookstore.service.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements IOrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public OrderItem create(OrderItemForm form) {
        OrderItem orderItem = new OrderItem();
        Order order = orderRepository.findById(form.getOrderId()).get();
        Book book = bookRepository.findById(form.getBookId()).get();
        orderItem.setQuantity(form.getQuantity());
        orderItem.setPrice(form.getPrice());

        return orderItemRepository.save(orderItem);
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
