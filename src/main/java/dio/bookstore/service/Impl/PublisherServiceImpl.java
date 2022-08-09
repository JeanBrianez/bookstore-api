package dio.bookstore.service.Impl;

import dio.bookstore.model.Publisher;
import dio.bookstore.model.form.PublisherForm;
import dio.bookstore.model.form.PublisherUpdateForm;
import dio.bookstore.repository.PublisherRepository;
import dio.bookstore.service.IPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements IPublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public Publisher create(PublisherForm form) {
        Publisher publisher = new Publisher();
        publisher.setName(form.getName());
        publisher.setCountry(form.getCountry());

        return publisherRepository.save(publisher);
    }

    @Override
    public List<Publisher> getAll() {
        return null;
    }

    @Override
    public Publisher get(Long id) {
        return null;
    }

    @Override
    public Publisher update(Long id, PublisherUpdateForm formUpdate) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
