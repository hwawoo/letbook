package letbook;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RentalHistRepository extends CrudRepository<RentalHist, Long> {

//    List<RentalHist> findById(Long id);

}