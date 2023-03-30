package api.bookstore.unit;

import api.bookstore.model.Author;
import api.bookstore.model.Book;
import api.bookstore.model.Publisher;
import api.bookstore.repository.AuthorRepository;
import api.bookstore.repository.BookRepository;
import api.bookstore.repository.PublisherRepository;
import api.bookstore.request.BookForm;
import api.bookstore.service.Impl.BookServiceImpl;
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
public class BookServiceTests {

    @Mock
    private BookRepository bookRepositoryMock;

    @Mock
    private AuthorRepository authorRepositoryMock;

    @Mock
    private PublisherRepository publisherRepositoryMock;

    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    public void getAllBooksWorking()
    {
        Author author1 = new Author();
        author1.setAuthorId(1L);
        author1.setFirstName("Nome1");
        author1.setLastName("Sobrenome1");

        Author author2 = new Author();
        author2.setAuthorId(2L);
        author2.setFirstName("Nome2");
        author2.setLastName("Sobrenome2");

        Publisher publisher1 = new Publisher();
        publisher1.setPublisherId(1L);
        publisher1.setName("Nome1");
        publisher1.setCountry("País1");

        Publisher publisher2 = new Publisher();
        publisher2.setPublisherId(2L);
        publisher2.setName("Nome2");
        publisher2.setCountry("País2");

        List<Book> books = new ArrayList<>();
        Book book1 = new Book();
        book1.setBookId(1L);
        book1.getAuthor().setAuthorId(1L);
        book1.getPublisher().setPublisherId(1L);
        book1.setTitle("TítuloTeste");
        book1.setISBN("1234567890");
        book1.setLanguage("Português");
        book1.setGenre("Romance");
        book1.setCategory("Livro");
        book1.setPublicationYear(2006);
        book1.setPrice(20);
        book1.setQuantity(45);
        book1.setImg("imgtest.jpg");

        Book book2 = new Book();
        book2.setBookId(2L);
        book2.getAuthor().setAuthorId(2L);
        book2.getPublisher().setPublisherId(2L);
        book1.setTitle("TítuloTeste2");
        book1.setISBN("1234567892");
        book1.setLanguage("Inglês");
        book1.setGenre("Poesia");
        book1.setCategory("Livro");
        book1.setPublicationYear(2007);
        book1.setPrice(30);
        book1.setQuantity(15);
        book1.setImg("imgtest2.jpg");

        books.add(book1);
        books.add(book2);

        Mockito.when(bookRepositoryMock.findAll()).thenReturn(books);
        List<Book> result = bookService.getAll();

        assertEquals("Erro de GetALL na 1 entrada, BookID",1L, result.get(0).getBookId());
        assertEquals("Erro de GetALL na 1 entrada, AuthorID",1L, result.get(0).getAuthor().getAuthorId());
        assertEquals("Erro de GetALL na 1 entrada, PublisherID",1L, result.get(0).getPublisher().getPublisherId());
        assertEquals("Erro de GetALL na 1 entrada, Title","TítuloTeste", result.get(0).getTitle());
        assertEquals("Erro de GetALL na 1 entrada, ISBN","1234567890", result.get(0).getISBN());
        assertEquals("Erro de GetALL na 1 entrada, Language","Português", result.get(0).getLanguage());
        assertEquals("Erro de GetALL na 1 entrada, Genre","Romance", result.get(0).getGenre());
        assertEquals("Erro de GetALL na 1 entrada, Category","Livro", result.get(0).getCategory());
        assertEquals("Erro de GetALL na 1 entrada, Publication Year",2006, result.get(0).getPublicationYear());
        assertEquals("Erro de GetALL na 1 entrada, Price",20, result.get(0).getPrice());
        assertEquals("Erro de GetALL na 1 entrada, Quantity",45, result.get(0).getQuantity());
        assertEquals("Erro de GetALL na 1 entrada, Img","imgtest.jpg", result.get(0).getImg());

        assertEquals("Erro de GetALL na 2 entrada, BookID",2L, result.get(1).getBookId());
        assertEquals("Erro de GetALL na 2 entrada, AuthorID",2L, result.get(1).getAuthor().getAuthorId());
        assertEquals("Erro de GetALL na 2 entrada, PublisherID",2L, result.get(1).getPublisher().getPublisherId());
        assertEquals("Erro de GetALL na 2 entrada, Title","1234567892", result.get(1).getTitle());
        assertEquals("Erro de GetALL na 2 entrada, ISBN","Inglês", result.get(1).getISBN());
        assertEquals("Erro de GetALL na 2 entrada, Language","Teste*", result.get(1).getLanguage());
        assertEquals("Erro de GetALL na 2 entrada, Genre","Poesia", result.get(1).getGenre());
        assertEquals("Erro de GetALL na 2 entrada, Category","Livro", result.get(1).getCategory());
        assertEquals("Erro de GetALL na 2 entrada, Publication Year",2007, result.get(1).getPublicationYear());
        assertEquals("Erro de GetALL na 2 entrada, Price",30, result.get(1).getPrice());
        assertEquals("Erro de GetALL na 2 entrada, Quantity",15, result.get(1).getQuantity());
        assertEquals("Erro de GetALL na 2 entrada, Img","imgtest2.jpg", result.get(1).getImg());
    }

