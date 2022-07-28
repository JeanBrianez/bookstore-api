package dio.bookstore.models;

public class Author implements BookAuthor {
    private String authorName;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void showAuthor() {
        System.out.println(this.authorName);
    }
}
