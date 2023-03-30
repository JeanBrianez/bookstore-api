package api.bookstore.configuration;

import api.bookstore.model.*;
import api.bookstore.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(
            AuthorRepository authorRepository,
            BookRepository bookRepository,
            CostumerRepository costumerRepository,
            OrderRepository orderRepository,
            OrderItemRepository itemRepository,
            PublisherRepository publisherRepository) {

        return args -> {
           if (authorRepository.count() == 0){
               Author author = new Author();
               author.setFirstName("Carlos");
               author.setLastName("Drummond de Andrade");
               authorRepository.save(author);
           }
           if (publisherRepository.count() == 0){
               Publisher publisher = new Publisher();
               publisher.setName("Companhia das Letras");
               publisher.setCountry("Brasil");
               publisherRepository.save(publisher);
           }
           if (costumerRepository.count() == 0){
               Costumer costumer = new Costumer();
               costumer.setFirstName("Jean Carlo");
               costumer.setLastName("Guedes Brianez");
               costumer.setCEP("09330520");
               costumerRepository.save(costumer);
           }
           if (bookRepository.count() == 0){
               Book book = new Book();
               Author author = authorRepository.findById(1L).get();
               Publisher publisher = publisherRepository.findById(1L).get();
               book.setTitle("Alguma Poesia");
               book.setAuthor(author);
               book.setPublisher(publisher);
               book.setISBN("8535922830");
               book.setLanguage("Portugues");
               book.setGenre("Poesia");
               book.setCategory("Livro");
               book.setPublicationYear(2013);
               book.setImg("https://images-na.ssl-images-amazon.com/images/I/41DlkipWHvL._SX324_BO1,204,203,200_.jpg");
               book.setQuantity(95);
               book.setPrice(25.00F);
               bookRepository.save(book);
           }
           /*if (orderRepository.count() == 0){
               Order order = new Order();
               Costumer costumer = costumerRepository.findById(1L).get();

               OrderItem item = new OrderItem();
               Book book = bookRepository.findById(1L).get();

               order.setCustomer(costumer);

               item.setBook(book);
               item.setQuantity(2);
               item.setPrice(50.00F);
               item.setOrder(order);
               itemRepository.save(item);

               List<OrderItem> items = new ArrayList<>();
               items.add(item);
               order.setOrderItems(items);

               order.setOrderDate(LocalDateTime.now());
               order.setShipping(10.00F);
               order.setTotal(60.00F);
               orderRepository.save(order);
           }*/
        };
    }
}