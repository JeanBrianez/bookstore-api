package dio.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @OneToOne(cascade = CascadeType.ALL)
    private Costumer customer;

    private float subtotal;

    private float shipping;

    private LocalDateTime orderDate;

    private float total;

    private final LocalDateTime created = LocalDateTime.now();
}
