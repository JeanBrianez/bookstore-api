package api.bookstore.unit;

import api.bookstore.model.Author;
import api.bookstore.repository.AuthorRepository;
import api.bookstore.request.AuthorForm;
import api.bookstore.service.Impl.AuthorServiceImpl;
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
public class AuthorServiceTests {

    @Mock
    private AuthorRepository authorRepositoryMock;

    @InjectMocks
    private AuthorServiceImpl authorService;

    @Test
    public void getAllAuthorsWorking()
    {
        List<Author> authors = new ArrayList<>();
        Author author1 = new Author();
        author1.setAuthorId(1L);
        author1.setFirstName("Nome1");
        author1.setLastName("Sobrenome1");

        Author author2 = new Author();
        author2.setAuthorId(2L);
        author2.setFirstName("Nome2");
        author2.setLastName("Sobrenome2");

        authors.add(author1);
        authors.add(author2);

        Mockito.when(authorRepositoryMock.findAll()).thenReturn(authors);
        List<Author> result = authorService.getAll();

        assertEquals("Erro de GetALL na 1 entrada, FirstName","Nome1", result.get(0).getFirstName());
        assertEquals("Erro de GetALL na 1 entrada, LastName","Sobrenome1", result.get(0).getLastName());
        assertEquals("Erro de GetALL na 2 Entrada, FirstName","Nome2", result.get(1).getFirstName());
        assertEquals("Erro de GetALL na 2 Entrada, LastName","Sobrenome2", result.get(1).getLastName());
    }

    @Test
    public void findAuthorByIdWorking()
    {
        Author author = new Author();
        author.setAuthorId(1L);
        author.setFirstName("TesteNome");
        author.setLastName("TesteSobrenome");

        Mockito.when(authorRepositoryMock.findById(1L)).thenReturn(Optional.of(author));
        Optional<Author> result = authorService.findById(1L);

        assertEquals("Erro de FindById no FirstName", "TesteNome", result.get().getFirstName());
        assertEquals("Erro de FindById no LastName","TesteSobrenome", result.get().getLastName());
    }

    @Test
    public void createAuthorWorking()
    {
        AuthorForm author = new AuthorForm();
        author.setFirstName("CreateNome");
        author.setLastName("CreateSobrenome");

        Mockito.when(authorRepositoryMock.save(Mockito.any(Author.class)))
                .thenAnswer(i -> {
                    Author savedAuthor = i.getArgument(0);
                    savedAuthor.setAuthorId(1L);
                    return savedAuthor;
                });

        Author createdAuthor = authorService.create(author);

        assertEquals("Erro de Create no FirstName", "CreateNome", createdAuthor.getFirstName());
        assertEquals("Erro de Create no LastName","CreateSobrenome", createdAuthor.getLastName());
    }

   @Test
   public void updateAuthorWorking()
   {
       AuthorForm authorForm = new AuthorForm();
       authorForm.setFirstName("CreatedNome");
       authorForm.setLastName("CreatedSobrenome");

       Mockito.when(authorRepositoryMock.save(Mockito.any(Author.class)))
               .thenAnswer(i -> {
                   Author savedAuthor = i.getArgument(0);
                   savedAuthor.setAuthorId(1L);
                   return savedAuthor;
               });

       Author createdAuthor = authorService.create(authorForm);

       AuthorForm authorUpdate = new AuthorForm();
       authorUpdate.setFirstName("UpdatedNome");
       authorUpdate.setLastName("UpdatedSobrenome");

       Mockito.when(authorRepositoryMock.findById(1L)).thenReturn(Optional.of(createdAuthor));
       Mockito.when(authorRepositoryMock.save(Mockito.any(Author.class))).thenAnswer(i -> i.getArgument(0));

       Optional<Author> updatedAuthor = authorService.update(1L,authorUpdate);

       assertTrue(String.valueOf(updatedAuthor.isPresent()),true);
       assertEquals("Erro de Update no FirstName", "UpdatedNome", updatedAuthor.get().getFirstName());
       assertEquals("Erro de Update no LastName","UpdatedSobrenome", updatedAuthor.get().getLastName());
   }

   @Test
   public void deleteAuthorWorking()
   {
       AuthorForm author = new AuthorForm();
       author.setFirstName("ToDeleteNome");
       author.setLastName("ToDeleteSobrenome");

       Mockito.when(authorRepositoryMock.save(Mockito.any(Author.class)))
               .thenAnswer(i -> {
                   Author savedAuthor = i.getArgument(0);
                   savedAuthor.setAuthorId(1L);
                   return savedAuthor;
               });

       Author createdAuthor = authorService.create(author);

       authorService.delete(createdAuthor.getAuthorId());

       Author deletedAuthor = authorRepositoryMock.findById(createdAuthor.getAuthorId()).orElse(null);

       assertNull("Erro de Delete no FirstName", deletedAuthor);
   }
}
