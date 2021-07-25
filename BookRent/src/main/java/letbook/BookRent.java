package letbook;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name="BookRent_table")
public class BookRent {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String renterName;
    private String bookTitle;
    private String cardNo;
    private Long bookId;
    private Long payId;
    private Long rentFee;
    private String status;

    @PostPersist
    public void onPostPersist(){

        BookRented bookRented = new BookRented();


        bookRented.setBookId(this.bookId);
        bookRented.setBookTitle(this.bookTitle);
        bookRented.setCardNo(this.cardNo);
        bookRented.setRenterName(this.renterName);
        bookRented.setRentFee(this.rentFee);

        System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ Book Rent PostPersist "+System.currentTimeMillis()+"□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
        System.out.println("Book Rent");

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        letbook.external.Payment payment = new letbook.external.Payment();
        // mappings goes here

        payment.setRentId(this.id);
        payment.setRenterName(this.renterName);
        payment.setCardNo(this.cardNo);
        payment.setPayResult("Pay Req.");
        payment.setRentFee(this.rentFee);
        payment.setBookId(this.bookId);
        payment.setBookTitle(this.bookTitle);

        this.setStatus("Book Rent");


        //payment = BookRentApplication.applicationContext.getBean(letbook.external.PaymentService.class)
        //    .makePay(bookRented);

        payment = BookRentApplication.applicationContext.getBean(letbook.external.PaymentService.class)
                .makePay(payment);

        System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ RES RES Payment "+System.currentTimeMillis()+"□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
        System.out.println("RES RES Payment:  " +payment.toString());

        this.setPayId(payment.getId());
        this.setStatus("Book RentFee Paid");

        System.out.println("this Pay Id: "+this.getPayId());
        System.out.println("payment ID: "+this.getStatus());



        BeanUtils.copyProperties(this, bookRented);
        bookRented.publishAfterCommit();

        System.out.println("BookRent Published");


    }

    @PostUpdate
    public void onPostUpdate(){

        System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ Book Rent PostUpdate "+System.currentTimeMillis()+"□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");

        BookReturned bookReturned = new BookReturned();

        this.setStatus("Book Returned");

        BeanUtils.copyProperties(this, bookReturned);
        bookReturned.publishAfterCommit();

        /*
        try {
            Optional<BookRent> tempObj = BookRentRepository.findByRentId(this.getId());

            BookRent bookRentObj = new BookRent();

            if (tempObj.isPresent()) {

                System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ find book rent " + System.currentTimeMillis() + "□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");

                bookRentObj = tempObj.get();
                bookRentObj.setStatus(this.status);
                BookRentRepository.save(bookRentObj);

                System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ Book Rent saved " + System.currentTimeMillis() + "□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");

                BookReturned bookReturned = new BookReturned();

                System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ book returned publish " + System.currentTimeMillis() + "□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");

                BeanUtils.copyProperties(bookRentObj, bookReturned);
                bookReturned.publishAfterCommit();

            } else {
                return "no Book Rent data";
            }

 */



    }

    /*
    @PostUpdate
    public void onPostUpdate(){
        if(this.status.equals("RETURNED")) {
            BikeReturned bikeReturned = new BikeReturned();
            BeanUtils.copyProperties(this, bikeReturned);
            bikeReturned.publishAfterCommit();
        }

    }

     */


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
    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
    public Long getPayId() {
        return payId;
    }

    public void setPayId(Long payId) {
        this.payId = payId;
    }
    public Long getRentFee() {
        return rentFee;
    }

    public void setRentFee(Long rentFee) {
        this.rentFee = rentFee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}
