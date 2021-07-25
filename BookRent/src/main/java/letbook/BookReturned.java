package letbook;

public class BookReturned extends AbstractEvent {

    private Long id;
    private String renterName;
    private String bookTitle;
    private String cardNo;
    private Long bookId;
    private Long payId;
    private Long rentFee;

    public BookReturned(){
        super();
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
}
