package dio.bookstore.model.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookForm {
    private String title;
    private String author;
    private String ISBN;
    private String language;
    private String genre;
    private String category;
    private int publicationYear;
    private float price;
    private int quantity;
    private String img;
}
