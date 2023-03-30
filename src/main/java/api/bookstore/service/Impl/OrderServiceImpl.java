package api.bookstore.service.Impl;

import api.bookstore.model.Order;
import api.bookstore.model.Costumer;
import api.bookstore.model.OrderItem;
import api.bookstore.request.OrderForm;
import api.bookstore.repository.CostumerRepository;
import api.bookstore.repository.OrderRepository;
import api.bookstore.request.OrderItemForm;
import api.bookstore.service.IOrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements IOrderService {

    private final OrderRepository orderRepository;

    private final CostumerRepository costumerRepository;

    private final OrderItemServiceImpl itemService;

    public OrderServiceImpl(OrderRepository orderRepository, CostumerRepository costumerRepository,
                            OrderItemServiceImpl itemService) {
        this.orderRepository = orderRepository;
        this.costumerRepository = costumerRepository;
        this.itemService = itemService;
    }

    @Override
    public Order create(OrderForm form) {
        Order order = new Order();
        Costumer costumer = costumerRepository.findById(form.getCostumerId()).get();
        order.setCustomer(costumer);

        List<OrderItem> items = new ArrayList<>();
        order.setOrderItems(items);
        /* TODO: OrderItems */
        order.setOrderDate(form.getOrderDate());
        order.setShipping(form.getShipping());
        order.setTotal(form.getTotal());

        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Optional<Order> update(Long id, OrderForm formUpdate) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
