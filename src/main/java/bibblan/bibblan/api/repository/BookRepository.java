package bibblan.bibblan.api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import bibblan.bibblan.api.model.Book;

public interface BookRepository extends JpaRepository <Book, String> {
    
}
 