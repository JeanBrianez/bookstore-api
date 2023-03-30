package api.bookstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Advice do Autor , toda vez que a exception for ativada, a anotation muda o
 * responseBody e o StatusCode, para que seja possivel navegar pela resposta do
 * recurso retornado.
 */

@ControllerAdvice
public class IdNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(IdNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String AuthorNotFoundHandler(IdNotFoundException ex)
    {
        return ex.getMessage();
    }
}
