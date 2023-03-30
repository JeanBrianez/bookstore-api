package api.bookstore.service;

import api.bookstore.model.Costumer;
import api.bookstore.request.CostumerForm;

import java.util.List;
import java.util.Optional;

public interface ICostumerService {
    Costumer create(CostumerForm form);
    List<Costumer> getAll();
    Optional<Costumer> findById(long id);
    Optional<Costumer> update(Long id, CostumerForm formUpdate);
    void delete(Long id);
}
