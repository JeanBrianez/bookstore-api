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
    private CostumerRepository costumerRepository;

    @Override
    public Costumer create(CostumerForm form) {
        Costumer costumer = new Costumer();
        costumer.setFirstName(form.getFirstName());
        costumer.setLastName(form.getLastName());
        costumer.setCEP(form.getCEP());
        costumer.setPhone(form.getPhone());
        costumer.setEmail(form.getEmail());
        costumer.setImg(form.getImg());

        return costumerRepository.save(costumer);
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
