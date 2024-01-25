package bibblan.bibblan.api.model;

import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Book2 {
    @Id
    private UUID id;
    private String book_title;
    private String author;
    private String borrowed;

    public Book2(String book_title, String author, String borrowed) {
        id = UUID.randomUUID();
        this.book_title = book_title;
        this.author = author;
        this.borrowed = borrowed;
    }

    public UUID getId() {
        return id;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(String borrowed) {
        this.borrowed = borrowed;
    }
}
