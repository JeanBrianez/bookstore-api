package dio.bookstore.model;

import java.time.LocalDateTime;

public class Author {

    private Long authorId;
    private String authorName;

    private LocalDateTime horaDigital = LocalDateTime.now();

    public void showAuthor() {
        System.out.println(this.authorName);
    }
}
