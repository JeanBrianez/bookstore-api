package dio.bookstore.service.Impl;

import dio.bookstore.model.Costumer;
import dio.bookstore.model.form.CostumerForm;
import dio.bookstore.model.form.CostumerUpdateForm;
import dio.bookstore.repository.CostumerRepository;
import dio.bookstore.service.ICostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostumerServiceImpl implements ICostumerService {

    @Autowired
    private CostumerRepository repository;

    @Override
    public Costumer create(CostumerForm form) {
        return null;
    }

    @Override
    public List<Costumer> getAll() {
        return null;
    }

    @Override
    public Costumer get(Long id) {
        return null;
    }

    @Override
    public Costumer update(Long id, CostumerUpdateForm formUpdate) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
