package auction;

import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name="Bid_table")
public class Bid{

    private Long auc_post_id;
    private Long aucId;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long bid_id;
    private Long bid_mem_id;
    private Long bid_amount;
    private String crt_date;
    private String upt_date;
    private String beAuctioned_date;
    private String beAuctioned_YN;
    private String proc_GUBUN;


    @PostPersist
    public void onPostPersist(){
        Bidden bidden = new Bidden();
        BeanUtils.copyProperties(this, bidden);
        //System.out.println("%%%%%%%%%%%%bidAmounted mem id =>"+bidAmounted.getMemId());
        //System.out.println("%%%%%%%%%%%%bidAmounted withdrawdate =>"+bidAmounted.getWithdrawDate());
        bidden.setBid_id(this.bid_mem_id);
        bidden.publishAfterCommit();

    }

    @PostUpdate
    public void onPostUpdate(){

        //낙찰자id 및 낙찰일시 수정
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        BeAuctioned beAuctioned = new BeAuctioned();
        BeanUtils.copyProperties(this, beAuctioned);
        beAuctioned.setStatus("Sold");
        beAuctioned.setAuctioned_mem_id(this.bid_mem_id);
        beAuctioned.setBeAuctioned_date(df.format(cal.getTime()));
        beAuctioned.setBeAuctioned_amount(this.getBid_amount());
        beAuctioned.setProc_GUBUN("S");
        beAuctioned.publishAfterCommit();
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

    public Long getAuc_post_id() {
        return auc_post_id;
    }
    public void setAuc_post_id(Long auc_post_id) {
        this.auc_post_id = auc_post_id;
    }

    public Long getBid_id() {
        return bid_id;
    }
    public void setBid_id(Long bid_id) {
        this.bid_id = bid_id;
    }

    public Long getBid_mem_id() {
        return bid_mem_id;
    }
    public void setBid_mem_id(Long bid_mem_id) {
        this.bid_mem_id = bid_mem_id;
    }

    public Long getBid_amount() {
        return bid_amount;
    }
    public void setBid_amount(Long bid_amount) {
        this.bid_amount = bid_amount;
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
