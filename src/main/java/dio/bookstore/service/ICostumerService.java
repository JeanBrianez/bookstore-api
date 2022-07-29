package dio.bookstore.service;

import dio.bookstore.model.Costumer;
import dio.bookstore.model.form.CostumerForm;
import dio.bookstore.model.form.CostumerUpdateForm;

import java.util.List;

public interface ICostumerService {
    Costumer create(CostumerForm form);
    List<Costumer> getAll();
    Costumer get(Long id);
    Costumer update(Long id, CostumerUpdateForm formUpdate);
    void delete(Long id);
}
