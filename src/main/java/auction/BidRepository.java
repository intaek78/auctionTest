package auction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel="bids", path="bids")
public interface BidRepository extends JpaRepository<Bid, Long> {
    Optional<Bid> findByAucId(Long aucId);
    Optional<Bid> findByBidId(Long bidId);
    //List<Bid> findBybid_id(Long bid_id);

}
