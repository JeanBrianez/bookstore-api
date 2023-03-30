package api.bookstore.unit;

import api.bookstore.model.Costumer;
import api.bookstore.repository.CostumerRepository;
import api.bookstore.request.CostumerForm;
import api.bookstore.service.Impl.CostumerServiceImpl;
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
public class CostumerServiceTests {

    @Mock
    private CostumerRepository costumerRepositoryMock;

    @InjectMocks
    private CostumerServiceImpl costumerService;

    @Test
    public void getAllCostumersWorking()
    {
        List<Costumer> costumers = new ArrayList<>();
        Costumer costumer1 = new Costumer();
        costumer1.setCostumerId(1L);
        costumer1.setFirstName("Nome1");
        costumer1.setLastName("Sobrenome1");
        costumer1.setCEP("01101100");
        costumer1.setPhone("912345678");
        costumer1.setEmail("nome@mail.com");
        costumer1.setImg("img.jpg");

        Costumer costumer2 = new Costumer();
        costumer2.setCostumerId(2L);
        costumer2.setFirstName("Nome2");
        costumer2.setLastName("Sobrenome2");
        costumer2.setCEP("01101102");
        costumer2.setPhone("912345672");
        costumer2.setEmail("nome2@mail.com");
        costumer2.setImg("img2.jpg");

        costumers.add(costumer1);
        costumers.add(costumer2);

        Mockito.when(costumerRepositoryMock.findAll()).thenReturn(costumers);
        List<Costumer> result = costumerService.getAll();

        assertEquals("Erro de GetALL na 1 entrada, FirstName","Nome1", result.get(0).getFirstName());
        assertEquals("Erro de GetALL na 1 entrada, LastName","Sobrenome1", result.get(0).getLastName());
        assertEquals("Erro de GetALL na 1 entrada, CEP","01101100", result.get(0).getCEP());
        assertEquals("Erro de GetALL na 1 entrada, Phone","912345678", result.get(0).getPhone());
        assertEquals("Erro de GetALL na 1 entrada, Email","nome@mail.com", result.get(0).getEmail());
        assertEquals("Erro de GetALL na 1 entrada, Img","img.jpg", result.get(0).getImg());

        assertEquals("Erro de GetALL na 2 Entrada, FirstName","Nome2", result.get(1).getFirstName());
        assertEquals("Erro de GetALL na 2 Entrada, LastName","Sobrenome2", result.get(1).getLastName());
        assertEquals("Erro de GetALL na 2 Entrada, CEP","01101102", result.get(1).getCEP());
        assertEquals("Erro de GetALL na 2 Entrada, Phone","912345672", result.get(1).getPhone());
        assertEquals("Erro de GetALL na 2 Entrada, Email","nome2@mail.com", result.get(1).getEmail());
        assertEquals("Erro de GetALL na 2 Entrada, Img","img2.jpg", result.get(1).getImg());
    }

    @Test
    public void findCostumerByIdWorking()
    {
        Costumer costumer = new Costumer();
        costumer.setCostumerId(1L);
        costumer.setFirstName("TesteNome");
        costumer.setLastName("TesteSobrenome");
        costumer.setCEP("01101103");
        costumer.setPhone("912345679");
        costumer.setEmail("nometest@mail.com");
        costumer.setImg("imgtest.jpg");

        Mockito.when(costumerRepositoryMock.findById(1L)).thenReturn(Optional.of(costumer));
        Optional<Costumer> result = costumerService.findById(1L);

        assertEquals("Erro de FindById no FirstName", "TesteNome", result.get().getFirstName());
        assertEquals("Erro de FindById no LastName","TesteSobrenome", result.get().getLastName());
        assertEquals("Erro de FindById no CEP","01101103", result.get().getCEP());
        assertEquals("Erro de FindById no Phone","912345679", result.get().getPhone());
        assertEquals("Erro de FindById no Email","nometest@mail.com", result.get().getEmail());
        assertEquals("Erro de FindById no Img","imgtest.jpg", result.get().getImg());
    }

