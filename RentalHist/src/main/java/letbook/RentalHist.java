package letbook;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="RentalHist_table")
public class RentalHist {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String renterName;
        private String bookTitle;
        private String cardNo;
        private String rentalResult;
        private Long rentFee;


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

        public String getRentalResult() {
            return rentalResult;
        }
        public void setRentalResult(String rentalResult) {
            this.rentalResult = rentalResult;
        }

        public Long getRentFee() {
            return rentFee;
        }
        public void setRentFee(Long rentFee) {
            this.rentFee = rentFee;
        }

}
