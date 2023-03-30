package api.bookstore.service.Impl;

import api.bookstore.model.Costumer;
import api.bookstore.request.CostumerForm;
import api.bookstore.repository.CostumerRepository;
import api.bookstore.service.ICostumerService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CostumerServiceImpl implements ICostumerService {

    private final CostumerRepository costumerRepository;

    public CostumerServiceImpl(CostumerRepository costumerRepository) {
        this.costumerRepository = costumerRepository;
    }

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
        return costumerRepository.findAll();
    }

    @Override
    public Optional<Costumer> findById(long id) {
        return costumerRepository.findById(id);
    }

    @Override
    public Optional<Costumer> update(Long id, CostumerForm formUpdate) {
        return costumerRepository.findById(id)
                .map(newCostumer -> {
                    newCostumer.setFirstName(formUpdate.getFirstName());
                    newCostumer.setLastName(formUpdate.getLastName());
                    newCostumer.setCEP(formUpdate.getCEP());
                    newCostumer.setPhone(formUpdate.getPhone());
                    newCostumer.setEmail(formUpdate.getEmail());
                    newCostumer.setImg(formUpdate.getImg());
                    newCostumer.setModified(LocalDateTime.now());
                    return costumerRepository.save(newCostumer);
                });
    }

    @Override
    public void delete(Long id) {
        costumerRepository.deleteById(id);
    }
}