    @Test
    public void findBookByIdWorking()
    {
        Author author = new Author();
        author.setAuthorId(1L);
        author.setFirstName("FindNome");
        author.setLastName("FindSobrenome");

        Publisher publisher = new Publisher();
        publisher.setPublisherId(1L);
        publisher.setName("FindEmpresa");
        publisher.setCountry("Brasil");

        Book book = new Book();
        book.setBookId(1L);
        book.getAuthor().setAuthorId(1L);
        book.getPublisher().setPublisherId(1L);
        book.setTitle("FindById");
        book.setISBN("1234512345");
        book.setLanguage("English");
        book.setGenre("Romance");
        book.setCategory("Livro");
        book.setPublicationYear(2008);
        book.setPrice(39);
        book.setQuantity(75);
        book.setImg("find.jpg");

        Mockito.when(bookRepositoryMock.findById(1L)).thenReturn(Optional.of(book));
        Optional<Book> result = bookService.findById(1L);

        assertEquals("Erro de FindById no BookID", 1L, result.get().getBookId());
        assertEquals("Erro de FindById no AuthorID",1L, result.get().getAuthor().getAuthorId());
        assertEquals("Erro de FindById no PublisherID",1L, result.get().getPublisher().getPublisherId());
        assertEquals("Erro de FindById no Title","FindById", result.get().getTitle());
        assertEquals("Erro de FindById no ISBN","1234512345", result.get().getISBN());
        assertEquals("Erro de FindById no Language","English", result.get().getLanguage());
        assertEquals("Erro de FindById no Genre","Romance", result.get().getGenre());
        assertEquals("Erro de FindById no Category","Livro", result.get().getCategory());
        assertEquals("Erro de FindById no Publication Year",2008, result.get().getPublicationYear());
        assertEquals("Erro de FindById no Price",39, result.get().getPrice());
        assertEquals("Erro de FindById no Quantity",75, result.get().getQuantity());
        assertEquals("Erro de FindById no Img","find.jpg", result.get().getImg());
    }

    @Test
    public void createBookWorking()
    {
        Author authorCreate = new Author();
        authorCreate.setAuthorId(1L);
        authorCreate.setFirstName("NomeAuthorCreate");
        authorCreate.setLastName("SobrenomeAuthorCreate");

        Publisher publisherCreate = new Publisher();
        publisherCreate.setPublisherId(1L);
        publisherCreate.setName("NomePublisher");
        publisherCreate.setCountry("PaísPublisher");

        BookForm book = new BookForm();
        book.setAuthorId(1L);
        book.setPublisherId(1L);
        book.setTitle("Livro Create");
        book.setISBN("1111111111");
        book.setLanguage("Português");
        book.setGenre("Romance");
        book.setCategory("Livro");
        book.setPublicationYear(2015);
        book.setPrice(27);
        book.setQuantity(123);
        book.setImg("imgcreate.jpg");

        Mockito.when(authorRepositoryMock.findById(Mockito.anyLong())).thenReturn(Optional.of(authorCreate));
        Mockito.when(publisherRepositoryMock.findById(Mockito.anyLong())).thenReturn(Optional.of(publisherCreate));
        Mockito.when(bookRepositoryMock.save(Mockito.any(Book.class)))
                .thenAnswer(i -> {
                    Book savedBook = i.getArgument(0);
                    savedBook.setBookId(1L);
                    return savedBook;
                });

        Book createdBook = bookService.create(book);

        assertEquals("Erro de Create no BookID","1L", createdBook.getBookId());
        assertEquals("Erro de Create no AuthorID", "1L", createdBook.getAuthor());
        assertEquals("Erro de Create no PublisherID","1L", createdBook.getPublisher());
        assertEquals("Erro de Create no Title","Livro Create", createdBook.getTitle());
        assertEquals("Erro de Create no ISBN","1111111111", createdBook.getISBN());
        assertEquals("Erro de Create no Language","Português", createdBook.getLanguage());
        assertEquals("Erro de Create no Genre","Romance", createdBook.getGenre());
        assertEquals("Erro de Create no Category","Livro", createdBook.getCategory());
        assertEquals("Erro de Create no PublicationYear",2015, createdBook.getPublicationYear());
        assertEquals("Erro de Create no Price",27, createdBook.getPrice());
        assertEquals("Erro de Create no Quantity",123, createdBook.getQuantity());
        assertEquals("Erro de Create no Img","imgcreate.jpg", createdBook.getImg());
    }

