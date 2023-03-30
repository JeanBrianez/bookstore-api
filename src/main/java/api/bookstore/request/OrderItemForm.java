package api.bookstore.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemForm {
    @NotBlank(message = "Preencha o campo corretamente.")
    private Long OrderId;
    @NotBlank(message = "Preencha o campo corretamente.")
    private Long BookId;
    @NotBlank(message = "Preencha o campo corretamente.")
    private int quantity;
    @NotBlank(message = "Preencha o campo corretamente.")
    @DecimalMin(value = "0.01", message = "O valor mínimo é 0,01")
    @Digits(integer = 8, fraction = 2, message = "O valor deve ter no máximo 8 dígitos inteiros e 2 decimais")
    private int price;
}
