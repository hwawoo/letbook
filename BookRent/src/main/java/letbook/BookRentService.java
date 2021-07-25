package letbook;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class BookRentService {

    @Autowired
     BookRentRepository bookRentRepository;

    /*
    @Transactional
    public String bookRentContService(BookRented bookRentedObj) throws Exception {
        System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ bookRentContService start "+System.currentTimeMillis()+"□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");

        try {
            BookRent bookRentObj = new BookRent();

            bookRentObj.setBookId(bookRentedObj.getBookId());
            bookRentObj.setBookTitle(bookRentedObj.getBookTitle());
            bookRentObj.setRentFee(bookRentedObj.getRentFee());
            bookRentObj.setRenterName(bookRentedObj.getRenterName());
            bookRentObj.setCardNo(bookRentedObj.getCardNo());
            bookRentObj.setPayId(bookRentedObj.getPayId());
            bookRentObj.setStatus("Book Rent Req.");

            System.out.println(" book Rent save before ");

            bookRentRepository.save(bookRentObj);

            System.out.println(" book Rent List data all :  " + bookRentRepository.findAll().toString());

            return "BookRent Saved";

        } catch (Exception e) {
            System.out.println("save BookRent Error");
            return "save BookRent Error";
        }

    }

     */

    @Transactional
    public Iterable<BookRent> bookRentListService() throws Exception {

        System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ bookRentList start "+System.currentTimeMillis()+"□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");

        try {
            System.out.println("□□□bookRentRepository.findAll()□□□" + bookRentRepository.findAll());

            return bookRentRepository.findAll();

        } catch (Exception e) {

            System.out.println("BookRentList Error" +e.getStackTrace());

            return null;
        }

    }

    @Transactional
    public String bookReturnedService(BookReturned bookReturnedObj) throws Exception {

        System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ Book Returned Service start "+System.currentTimeMillis()+"□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");

        try {
            Optional<BookRent> tempObj =  bookRentRepository.findById(bookReturnedObj.getId());

            BookRent bookRentObj = new BookRent();

            if(tempObj.isPresent()){
                bookRentObj = tempObj.get();
            }else{
                return "no Book Rent data" ;
            }

            bookRentObj.setStatus("Book Returned");

            bookRentRepository.save(bookRentObj);

            System.out.println(" Book Rent List data all :  " + bookRentRepository.findAll().toString());

            return "Book Returned success";

        } catch (Exception e) {
            return "save Book Returned Error" +e.getStackTrace();
        }

    }

    /*

    @Transactional
    public String bookRentedService(BookRented bookRentedObj) throws Exception {

        System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ Book Rented Service start "+System.currentTimeMillis()+"□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");

        try {
            BookRent bookRentObj = new BookRent();
            //	orderObj.setOrderId(orderPlacedObj.getOrderId());

            orderObj.setStoreId(orderPlacedObj.getStoreId());
            orderObj.setMenuId(orderPlacedObj.getMenuId());
            orderObj.setMenuCount(orderPlacedObj.getMenuCount());
            orderObj.setMenuPrice(orderPlacedObj.getMenuPrice());
            orderObj.setCustomerAddress(orderPlacedObj.getCustomerAddress());
            orderObj.setPhoneNumber(orderPlacedObj.getPhoneNumber());
            orderObj.setCustomerName(orderPlacedObj.getCustomerName());
            orderObj.setCustomerId(orderPlacedObj.getCustomerId());
            orderObj.setOrderStatus("orderPlaced");
            System.out.println(" INput orderObj :  " + orderObj.toString());
            orderRepository.save(orderObj);

            System.out.println(" OrderList data all :  " + orderRepository.findAll().toString());

            return "order success";

        } catch (Exception e) {
            return "save Order Error" +e.getStackTrace() +e.getMessage();
        }
    }//orderPlacedService

    */


}