    @Test
    public void updateBookWorking()
    {
        BookForm bookForm = new BookForm();
        bookForm.setAuthorId(1L);
        bookForm.setPublisherId(1L);
        bookForm.setTitle("Livro Errado");
        bookForm.setISBN("2222222222");
        bookForm.setLanguage("PT-BR");
        bookForm.setGenre("Poesia");
        bookForm.setCategory("Livro");
        bookForm.setPublicationYear(2003);
        bookForm.setPrice(25);
        bookForm.setQuantity(90);
        bookForm.setImg("imgerrada.jpg");

        Mockito.when(bookRepositoryMock.save(Mockito.any(Book.class)))
                .thenAnswer(i -> {
                    Book savedBook = i.getArgument(0);
                    savedBook.setBookId(1L);
                    return savedBook;
                });

        Book createdBook = bookService.create(bookForm);

        BookForm bookUpdate = new BookForm();
        bookUpdate.setAuthorId(1L);
        bookUpdate.setPublisherId(1L);
        bookUpdate.setTitle("Livro Certo");
        bookUpdate.setISBN("2222222223");
        bookUpdate.setLanguage("PT-BR");
        bookUpdate.setGenre("Poesia");
        bookUpdate.setCategory("Livro");
        bookUpdate.setPublicationYear(2004);
        bookUpdate.setPrice(26);
        bookUpdate.setQuantity(91);
        bookUpdate.setImg("imgcerta.jpg");

        Mockito.when(bookRepositoryMock.findById(1L)).thenReturn(Optional.of(createdBook));
        Mockito.when(bookRepositoryMock.save(Mockito.any(Book.class))).thenAnswer(i -> i.getArgument(0));

        Optional<Book> updatedBook = bookService.update(1L,bookUpdate);

        assertTrue(String.valueOf(updatedBook.isPresent()),true);
        assertEquals("Erro de Create no BookID","1L", createdBook.getBookId());
        assertEquals("Erro de Update no FirstName", "UpdatedNome", updatedBook.get().getAuthor());
        assertEquals("Erro de Update no LastName","UpdatedSobrenome", updatedBook.get().getPublisher());
        assertEquals("Erro de Create no Title","Livro Create", createdBook.getTitle());
        assertEquals("Erro de Create no ISBN","1111111111", createdBook.getISBN());
        assertEquals("Erro de Create no Language","Português", createdBook.getLanguage());
        assertEquals("Erro de Create no Genre","Romance", createdBook.getGenre());
        assertEquals("Erro de Create no Category","Livro", createdBook.getCategory());
        assertEquals("Erro de Create no PublicationYear",2015, createdBook.getPublicationYear());
        assertEquals("Erro de Create no Price",27, createdBook.getPrice());
        assertEquals("Erro de Create no Quantity",123, createdBook.getQuantity());
        assertEquals("Erro de Create no Img","imgcreate.jpg", createdBook.getImg());
    }

    @Test
    public void deleteBookWorking()
    {
        BookForm book = new BookForm();
        book.setAuthorId(1L);
        book.setPublisherId(1L);
        book.setTitle("Delete Book");
        book.setISBN("4444444444");
        book.setLanguage("English");
        book.setGenre("Romance");
        book.setCategory("Livro");
        book.setPublicationYear(2011);
        book.setPrice(34);
        book.setQuantity(45);
        book.setImg("deletebook.jpg");

        Mockito.when(bookRepositoryMock.save(Mockito.any(Book.class)))
                .thenAnswer(i -> {
                    Book savedBook = i.getArgument(0);
                    savedBook.setBookId(1L);
                    return savedBook;
                });

        Book createdBook = bookService.create(book);

        bookService.delete(createdBook.getBookId());

        Book deletedBook = bookRepositoryMock.findById(createdBook.getBookId()).orElse(null);

        assertNull("Erro de Delete", deletedBook);
    }
}
