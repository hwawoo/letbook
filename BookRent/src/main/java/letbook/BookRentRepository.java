package letbook;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel="bookRents", path="bookRents")
public interface BookRentRepository extends PagingAndSortingRepository<BookRent, Long>{


}

