package api.bookstore.exception;

public class IdNotFoundException extends RuntimeException{
    public IdNotFoundException(Long id)
    {
        super("ID: " + id + " not found!");
    }
}
//Encaixar no findByID com orElseThrow;

