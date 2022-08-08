package dio.bookstore.service;

import dio.bookstore.model.Publisher;
import dio.bookstore.model.form.PublisherForm;
import dio.bookstore.model.form.PublisherUpdateForm;

import java.util.List;

public interface IPublisherService {
    Publisher create(PublisherForm form);
    List<Publisher> getAll();
    Publisher get(Long id);
    Publisher update(Long id, PublisherUpdateForm formUpdate);
    void delete(Long id);
}
