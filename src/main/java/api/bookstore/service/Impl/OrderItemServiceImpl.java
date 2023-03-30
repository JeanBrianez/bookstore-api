package api.bookstore.service.Impl;

import api.bookstore.model.Book;
import api.bookstore.model.Order;
import api.bookstore.model.OrderItem;
import api.bookstore.request.OrderItemForm;
import api.bookstore.repository.BookRepository;
import api.bookstore.repository.OrderItemRepository;
import api.bookstore.repository.OrderRepository;
import api.bookstore.service.IOrderItemService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemServiceImpl implements IOrderItemService {

    private final OrderItemRepository orderItemRepository;

    private final OrderRepository orderRepository;

    private final BookRepository bookRepository;

    public OrderItemServiceImpl(OrderItemRepository orderItemRepository, OrderRepository orderRepository,
                                BookRepository bookRepository) {
        this.orderItemRepository = orderItemRepository;
        this.orderRepository = orderRepository;
        this.bookRepository = bookRepository;
    }

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
        return orderItemRepository.findAll();
    }

    @Override
    public Optional<OrderItem> findById(long id) {
        return orderItemRepository.findById(id);
    }

    @Override
    public Optional<OrderItem> update(Long id, OrderItemForm formUpdate) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
