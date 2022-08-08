package dio.bookstore.repository;

import dio.bookstore.model.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostumerRepository extends JpaRepository<Costumer, Long> {}
