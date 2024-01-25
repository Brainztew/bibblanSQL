package bibblan.bibblan.api.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Book {

    @Id
    private String id;
    private String book_title;
    private String author;

    @Temporal(TemporalType.DATE)
    private Date publicationDate;

    private String genre;
    private Double rating;
    private String borrowed;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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
    public Date getPublicationDate() {
        return publicationDate;
    }
    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public Double getRating() {
        return rating;
    }
    public void setRating(Double rating) {
        this.rating = rating;
    }
    public String getBorrowed() {
        return borrowed;
    }
    public void setBorrowed(String borrowed) {
        this.borrowed = borrowed;
    }
    
  

}