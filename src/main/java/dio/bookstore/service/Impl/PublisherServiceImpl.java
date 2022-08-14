package dio.bookstore.service.Impl;

import dio.bookstore.model.Publisher;
import dio.bookstore.model.form.PublisherForm;
import dio.bookstore.model.form.PublisherUpdateForm;
import dio.bookstore.repository.PublisherRepository;
import dio.bookstore.service.IPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
        return publisherRepository.findAll();
    }

    @Override
    public Publisher get(Long id) {
        return null;
    }

    @Override
    public Optional<Publisher> update(Long id, PublisherUpdateForm formUpdate) {
        return publisherRepository.findById(id)
                .map(newPublisher -> {
                    newPublisher.setCountry(formUpdate.getCountry());
                    newPublisher.setName(formUpdate.getName());
                    newPublisher.setModified(LocalDateTime.now());
                    return publisherRepository.save(newPublisher);
                });
    }

    @Override
    public void delete(Long id) {
        publisherRepository.deleteById(id);
    }

    @Override
    public Optional<Publisher> findById(long id) {
        return publisherRepository.findById(id);
    }
}
