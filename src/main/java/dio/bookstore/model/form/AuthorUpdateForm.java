package dio.bookstore.model.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorUpdateForm {

    @NotBlank(message = "Preencha o campo corretamente.")
    @Size(min = 3, max = 100, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String firstName;

    @NotBlank(message = "Preencha o campo corretamente.")
    @Size(min = 3, max = 100, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String lastName;

    private LocalDateTime modified;
}
