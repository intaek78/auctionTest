package auction;

import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name="Beauction_table")
public class Beauction {

    private Long auc_post_id;
    private Long aucId;
    private Long bidId;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long beauction_id;
    private Long bid_mem_id;
    //private Long beAuctioned_amount;
    private String crt_date;
    private String upt_date;
    private String beAuctioned_date;
    private String beAuctioned_YN;
    private String proc_GUBUN;


    @PostPersist
    public void onPostPersist(){
        System.out.println("==========Beauction PostPersist start==========");
        //낙찰자id 및 낙찰일시 수정
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        BeAuctioned beAuctioned = new BeAuctioned();
        BeanUtils.copyProperties(this, beAuctioned);
        beAuctioned.setStatus("Sold");
        beAuctioned.setAuctioned_mem_id(beAuctioned.getAuctioned_mem_id());
        beAuctioned.setBeAuctioned_date(df.format(cal.getTime()));
        beAuctioned.setBeAuctioned_amount(beAuctioned.getBeAuctioned_amount());
        beAuctioned.setBidId(beAuctioned.getBidId());
        beAuctioned.setProc_GUBUN("S");
        beAuctioned.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate(){

    }

    @PrePersist
    public void onPrePersis(){
        /*try {
            Thread.currentThread().sleep((long) (400 + Math.random() * 220));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
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

    public Long getBeauction_id() {
        return beauction_id;
    }
    public void setBeauction_id(Long beauction_id) {
        this.beauction_id = beauction_id;
    }

    public Long getBid_mem_id() {
        return bid_mem_id;
    }
    public void setBid_mem_id(Long bid_mem_id) {
        this.bid_mem_id = bid_mem_id;
    }

    //public Long getBeAuctioned_amount() {        return beAuctioned_amount;     }
    //public void setBeAuctioned_amount(Long beAuctioned_amount) {         this.beAuctioned_amount = beAuctioned_amount;     }

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

    public String getBeAuctioned_date() {
        return beAuctioned_date;
    }
    public void setBeAuctioned_date(String beAuctioned_date) {
        this.beAuctioned_date = beAuctioned_date;
    }

    public String getBeAuctioned_YN() {
        return beAuctioned_YN;
    }
    public void setBeAuctioned_YN(String beAuctioned_YN) {
        this.beAuctioned_YN = beAuctioned_YN;
    }

    public String getProc_GUBUN() {
        return proc_GUBUN;
    }
    public void setProc_GUBUN(String proc_GUBUN) {
        this.proc_GUBUN = proc_GUBUN;
    }




}
