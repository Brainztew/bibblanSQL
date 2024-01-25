package bibblan.bibblan.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bibblan.bibblan.api.model.Book;
import bibblan.bibblan.api.model.Book2;
import bibblan.bibblan.api.repository.BookRepository; 

@Service
public class BookService {

    private final BookRepository bookRepository;

        private List<Book2> bookList;

        public void BookService2() {
            bookList = new ArrayList<>();
            bookList.add(new Book2("Arthur", "Sean Banan", "0"));
            bookList.add(new Book2("Arthur2", "Sean Banan2", "0"));
            bookList.add(new Book2("Arthur3", "Sean Banan3", "1"));
            bookList.add(new Book2("Arthur4", "Sean Banan4", "0"));
        }  

        public Book2 getBook2 (UUID id) {
            return bookList.stream()
            .filter(user -> id.equals(user.getId()))
            .findFirst()
            .orElse(null);
        }

        public List<Book2> getBooks2() {
            return bookList;
        }
    
        public Book2 createBook2(Book2 book2) {
            bookList.add(book2);
            return book2;
        }

        public Book2 deleteBook2(UUID id) {
            Optional<Book2> bookToRemove = bookList.stream()
                    .filter(book -> id.equals(book.getId()))
                    .findFirst();
        
            if (bookToRemove.isPresent()) {
                Book2 deletedBook = bookToRemove.get();
                bookList.remove(deletedBook);
                return deletedBook;
            } else {
                throw new RuntimeException("Book with ID " + id + " not found");
            }
        }
        public Object borrowBook2(UUID id) {
            Book2 opbook2 = getBook2(id);

            if (!opbook2.getBorrowed().equals("1")) {
                opbook2.setBorrowed("1");
                    return opbook2;
                } else {
                    throw new RuntimeException("Boken är redan utlånad!");
                }
            }
            
        
        public Object unBorrowBook2(UUID id) {
            Book2 opbook2 = getBook2(id);
    
            if (!opbook2.getBorrowed().equals("0")) {
                opbook2.setBorrowed("0");
                    return opbook2;
                } else {
                    throw new RuntimeException("Boken är redan tillbaka!");
                }
            }

    




    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Optional<Book> findBookById(String id) {
        return bookRepository.findById(id);
    }
    
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book createBook(Book book) {
        book.setId(UUID.randomUUID().toString());
        return bookRepository.save(book);
    }

    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }

    public Object borrowBook(String id) {
        Optional<Book> opbook = findBookById(id);
        if (opbook.isPresent()) {
            Book book = opbook.get();
            if (!book.getBorrowed().equals("1")) {
                book.setBorrowed("1");
                return bookRepository.save(book);
            } else {
                throw new RuntimeException("Boken är redan utlånad!");
            }
        }
        return null;
    }
    public Book unborrowBook(String id) {
        Optional<Book> opbook = findBookById(id);
        if (opbook.isPresent()) {
            Book book = opbook.get();
            if (!book.getBorrowed().equals("0")) {
                book.setBorrowed("0");
                return bookRepository.save(book);
            } else {
                throw new RuntimeException("Boken är redan tillbaka!");
            }
        }
        return null;
    }
 
}