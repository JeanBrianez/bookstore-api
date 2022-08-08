package dio.bookstore.model.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CostumerForm {
    private String firstName;
    private String lastName;
    private String CEP;
    private String phone;
    private String email;
    private String img;
}
