package letbook;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel="bookStores", path="bookStores")
public interface BookStoreRepository extends PagingAndSortingRepository<BookStore, Long>{

    Optional<BookStore> findByBookId(Long bookId);

}
