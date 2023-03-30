package api.bookstore.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookForm {

    @NotNull(message = "Preencha o campo corretamente.")
    private Long authorId;

    @NotNull(message = "Preencha o campo corretamente.")
    private Long publisherId;

    @NotBlank(message = "Preencha o campo corretamente.")
    @Size(min = 3, max = 100, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String title;

    @NotBlank(message = "Preencha o campo corretamente.")
    private String ISBN;

    @NotBlank(message = "Preencha o campo corretamente.")
    @Size(min = 3, max = 100, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String language;

    @NotBlank(message = "Preencha o campo corretamente.")
    @Size(min = 3, max = 100, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String genre;

    @NotBlank(message = "Preencha o campo corretamente.")
    @Size(min = 3, max = 100, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String category;

    @NotNull(message = "Preencha o campo corretamente.")
    private int publicationYear;

    @NotNull(message = "Preencha o campo corretamente.")
    private float price;

    @NotNull(message = "Preencha o campo corretamente.")
    private int quantity;

    @NotBlank(message = "Preencha o campo corretamente.")
    private String img;
}
