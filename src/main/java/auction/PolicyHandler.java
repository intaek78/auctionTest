package auction;

import auction.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @Autowired
    AuctionRepository auctionRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverBidRegisted_(@Payload Bidden bidden){

        if(bidden.isMe()){
            //System.out.println("bidden.getAuc_post_id()===>" + bidden.getAuc_id());
            //Optional<Auction> auctionOptional = auctionRepository.findById(bidden.getAuc_id());
            //Auction auction = auctionOptional.get();//위에서 find한 오더 객체를 찾아서 매핑
            //System.out.println("Auc_post_id===>" + auction.getAuc_post_id());
            //auction.setFinal_bid_mem_id(bidden.getBid_mem_id());
            //auction.setStatus("입찰자:" + bidden.getBid_mem_id() + ", 입찰금액 : " + bidden.getBid_amount() + "원");
            //auctionRepository.save(auction);

            auctionRepository.findByAucId((bidden.getAucId())).ifPresent(auction->{
                //auction.setFinal_bid_mem_id(bidden.getBid_mem_id());
                auction.setFinal_bid_mem_id(Long.valueOf(4444)); //임시
                auction.setStatus("입찰자:" + bidden.getBid_mem_id() + ", 입찰금액 : " + bidden.getBid_amount() + "원");
                auctionRepository.save(auction);
            });


            //List<Auction> auctionOptional = auctionRepository.findByAucId((bidden.getAuc_id()));
            //System.out.println("111111111111 "+published.getMemId());
            //System.out.println("memberOptional "+memberOptional.get(0).getMemId());
            /*for(Auction auction:auctionOptional){
                //System.out.println("2222222222222");
                auction.setFinal_bid_mem_id(bidden.getBid_mem_id());
                auction.setStatus("입찰자:" + bidden.getBid_mem_id() + ", 입찰금액 : " + bidden.getBid_amount() + "원");
                auctionRepository.save(auction);
            }*/



        }
    }

}
