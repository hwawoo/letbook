package letbook.external;

public class Payment {

    private Long id;
    private String renterName;
    private String cardNo;
    private String payResult;
    private Long rentFee;
    private Long bookId;
    private String bookTitle;
    private Long rentId;

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
