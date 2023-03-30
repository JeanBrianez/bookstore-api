package api.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_costumers")
public class Costumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long costumerId;

    private String firstName;

    private String lastName;

    private String CEP;

    private String phone;

    private String email;

    private String img;

    private final LocalDateTime created = LocalDateTime.now();

    private LocalDateTime modified;
}
