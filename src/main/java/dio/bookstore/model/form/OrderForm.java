package dio.bookstore.model.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderForm {
    private Long CostumerId;
    private float subtotal;
    private float shipping;
    private LocalDateTime orderDate;
    private float total;
}
