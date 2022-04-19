package auction;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name="Auction_table")
public class Auction {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long aucId;
    private Long aucId2;
    private Long auc_post_id;
    private String title;
    private String content;
    private String status;
    private Long auc_start_amount;
    private String pay_mth;
    private String crt_date;
    private String upt_date;
    private Long buyerId;
    private Long sellerId;
    private String proc_GUBUN;
    private String beAuctioned_date;
    private Long beAuctioned_amount;

    private String beAuctioned_YN_Auc;

    private String paymentReq_YN;

    @PrePersist
    public void onPrePersist(){
        proc_GUBUN = "R";
    }


    @PostPersist
    public void onPostPersist(){
        AucRegisterd aucRegisterd = new AucRegisterd();
        BeanUtils.copyProperties(this, aucRegisterd);
        aucRegisterd.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate(){
        //경매취소/완료 처리
        AuctionCancelled auctionCancelled = new AuctionCancelled();
        BeanUtils.copyProperties(this, auctionCancelled);

        AuctionCompleted auctionCompleted = new AuctionCompleted();
        BeanUtils.copyProperties(this, auctionCompleted);
        System.out.println("this.proc_GUBUN====>"+this.proc_GUBUN);
        if (this.proc_GUBUN.equals("C")) {
            auctionCancelled.publishAfterCommit();
        }else if(this.proc_GUBUN.equals("E")){
            auctionCompleted.publishAfterCommit();
        }

    }

    @PreRemove
    public void onPreRemove(){
        AuctionCancelled auctionCancelled = new AuctionCancelled();
        BeanUtils.copyProperties(this, auctionCancelled);
        auctionCancelled.publishAfterCommit();
    }


    public Long getAucId() {
        return aucId;
    }
    public void setAucId(Long aucId) {
        this.aucId = aucId;
    }

    public Long getAucId2() {
        return aucId2;
    }
    public void setAucId2(Long aucId2) {
        this.aucId2 = aucId2;
    }

    public Long getAuc_post_id() {
        return auc_post_id;
    }
    public void setAuc_post_id(Long auc_post_id) {
        this.auc_post_id = auc_post_id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Long getAuc_start_amount() {
        return auc_start_amount;
    }
    public void setAuc_start_amount(Long auc_start_amount) {
        this.auc_start_amount = auc_start_amount;
    }

    public String getPay_mth() {
        return pay_mth;
    }
    public void setPay_mth(String pay_mth) {
        this.pay_mth = pay_mth;
    }

    public String getCrt_date() {
        return crt_date;
    }
    public void setCrt_date(String crt_date) {
        this.crt_date = crt_date;
    }

    public String getUpt_date() {
        return upt_date;
    }
    public void setUpt_date(String upt_date) {
        this.upt_date = upt_date;
    }

    public Long getBuyerId() {
        return buyerId;
    }
    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Long getSellerId() {
        return sellerId;
    }
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getProc_GUBUN() {
        return proc_GUBUN;
    }
    public void setProc_GUBUN(String proc_GUBUN) {
        this.proc_GUBUN = proc_GUBUN;
    }

    public String getBeAuctioned_date() {
        return beAuctioned_date;
    }
    public void setBeAuctioned_date(String beAuctioned_date) {
        this.beAuctioned_date = beAuctioned_date;
    }

    public Long getBeAuctioned_amount() {
        return beAuctioned_amount;
    }
    public void setBeAuctioned_amount(Long beAuctioned_amount) {
        this.beAuctioned_amount = beAuctioned_amount;
    }

    public String getBeAuctioned_YN_Auc() {
        return beAuctioned_YN_Auc;
    }
    public void setBeAuctioned_YN_Auc(String beAuctioned_YN_Auc) {
        this.beAuctioned_YN_Auc = beAuctioned_YN_Auc;
    }

    public String getPaymentReq_YN() {
        return paymentReq_YN;
    }
    public void setPaymentReq_YN(String paymentReq_YN) {
        this.paymentReq_YN = paymentReq_YN;
    }





}
