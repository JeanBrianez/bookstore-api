package api.bookstore.unit;

import api.bookstore.model.Book;
import api.bookstore.model.Costumer;
import api.bookstore.model.Order;
import api.bookstore.model.OrderItem;
import api.bookstore.repository.CostumerRepository;
import api.bookstore.repository.OrderRepository;
import api.bookstore.request.OrderForm;
import api.bookstore.service.Impl.OrderServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.util.AssertionErrors.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTests {

    @Mock
    private OrderRepository orderRepositoryMock;

    @Mock
    private CostumerRepository costumerRepositoryMock;

    @InjectMocks
    private OrderServiceImpl orderService;

    @Test
    public void getAllOrdersWorking()
    {
        Costumer costumer1 = new Costumer();
        costumer1.setCostumerId(1L);
        costumer1.setFirstName("Nome1");
        costumer1.setLastName("Sobrenome1");

        Costumer costumer2 = new Costumer();
        costumer2.setCostumerId(2L);
        costumer2.setFirstName("Nome2");
        costumer2.setLastName("Sobrenome2");

        OrderItem item1 = new OrderItem();
        OrderItem item2 = new OrderItem();

        List<OrderItem> books1 = new ArrayList<>();
        books1.add(item1);
        books1.add(item2);

        List<OrderItem> books2 = new ArrayList<>();
        books1.add(item2);
        books1.add(item1);

        List<Order> orders = new ArrayList<>();
        Order order1 = new Order();
        order1.setOrderId(1L);
        order1.getCustomer().setCostumerId(1L);
        order1.setOrderItems(books1);
        order1.setOrderDate(LocalDateTime.MIN);
        order1.setShipping(25);
        order1.setTotal(100);

        Order order2 = new Order();
        order2.setOrderId(2L);
        order2.getCustomer().setCostumerId(2L);
        order2.setOrderItems(books2);
        order2.setOrderDate(LocalDateTime.MAX);
        order2.setShipping(32);
        order2.setTotal(123);

        orders.add(order1);
        orders.add(order2);

        Mockito.when(orderRepositoryMock.findAll()).thenReturn(orders);
        List<Order> result = orderService.getAll();

        assertEquals("Erro de GetALL na 1 entrada, FirstName","Nome1", result.get(0).getOrderId());
        assertEquals("Erro de GetALL na 1 entrada, LastName","1L", result.get(0).getCustomer().getCostumerId());
        assertEquals("Erro de GetALL na 1 entrada","Teste*", result.get(0).getOrderItems());
        assertEquals("Erro de GetALL na 1 entrada","Teste*", result.get(0).getOrderDate());
        assertEquals("Erro de GetALL na 1 entrada","Teste*", result.get(0).getShipping());
        assertEquals("Erro de GetALL na 1 entrada","Teste*", result.get(0).getTotal());

        assertEquals("Erro de GetALL na 2 entrada, FirstName","Nome2", result.get(1).getOrderId());
        assertEquals("Erro de GetALL na 2 entrada, LastName","", result.get(1).getCustomer().getCostumerId());
        assertEquals("Erro de GetALL na 2 entrada","Teste*", result.get(1).getOrderItems());
        assertEquals("Erro de GetALL na 2 entrada","Teste*", result.get(1).getOrderDate());
        assertEquals("Erro de GetALL na 2 entrada","Teste*", result.get(1).getShipping());
        assertEquals("Erro de GetALL na 2 entrada","Teste*", result.get(1).getTotal());
    }

    @Test
    public void findOrderByIdWorking()
    {
        Costumer costumer = new Costumer();
        costumer.setCostumerId(1L);
        costumer.setFirstName("FindNome");
        costumer.setLastName("FindSobrenome");

        OrderItem item1 = new OrderItem();
        OrderItem item2 = new OrderItem();

        List<OrderItem> books3 = new ArrayList<>();
        books3.add(item1);
        books3.add(item2);

        Order order = new Order();
        order.setOrderId(1L);
        order.setOrderItems(books3);
        order.setOrderDate(LocalDateTime.MAX);
        order.setShipping(12);
        order.setTotal(50);

        Mockito.when(orderRepositoryMock.findById(1L)).thenReturn(Optional.of(order));
        Optional<Order> result = orderService.findById(1L);

        assertEquals("Erro de FindById no FirstName", "TesteNome", result.get().getOrderId());
        assertEquals("Erro de FindById no CostumerID","1L", result.get().getCustomer().getCostumerId());
        assertEquals("Erro de FindById no *","Teste*", result.get().getOrderItems());
        assertEquals("Erro de FindById no *","Teste*", result.get().getOrderDate());
        assertEquals("Erro de FindById no *","Teste*", result.get().getShipping());
        assertEquals("Erro de FindById no *","Teste*", result.get().getTotal());
    }

    @Test
    public void createOrderWorking()
    {
        Costumer costumerCreate = new Costumer();
        costumerCreate.setCostumerId(1L);
        costumerCreate.setFirstName("NomeCostumerCreate");
        costumerCreate.setLastName("SobrenomeCostumerCreate");

        OrderItem item1 = new OrderItem();
        OrderItem item2 = new OrderItem();

        List<OrderItem> books4 = new ArrayList<>();
        books4.add(item1);
        books4.add(item2);

        OrderForm order = new OrderForm();
        order.setOrderItems(books4);
        order.setOrderDate(LocalDateTime.MIN);
        order.setShipping(24);
        order.setTotal(76);

        Mockito.when(costumerRepositoryMock.findById(Mockito.anyLong())).thenReturn(Optional.of(costumerCreate));
        Mockito.when(orderRepositoryMock.save(Mockito.any(Order.class)))
                .thenAnswer(i -> {
                    Order savedOrder = i.getArgument(0);
                    savedOrder.setOrderId(1L);
                    return savedOrder;
                });

        Order createdOrder = orderService.create(order);

        assertEquals("Erro de Create no OrderID","1L", createdOrder.getOrderId());
        assertEquals("Erro de Create no CostumerID", "1L", createdOrder.getCustomer().getCostumerId());
        assertEquals("Erro de Create no PublisherID","1L", createdOrder.getOrderItems());
        assertEquals("Erro de Create no Title","Livro Create", createdOrder.getOrderDate());
        assertEquals("Erro de Create no ISBN","1111111111", createdOrder.getShipping());
        assertEquals("Erro de Create no Language","Português", createdOrder.getTotal());
    }

    @Test
    public void updateOrderWorking()
    {
        OrderItem item1 = new OrderItem();
        OrderItem item2 = new OrderItem();

        List<OrderItem> books5 = new ArrayList<>();
        books5.add(item1);
        books5.add(item2);

        List<OrderItem> books6 = new ArrayList<>();
        books6.add(item2);
        books6.add(item1);

        OrderForm orderForm = new OrderForm();
        orderForm.setCostumerId(1L);
        orderForm.setOrderItems(books5);
        orderForm.setOrderDate(LocalDateTime.MIN);
        orderForm.setShipping(30);
        orderForm.setTotal(60);

        Mockito.when(orderRepositoryMock.save(Mockito.any(Order.class)))
                .thenAnswer(i -> {
                    Order savedOrder = i.getArgument(0);
                    savedOrder.setOrderId(1L);
                    return savedOrder;
                });

        Order createdOrder = orderService.create(orderForm);

        OrderForm orderUpdate = new OrderForm();
        orderUpdate.setCostumerId(1L);
        orderUpdate.setOrderItems(books6);
        orderUpdate.setOrderDate(LocalDateTime.MAX);
        orderUpdate.setShipping(35);
        orderUpdate.setTotal(65);

        Mockito.when(orderRepositoryMock.findById(1L)).thenReturn(Optional.of(createdOrder));
        Mockito.when(orderRepositoryMock.save(Mockito.any(Order.class))).thenAnswer(i -> i.getArgument(0));

        Optional<Order> updatedOrder = orderService.update(1L,orderUpdate);

        assertTrue(String.valueOf(updatedOrder.isPresent()),true);
        assertEquals("Erro de Create no OrderID","1L", createdOrder.getOrderId());
        assertEquals("Erro de Update no FirstName", "UpdatedNome", updatedOrder.get().getCustomer().getCostumerId());
        assertEquals("Erro de Create no Title","Livro Create", createdOrder.getOrderItems());
        assertEquals("Erro de Create no ISBN","1111111111", createdOrder.getOrderDate());
        assertEquals("Erro de Create no Language","Português", createdOrder.getShipping());
        assertEquals("Erro de Create no Genre","Romance", createdOrder.getTotal());
    }

    @Test
    public void deleteOrderWorking()
    {
        OrderItem item1 = new OrderItem();
        OrderItem item2 = new OrderItem();

        List<OrderItem> books7 = new ArrayList<>();
        books7.add(item1);
        books7.add(item2);

        OrderForm order = new OrderForm();
        order.setCostumerId(1L);
        order.setOrderItems(books7);
        order.setOrderDate(LocalDateTime.now());
        order.setShipping(15);
        order.setTotal(75);

        Mockito.when(orderRepositoryMock.save(Mockito.any(Order.class)))
                .thenAnswer(i -> {
                    Order savedOrder = i.getArgument(0);
                    savedOrder.setOrderId(1L);
                    return savedOrder;
                });

        Order createdOrder = orderService.create(order);

        orderService.delete(createdOrder.getOrderId());

        Order deletedOrder = orderRepositoryMock.findById(createdOrder.getOrderId()).orElse(null);

        assertNull("Erro de Delete", deletedOrder);
    }
}
