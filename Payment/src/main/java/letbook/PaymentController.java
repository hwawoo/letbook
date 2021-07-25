package letbook;

import java.util.Date;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.BeanUtils;
import java.util.List;

 @RestController
 public class PaymentController {

  @Autowired
  private PaymentService paymentService;

  @RequestMapping(value="/payments", method=RequestMethod.POST)
  public Payment makepay (@RequestBody PayMade payMadeObj) throws Exception {

   System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ Payment Controller "+System.currentTimeMillis()+"□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
   System.out.println("Payment POST Controller");
   System.out.println(" Input paymentObj: " + payMadeObj.toString());

   return paymentService.payMadeService(payMadeObj);

   //payment.setPayResult("Pay Made");
   //System.out.println("PayResult:"+payment.getPayResult());
   //paymentRepository.save(payment);

   /*
   PayMade payMade = new PayMade();

   BeanUtils.copyProperties(payment, payMade);
   payMade.publishAfterCommit();
   */

  }


  @RequestMapping(value = "/paymentList", method = RequestMethod.GET)
  public Iterable<Payment> paymentListController() throws Exception {

   System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ Payment ListController start "+System.currentTimeMillis()+"□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
   System.out.println("Payment List");

   return  paymentService.paymentListService();
  }

  /*
  @RequestMapping(method=RequestMethod.GET, path="/getpayments")
  public void getPayment (@RequestBody Payment payment) {

   System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ Payment Controller "+System.currentTimeMillis()+"□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
   System.out.println("Payment GET Controller");

  }


   */


 }
