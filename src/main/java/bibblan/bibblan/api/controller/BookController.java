package bibblan.bibblan.api.controller;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import bibblan.bibblan.api.model.Book;
import bibblan.bibblan.api.model.Book2;
import bibblan.bibblan.service.BookService;

@RestController
public class BookController {

    private BookService bookService;
    // Mot internt scope
/*     @Autowired
    public void BookController(BookService bookService) {
        this.bookService = bookService;
    }
  */
    @GetMapping("/books2")
    public List<Book2> getBook2() {
        return bookService.getBooks2();
    }

    @GetMapping("/book2/{id}")
    public Book2 getBook2(@PathVariable UUID id) {
        return bookService.getBook2(id);
    }

    @PostMapping("/book2")
    public Book2 createBook(@RequestBody Book2 book2) {
        System.out.println("User body " + book2);
        return bookService.createBook2(book2);
    }

    @DeleteMapping("/book2/{id}")
    public Book2 deleteBook2(@PathVariable UUID id) {
        return bookService.deleteBook2(id);
    }

    @PatchMapping("/book2/{id}/borrow2")
    public Object borrowBook2(@PathVariable UUID id) {
       return bookService.borrowBook2(id);
    }

    @PatchMapping("/book2/{id}/unborrow2")
    public Object unBorrowBook2(@PathVariable UUID id) {
       return bookService.unBorrowBook2(id);
    }


    // Mot SQL server
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping("/newBook")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book createdBook = bookService.createBook(book);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
    } 

    @PatchMapping("/books/{id}/borrow")
    public void borrowBook(@PathVariable String id) {
        bookService.borrowBook(id);
    } 

    @PatchMapping("/books/{id}/unborrow")
    public void ununborrowBook(@PathVariable String id) {
        bookService.unborrowBook(id);
    }  
}
