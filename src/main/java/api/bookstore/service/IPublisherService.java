package api.bookstore.service;

import api.bookstore.model.Publisher;
import api.bookstore.request.PublisherForm;

import java.util.List;
import java.util.Optional;

public interface IPublisherService {
    Publisher create(PublisherForm form);
    List<Publisher> getAll();
    Optional<Publisher> findById(long id);
    Optional<Publisher> update(Long id, PublisherForm formUpdate);
    void delete(Long id);

}
