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

    @Autowired
    BidRepository bidRepository;

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
                auction.setProc_GUBUN("B");
                auction.setStatus("Bid ID:" + bidden.getBid_mem_id() + ", Bid Amount(won) : " + bidden.getBid_amount());
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



    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverAucRegistered_(@Payload AucRegisterd aucRegisterd) {

        if (aucRegisterd.isMe()) {
            auctionRepository.findByAucId((aucRegisterd.getAucId())).ifPresent(auction -> {
                //auction.setFinal_bid_mem_id(bidden.getBid_mem_id());
                auction.setAucId2(aucRegisterd.getAucId()); //임시
                auctionRepository.save(auction);
            });

        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverBeAuctioned_(@Payload BeAuctioned beAuctioned){
        //낙찰자/일시/금액 수정
        if(beAuctioned.isMe()){
            auctionRepository.findByAucId((beAuctioned.getAucId())).ifPresent(auction->{
                //auction.setFinal_bid_mem_id(bidden.getBid_mem_id());
                auction.setBeAuctioned_date(beAuctioned.getBeAuctioned_date()); //임시
                auction.setBuyerId(beAuctioned.getAuctioned_mem_id());
                auction.setBeAuctioned_amount(beAuctioned.getBeAuctioned_amount());
                auction.setStatus("SOLD");
                auction.setProc_GUBUN("S");
                auctionRepository.save(auction);
            });
        }
    }


}
