package api.bookstore.unit;

import api.bookstore.model.Book;
import api.bookstore.model.Order;
import api.bookstore.model.OrderItem;
import api.bookstore.repository.BookRepository;
import api.bookstore.repository.OrderItemRepository;
import api.bookstore.repository.OrderRepository;
import api.bookstore.request.OrderItemForm;
import api.bookstore.service.Impl.OrderItemServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.util.AssertionErrors.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderItemServiceTests {

    @Mock
    private OrderItemRepository itemRepositoryMock;

    @Mock
    private BookRepository bookRepositoryMock;

    @Mock
    private OrderRepository orderRepositoryMock;

    @InjectMocks
    private OrderItemServiceImpl itemService;

    @Test
    public void getAllBooksWorking()
    {
        Book book1 = new Book();
        book1.setBookId(1L);
        book1.setTitle("Nome1");
        book1.setPrice(39);

        Book book2 = new Book();
        book2.setBookId(2L);
        book2.setTitle("Nome2");
        book2.setPrice(28);

        Order order1 = new Order();
        order1.setOrderId(1L);
        order1.getCustomer().setCostumerId(1L);
        order1.setTotal(100);

        Order order2 = new Order();
        order2.setOrderId(2L);
        order2.getCustomer().setCostumerId(2L);
        order2.setTotal(100);

        List<OrderItem> items = new ArrayList<>();

        OrderItem item1 = new OrderItem();
        item1.setOrderItemId(1L);
        item1.getBook().setBookId(1L);
        item1.getOrder().setOrderId(1L);
        item1.setPrice(20);
        item1.setQuantity(45);

        OrderItem item2 = new OrderItem();
        item2.setOrderItemId(2L);
        item2.getBook().setBookId(2L);
        item2.getOrder().setOrderId(2L);
        item2.setPrice(30);
        item2.setQuantity(35);

        items.add(item1);
        items.add(item2);

        Mockito.when(itemRepositoryMock.findAll()).thenReturn(items);
        List<OrderItem> result = itemService.getAll();

        assertEquals("Erro de GetALL na 1 entrada, OrderItemID","Nome1", result.get(0).getOrderItemId());
        assertEquals("Erro de GetALL na 1 entrada, BookID","Teste*", result.get(0).getBook().getBookId());
        assertEquals("Erro de GetALL na 1 entrada, OrderID","Teste*", result.get(0).getOrder().getOrderId());
        assertEquals("Erro de GetALL na 1 entrada, Quantity","Teste*", result.get(0).getQuantity());
        assertEquals("Erro de GetALL na 1 entrada, Price","Teste*", result.get(0).getPrice());

        assertEquals("Erro de GetALL na 2 entrada, OrderItemID","Nome1", result.get(1).getOrderItemId());
        assertEquals("Erro de GetALL na 2 entrada, BookID","Teste*", result.get(1).getBook().getBookId());
        assertEquals("Erro de GetALL na 2 entrada, OrderID","Teste*", result.get(1).getOrder().getOrderId());
        assertEquals("Erro de GetALL na 2 entrada, Quantity","Teste*", result.get(1).getQuantity());
        assertEquals("Erro de GetALL na 2 entrada, Price","Teste*", result.get(1).getPrice());
    }

    @Test
    public void findItemByIdWorking()
    {
        OrderItem item = new OrderItem();
        item.setOrderItemId(1L);
        item.getBook().setBookId(1L);
        item.getOrder().setOrderId(1L);
        item.setPrice(39);
        item.setQuantity(75);

        Mockito.when(itemRepositoryMock.findById(1L)).thenReturn(Optional.of(item));
        Optional<OrderItem> result = itemService.findById(1L);

        assertEquals("Erro de FindById no FirstName", 1L, result.get().getOrderItemId());
        assertEquals("Erro de FindById no OrderItemID",1L, result.get().getBook().getBookId());
        assertEquals("Erro de FindById no *",1L, result.get().getOrder().getOrderId());
        assertEquals("Erro de FindById no *",39, result.get().getQuantity());
        assertEquals("Erro de FindById no *",75, result.get().getPrice());
    }

    @Test
    public void createOrderItemWorking()
    {
        OrderItemForm item = new OrderItemForm();
        item.setBookId(1L);
        item.setOrderId(1L);
        item.setPrice(27);
        item.setQuantity(123);

        Mockito.when(itemRepositoryMock.save(Mockito.any(OrderItem.class)))
                .thenAnswer(i -> {
                    OrderItem savedOrderItem = i.getArgument(0);
                    savedOrderItem.setOrderItemId(1L);
                    return savedOrderItem;
                });

        OrderItem createdOrderItem = itemService.create(item);

        assertEquals("Erro de Create no OrderItemID","1L", createdOrderItem.getOrderItemId());
        assertEquals("Erro de Create no BookID", "1L", createdOrderItem.getBook());
        assertEquals("Erro de Create no OrderID","1L", createdOrderItem.getOrder());
        assertEquals("Erro de Create no Quantity","Livro Create", createdOrderItem.getQuantity());
        assertEquals("Erro de Create no Price","1111111111", createdOrderItem.getPrice());
    }

    @Test
    public void updateOrderItemWorking()
    {
        OrderItemForm itemForm = new OrderItemForm();
        itemForm.setBookId(1L);
        itemForm.setOrderId(1L);
        itemForm.setPrice(10);
        itemForm.setQuantity(15);

        Mockito.when(itemRepositoryMock.save(Mockito.any(OrderItem.class)))
                .thenAnswer(i -> {
                    OrderItem savedOrderItem = i.getArgument(0);
                    savedOrderItem.setOrderItemId(1L);
                    return savedOrderItem;
                });

        OrderItem createdOrderItem = itemService.create(itemForm);

        OrderItemForm itemUpdate = new OrderItemForm();
        itemUpdate.setBookId(2L);
        itemUpdate.setOrderId(2L);
        itemUpdate.setPrice(20);
        itemUpdate.setQuantity(45);

        Mockito.when(itemRepositoryMock.save(Mockito.any(OrderItem.class))).thenAnswer(i -> i.getArgument(0));

        Optional<OrderItem> updatedOrderItem = itemService.update(1L,itemUpdate);

        assertTrue(String.valueOf(updatedOrderItem.isPresent()),true);
        assertEquals("Erro de Create no OrderItemID","1L", createdOrderItem.getOrderItemId());
        assertEquals("Erro de Update no FirstName", "UpdatedNome", updatedOrderItem.get().getBook());
        assertEquals("Erro de Update no LastName","UpdatedSobrenome", updatedOrderItem.get().getOrder());
        assertEquals("Erro de Create no ISBN","1111111111", createdOrderItem.getQuantity());
        assertEquals("Erro de Create no Language","Português", createdOrderItem.getPrice());
    }

    @Test
    public void deleteOrderItemWorking()
    {
        OrderItemForm itemDelete = new OrderItemForm();
        itemDelete.setBookId(1L);
        itemDelete.setOrderId(1L);
        itemDelete.setPrice(20);
        itemDelete.setQuantity(45);

        Mockito.when(itemRepositoryMock.save(Mockito.any(OrderItem.class)))
                .thenAnswer(i -> {
                    OrderItem savedOrderItem = i.getArgument(0);
                    savedOrderItem.setOrderItemId(1L);
                    return savedOrderItem;
                });

        OrderItem createdOrderItem = itemService.create(itemDelete);

        itemService.delete(createdOrderItem.getOrderItemId());

        OrderItem deletedOrderItem = itemRepositoryMock.findById(createdOrderItem.getOrderItemId()).orElse(null);

        assertNull("Erro de Delete", deletedOrderItem);
    }
}
