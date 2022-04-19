package auction;

import auction.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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

    @Autowired
    AucPaymentRepository aucPaymentRepository;


    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverBidRegisted_(@Payload Bidden bidden){

        if(bidden.isMe()){

            auctionRepository.findByAucId((bidden.getAucId())).ifPresent(auction->{
                auction.setProc_GUBUN("B");
                auction.setStatus("<입찰> Buyer:" + bidden.getBid_mem_id() + ", 금액:" + bidden.getBid_amount());
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
    public void wheneverBidRegisted2_(@Payload Bidden bidden2){

        if(bidden2.isMe()){
            System.out.println("==========%%%%%%%%%%%%bidden getBidId start=========");
            System.out.println("bidden.getBidId()===>"+bidden2.getBidId());
            bidRepository.findByBidId((bidden2.getBidId())).ifPresent(bid->{
                bid.setBidId2(bidden2.getBidId());
                bidRepository.save(bid);
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
        System.out.println("==========%%%%%%%%%%%%Polishhandler aucRegisterd start=========");
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
        System.out.println("==========%%%%%%%%%%%%Polishhandler beAuctioned start=========");
        //낙찰자/일시/금액 수정
        if(beAuctioned.isMe()){
            System.out.println("getAucId11========"+beAuctioned.getAucId());
            auctionRepository.findByAucId((beAuctioned.getAucId())).ifPresent(auction->{
                System.out.println("==========%%%%%%%%%%%%Polishhandler beAuctioned getAucId start=========");
                //auction.setFinal_bid_mem_id(bidden.getBid_mem_id());
                auction.setBeAuctioned_date(beAuctioned.getBeAuctioned_date()); //임시
                auction.setBuyerId(beAuctioned.getAuctioned_mem_id());
                auction.setBeAuctioned_amount(beAuctioned.getBeAuctioned_amount());
                auction.setStatus("낙찰");
                auction.setProc_GUBUN("S");
                auction.setBeAuctioned_YN_Auc("Y");
                auctionRepository.save(auction);
            });

            bidRepository.findByBidId((beAuctioned.getBidId())).ifPresent(bid->{
                System.out.println("==========%%%%%%%%%%%%Polishhandler beAuctioned findByBidId start=========");
                System.out.println("bidId========"+beAuctioned.getBidId());
                bid.setBeAuctioned_date(beAuctioned.getBeAuctioned_date());
                bid.setBeAuctioned_YN("Y");
                bidRepository.save(bid);
            });

            /*List<Bid> bids = bidRepository..findBybid_id(beAuctioned.getBidId());
            for(Bid bid:bids ){
                bid.setBeAuctioned_date(beAuctioned.getBeAuctioned_date());
                bid.setBeAuctioned_YN("Y");
                bidRepository.save(bid);
            }*/

        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverAucPaymentRegisted_(@Payload AucPaymentRegistered aucPaymentRegistered){

        if(aucPaymentRegistered.isMe()){

            auctionRepository.findByAucId((aucPaymentRegistered.getAucId())).ifPresent(auction->{
                if(aucPaymentRegistered.getPaymentGubun().equals("REQ")){
                    auction.setPaymentReq_YN("Y");
                    auction.setStatus("결제완료");
                    auction.setProc_GUBUN("PE");
                }else if(aucPaymentRegistered.getPaymentGubun().equals("CANCEL")){
                    auction.setStatus("결제취소");
                    auction.setProc_GUBUN("PC");
                    auction.setPaymentReq_YN("C");
                }else if(aucPaymentRegistered.getPaymentGubun().equals("END")){
                    auction.setStatus("판매종료");
                    auction.setProc_GUBUN("E");
                    auction.setPaymentReq_YN("E");
                }
                auctionRepository.save(auction);
            });
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverAucPaymentRegisted2_(@Payload AucPaymentRegistered aucPaymentRegistered2){

        if(aucPaymentRegistered2.isMe()){

            bidRepository.findByBidId((aucPaymentRegistered2.getBidId())).ifPresent(bid->{
                bid.setStatus("판매종료");
                bidRepository.save(bid);
            });
        }
    }


}
