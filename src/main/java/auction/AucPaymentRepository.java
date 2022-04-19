package auction;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel="aucpayments", path="aucpayments")
public interface AucPaymentRepository extends PagingAndSortingRepository<AucPayment, Long>{
    Optional<AucPayment> findByAucId(Long aucId);
    //List<Cancellation> findByMemId(String memId);
    //List<Cancellation> findByMemNo(String memNo);

}
