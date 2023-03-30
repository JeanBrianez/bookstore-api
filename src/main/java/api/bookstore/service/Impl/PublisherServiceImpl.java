package api.bookstore.service.Impl;

import api.bookstore.model.Publisher;
import api.bookstore.request.PublisherForm;
import api.bookstore.repository.PublisherRepository;
import api.bookstore.service.IPublisherService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PublisherServiceImpl implements IPublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

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
    public Optional<Publisher> findById(long id) {
        return publisherRepository.findById(id);
    }

    @Override
    public Optional<Publisher> update(Long id, PublisherForm formUpdate) {
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
}
