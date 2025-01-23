package Model;

public class Books {
    private String title;
    private String author;
    private String bookId;

    public Books(String title, String author, String bookId) {
        this.title = title;
        this.author = author;
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString(){
        return String.format("[Title: %s, Author: %s]", title, author);
    }
}
