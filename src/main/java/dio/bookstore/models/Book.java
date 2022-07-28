package dio.bookstore.models;

import org.springframework.beans.factory.annotation.Autowired;

public class Book {
    private String code;
    private String name;
    private float price;
    private int quantity;
    private String category;
    private String img;
    @Autowired
    BookAuthor bookAuthor;

    public BookAuthor getAutorLivro() {
        return bookAuthor;
    }

    public void setAutorLivro(BookAuthor bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public BookAuthor getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(BookAuthor bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void exibir () {
        System.out.println(this.name + " - " + this.code);
        bookAuthor.showAuthor();
    }
}
