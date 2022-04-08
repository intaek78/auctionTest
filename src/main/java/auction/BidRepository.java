package auction;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel="bids", path="bids")
public interface BidRepository extends PagingAndSortingRepository<Bid, Long>{
    Optional<Bid> findByAucId(Long aucId);
    //List<Cancellation> findByMemId(String memId);
    //List<Cancellation> findByMemNo(String memNo);

}
