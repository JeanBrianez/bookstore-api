package api.bookstore.unit;

import api.bookstore.model.Publisher;
import api.bookstore.repository.PublisherRepository;
import api.bookstore.request.PublisherForm;
import api.bookstore.service.Impl.PublisherServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.util.AssertionErrors.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PublisherServiceTests {

    @Mock
    private PublisherRepository publisherRepositoryMock;

    @InjectMocks
    private PublisherServiceImpl publisherService;

    @Test
    public void getAllPublishersWorking()
    {
        List<Publisher> publishers = new ArrayList<>();
        Publisher publisher1 = new Publisher();
        publisher1.setPublisherId(1L);
        publisher1.setName("Nome1");
        publisher1.setCountry("País1");

        Publisher publisher2 = new Publisher();
        publisher2.setPublisherId(2L);
        publisher2.setName("Nome2");
        publisher2.setCountry("País2");

        publishers.add(publisher1);
        publishers.add(publisher2);

        Mockito.when(publisherRepositoryMock.findAll()).thenReturn(publishers);
        List<Publisher> result = publisherService.getAll();

        assertEquals("Erro de GetALL na 1 entrada, Name","Nome1", result.get(0).getName());
        assertEquals("Erro de GetALL na 1 entrada, Country","País1", result.get(0).getCountry());
        assertEquals("Erro de GetALL na 2 Entrada, Name","Nome2", result.get(1).getName());
        assertEquals("Erro de GetALL na 2 Entrada, Country","País2", result.get(1).getCountry());
    }

    @Test
    public void findPublisherByIdWorking()
    {
        Publisher publisher = new Publisher();
        publisher.setPublisherId(1L);
        publisher.setName("TesteNome");
        publisher.setCountry("TestePaís");

        Mockito.when(publisherRepositoryMock.findById(1L)).thenReturn(Optional.of(publisher));
        Optional<Publisher> result = publisherService.findById(1L);

        assertEquals("Erro de FindById no Name", "TesteNome", result.get().getName());
        assertEquals("Erro de FindById no Country","TestePaís", result.get().getCountry());
    }

    @Test
    public void createPublisherWorking()
    {
        PublisherForm publisherForm = new PublisherForm();
        publisherForm.setName("CreatedNome");
        publisherForm.setCountry("CreatedCountry");

        Mockito.when(publisherRepositoryMock.save(Mockito.any(Publisher.class)))
                .thenAnswer(i -> {
                    Publisher savedPublisher = i.getArgument(0);
                    savedPublisher.setPublisherId(1L);
                    return savedPublisher;
                });

        Publisher createdPublisher = publisherService.create(publisherForm);

        assertEquals("Erro de Create no Name", "CreatedNome", createdPublisher.getName());
        assertEquals("Erro de Create no Country","CreatedCountry", createdPublisher.getCountry());
    }

    @Test
    public void updatePublisherWorking()
    {
        PublisherForm publisherForm = new PublisherForm();
        publisherForm.setName("CreatedNome");
        publisherForm.setCountry("CreatedCountry");

        Mockito.when(publisherRepositoryMock.save(Mockito.any(Publisher.class)))
                .thenAnswer(i -> {
                    Publisher savedPublisher = i.getArgument(0);
                    savedPublisher.setPublisherId(1L);
                    return savedPublisher;
                });

        Publisher createdPublisher = publisherService.create(publisherForm);

        PublisherForm publisherUpdate = new PublisherForm();
        publisherUpdate.setName("UpdatedNome");
        publisherUpdate.setCountry("UpdatedCountry");

        Mockito.when(publisherRepositoryMock.findById(1L)).thenReturn(Optional.of(createdPublisher));
        Mockito.when(publisherRepositoryMock.save(Mockito.any(Publisher.class))).thenAnswer(i -> i.getArgument(0));

        Optional<Publisher> updatedPublisher = publisherService.update(1L,publisherUpdate);

        assertTrue(String.valueOf(updatedPublisher.isPresent()),true);
        assertEquals("Erro de Update no Name", "UpdatedNome", updatedPublisher.get().getName());
        assertEquals("Erro de Update no Country","UpdatedCountry", updatedPublisher.get().getCountry());
    }

    @Test
    public void deletePublisherWorking()
    {
        PublisherForm publisher = new PublisherForm();
        publisher.setName("ToDeleteNome");
        publisher.setCountry("ToDeletePaís");

        Mockito.when(publisherRepositoryMock.save(Mockito.any(Publisher.class)))
                .thenAnswer(i -> {
                    Publisher savedPublisher = i.getArgument(0);
                    savedPublisher.setPublisherId(1L);
                    return savedPublisher;
                });

        Publisher createdPublisher = publisherService.create(publisher);

        publisherService.delete(createdPublisher.getPublisherId());

        Publisher deletedPublisher = publisherRepositoryMock.findById(createdPublisher.getPublisherId()).orElse(null);

        assertNull("Erro de Delete no FirstName", deletedPublisher);
    }
}
