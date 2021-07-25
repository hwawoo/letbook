package letbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

 @RestController
 public class BookRentController {

   @Autowired
   BookRentService bookRentService;

   /*
     @RequestMapping(value="/bookRented", method=RequestMethod.POST)
     public String bookRentController(@RequestBody BookRented bookRentedObj) throws Exception {

         System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ Book Rent Controller start "+System.currentTimeMillis()+"□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
         System.out.println("Input bookRentedObj :  " + bookRentedObj.toString());

         return bookRentService.bookRentContService(bookRentedObj);
     }

    */


//   @PutMapping(value="/bookRents/bookReturned/{rentId}")
//   public String bookReturned(@PathVariable(value = "rentId") Long rentId) {
     @RequestMapping(value = "/bookReturned", method = RequestMethod.POST)
     public String bookReturned(@RequestBody BookReturned bookReturnedObj) throws Exception {

     System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□Book Returned Controller start "+System.currentTimeMillis()+"□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
     System.out.println("Input bookReturnedObj :  " + bookReturnedObj.toString());

     return bookRentService.bookReturnedService(bookReturnedObj);
   }

    @RequestMapping(value = "/bookRentList", method = RequestMethod.GET)
    public Iterable<BookRent> bookRentListController() throws Exception {

        System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ Book Rent ListController start "+System.currentTimeMillis()+"□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
        System.out.println("Book Rent List");

        return  bookRentService.bookRentListService();
    }

    /*
     @RequestMapping(value="/bookRents", method=RequestMethod.POST)
     public String BookRented(@RequestBody BookRented bookRentedObj) throws Exception {

         System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ Book Rented Controller start "+System.currentTimeMillis()+"□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
         System.out.println(" Input bookRenteddObj :  " + bookRentedObj.toString());

         return bookRentedService.bookRentedService(bookRentedObj);

     }

     */

 }