    @Test
    public void createCostumerWorking()
    {
        CostumerForm costumer = new CostumerForm();
        costumer.setFirstName("CreateNome");
        costumer.setLastName("CreateSobrenome");
        costumer.setCEP("01101104");
        costumer.setPhone("912345674");
        costumer.setEmail("nomecreate@mail.com");
        costumer.setImg("imgcreate.jpg");

        Mockito.when(costumerRepositoryMock.save(Mockito.any(Costumer.class)))
                .thenAnswer(i -> {
                    Costumer savedCostumer = i.getArgument(0);
                    savedCostumer.setCostumerId(1L);
                    return savedCostumer;
                });

        Costumer createdCostumer = costumerService.create(costumer);

        assertEquals("Erro de Create no FirstName", "CreateNome", createdCostumer.getFirstName());
        assertEquals("Erro de Create no LastName","CreateSobrenome", createdCostumer.getLastName());
        assertEquals("Erro de Create no CEP","01101104", createdCostumer.getCEP());
        assertEquals("Erro de Create no Phone","912345674", createdCostumer.getPhone());
        assertEquals("Erro de Create no Email","nomecreate@mail.com", createdCostumer.getEmail());
        assertEquals("Erro de Create no Img","imgcreate.jpg", createdCostumer.getImg());
    }

    @Test
    public void updateCostumerWorking()
    {
        CostumerForm costumerForm = new CostumerForm();
        costumerForm.setFirstName("CreatedNome");
        costumerForm.setLastName("CreatedSobrenome");
        costumerForm.setCEP("01101105");
        costumerForm.setPhone("912345675");
        costumerForm.setEmail("nomecreated@mail.com");
        costumerForm.setImg("imgcreated.jpg");

        Mockito.when(costumerRepositoryMock.save(Mockito.any(Costumer.class)))
                .thenAnswer(i -> {
                    Costumer savedCostumer = i.getArgument(0);
                    savedCostumer.setCostumerId(1L);
                    return savedCostumer;
                });

        Costumer createdCostumer = costumerService.create(costumerForm);

        CostumerForm costumerUpdate = new CostumerForm();
        costumerUpdate.setFirstName("UpdatedNome");
        costumerUpdate.setLastName("UpdatedSobrenome");
        costumerUpdate.setCEP("01101106");
        costumerUpdate.setPhone("912345676");
        costumerUpdate.setEmail("nomeupdate@mail.com");
        costumerUpdate.setImg("imgupdate.jpg");

        Mockito.when(costumerRepositoryMock.findById(1L)).thenReturn(Optional.of(createdCostumer));
        Mockito.when(costumerRepositoryMock.save(Mockito.any(Costumer.class))).thenAnswer(i -> i.getArgument(0));

        Optional<Costumer> updatedCostumer = costumerService.update(1L,costumerUpdate);

        assertTrue(String.valueOf(updatedCostumer.isPresent()),true);
        assertEquals("Erro de Update no FirstName", "UpdatedNome", updatedCostumer.get().getFirstName());
        assertEquals("Erro de Update no LastName","UpdatedSobrenome", updatedCostumer.get().getLastName());
        assertEquals("Erro de Update no CEP","01101106", updatedCostumer.get().getCEP());
        assertEquals("Erro de Update no Phone","912345676", updatedCostumer.get().getPhone());
        assertEquals("Erro de Update no Email","nomeupdate@mail.com", updatedCostumer.get().getEmail());
        assertEquals("Erro de Update no Img","imgupdate.jpg", updatedCostumer.get().getImg());
    }

    @Test
    public void deleteCostumerWorking()
    {
        CostumerForm costumer = new CostumerForm();
        costumer.setFirstName("ToDeleteNome");
        costumer.setLastName("ToDeleteSobrenome");
        costumer.setCEP("01101107");
        costumer.setPhone("912345677");
        costumer.setEmail("nomedelete@mail.com");
        costumer.setImg("imgdelete.jpg");

        Mockito.when(costumerRepositoryMock.save(Mockito.any(Costumer.class)))
                .thenAnswer(i -> {
                    Costumer savedCostumer = i.getArgument(0);
                    savedCostumer.setCostumerId(1L);
                    return savedCostumer;
                });

        Costumer createdCostumer = costumerService.create(costumer);

        costumerService.delete(createdCostumer.getCostumerId());

        Costumer deletedCostumer = costumerRepositoryMock.findById(createdCostumer.getCostumerId()).orElse(null);

        assertNull("Erro de Delete", deletedCostumer);
    }
}
