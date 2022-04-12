package auction;

public class AuctionCompleted extends AbstractEvent {

    private Long aucId;
    private Long auc_post_id;
    private String status;
    private Long auctioned_mem_id;
    private Long buyerId;
    private Long sellerId;
    private String proc_GUBUN;
    private String beAuctioned_date;
    private Long beAuctioned_amount;

    public AuctionCompleted(){
        super();
    }

    public Long getAucId() {
        return aucId;
    }
    public void setAucId(Long aucId) {
        this.aucId = aucId;
    }

    public Long getAuc_post_id() {
        return auc_post_id;
    }
    public void setAuc_post_id(Long auc_post_id) {
        this.auc_post_id = auc_post_id;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Long getAuctioned_mem_id() {
        return auctioned_mem_id;
    }
    public void setAuctioned_mem_id(Long auctioned_mem_id) {
        this.auctioned_mem_id = auctioned_mem_id;
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
}