package auction;

public class AucPaymentRegistered extends AbstractEvent {

    private Long aucId;
    private Long bidId;
    private Long auc_post_id;
    private String status;
    private Long auctioned_mem_id;
    private String beAuctioned_date;
    private Long beAuctioned_amount;
    private String proc_GUBUN;

    private String paymentReq_YN;
    private String paymentGubun;





    public AucPaymentRegistered(){
        super();
    }

    public Long getAucId() {
        return aucId;
    }
    public void setAucId(Long aucId) {
        this.aucId = aucId;
    }

    public Long getBidId() {
        return bidId;
    }
    public void setBidId(Long bidId) {
        this.bidId = bidId;
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

    public String getProc_GUBUN() {
        return proc_GUBUN;
    }
    public void setProc_GUBUN(String proc_GUBUN) {
        this.proc_GUBUN = proc_GUBUN;
    }

    public String getPaymentReq_YN() {
        return paymentReq_YN;
    }
    public void setPaymentReq_YN(String paymentReq_YN) {
        this.paymentReq_YN = paymentReq_YN;
    }

    public String getPaymentGubun() {
        return paymentGubun;
    }
    public void setPaymentGubun(String paymentGubun) {
        this.paymentGubun = paymentGubun;
    }
}