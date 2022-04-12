package auction;

public class Bidden extends AbstractEvent {

    private Long aucId;
    private Long auc_post_id;
    private Long bid_id;
    private Long bid_mem_id;
    private Long bid_amount;
    private String proc_GUBUN;

    public Long getAucId() {
        return aucId;
    }
    public void setAucId(Long aucId) {
        this.aucId = aucId;
    }

    public Long getAuc_post_id() {  return auc_post_id;   }
    public void setAuc_post_id(Long auc_post_id) {     this.auc_post_id = auc_post_id;    }

    public Long getBid_id() {
        return bid_id;
    }
    public void setBid_id(Long bid_id) {
        this.bid_id = bid_id;
    }

    public Long getBid_amount() {
        return bid_amount;
    }
    public void setBid_amount(Long bid_amount) {
        this.bid_amount = bid_amount;
    }

    public Long getBid_mem_id() {
        return bid_mem_id;
    }
    public void setBid_mem_id(Long bid_mem_id) {
        this.bid_mem_id = bid_mem_id;
    }

    public String getProc_GUBUN() {
        return proc_GUBUN;
    }
    public void setProc_GUBUN(String proc_GUBUN) {
        this.proc_GUBUN = proc_GUBUN;
    }
}