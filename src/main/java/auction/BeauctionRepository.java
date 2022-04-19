package auction;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel="beauctions", path="beauctions")
public interface BeauctionRepository extends PagingAndSortingRepository<Beauction, Long>{
    Optional<Beauction> findByAucId(Long aucId);
    //List<Cancellation> findByMemId(String memId);
    //List<Cancellation> findByMemNo(String memNo);

}
