package api.bookstore.request;

import api.bookstore.model.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderForm {
    @NotBlank(message = "Preencha o campo corretamente.")
    private Long CostumerId;

    @NotBlank(message = "Preencha o campo corretamente.")
    private List<OrderItem> orderItems;

    @NotBlank(message = "Preencha o campo corretamente.")
    @Size(min = 3, max = 100, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime orderDate;

    @NotBlank(message = "Preencha o campo corretamente.")
    @DecimalMin(value = "0.01", message = "O valor mínimo é 0,01")
    @Digits(integer = 8, fraction = 2, message = "O valor deve ter no máximo 6 dígitos inteiros e 2 decimais")
    private float shipping;

    @NotBlank(message = "Preencha o campo corretamente.")
    @DecimalMin(value = "0.01", message = "O valor mínimo é 0,01")
    @Digits(integer = 8, fraction = 2, message = "O valor deve ter no máximo 6 dígitos inteiros e 2 decimais")
    private float total;
}
