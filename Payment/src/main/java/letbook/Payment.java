package letbook;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="Payment_table")
public class Payment {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String renterName;
    private String cardNo;
    private String payResult;
    private Long rentFee;
    private Long bookId;
    private String bookTitle;
    private Long rentId;


    @PostPersist
    public void onPostPersist(){

        System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ Payment PostPersist "+System.currentTimeMillis()+"□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
        System.out.println("Payment");

        PayMade payMade = new PayMade();

        this.setPayResult("Pay Made");
        /*
        payMade.setRenterName(this.renterName);
        payMade.setCardNo(this.cardNo);
        payMade.setRentFee(this.rentFee);
        payMade.setBookId(this.bookId);
        payMade.setBookTitle(this.bookTitle);
        payMade.setRentId(this.id);
        */

        BeanUtils.copyProperties(this, payMade);
        payMade.publishAfterCommit();

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getRenterName() {
        return renterName;
    }

    public void setRenterName(String renterName) {
        this.renterName = renterName;
    }
    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
    public String getPayResult() {
        return payResult;
    }

    public void setPayResult(String payResult) {
        this.payResult = payResult;
    }
    public Long getRentFee() {
        return rentFee;
    }

    public void setRentFee(Long rentFee) {
        this.rentFee = rentFee;
    }
    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    public Long getRentId() {
        return rentId;
    }

    public void setRentId(Long rentId) {
        this.rentId = rentId;
    }




}
