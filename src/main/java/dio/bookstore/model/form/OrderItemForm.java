package dio.bookstore.model.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemForm {
    private Long OrderId;
    private Long BookId;
    private int quantity;
    private int price;
}
