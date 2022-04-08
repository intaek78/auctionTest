package auction;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel="auctions", path="auctions")
public interface AuctionRepository extends PagingAndSortingRepository<Auction, Long>{
    Optional<Auction> findByAucId(Long aucId);
    //List<Auction> findByAucId(Long memId);
//
    //Optional<Item> findByPetId(Long petId); // select * from item where petId=<petId>
}
