package dio.bookstore.service;

import dio.bookstore.model.Publisher;
import dio.bookstore.model.form.PublisherForm;
import dio.bookstore.model.form.PublisherUpdateForm;

import java.util.List;
import java.util.Optional;

public interface IPublisherService {
    Publisher create(PublisherForm form);
    List<Publisher> getAll();
    Publisher get(Long id);
    Optional<Publisher> update(Long id, PublisherUpdateForm formUpdate);
    void delete(Long id);

    Optional<Publisher> findById(long id);
}
