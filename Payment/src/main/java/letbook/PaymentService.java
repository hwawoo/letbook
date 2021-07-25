package letbook;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Transactional
    public Payment payMadeService(PayMade payMadeObj) throws Exception {

        System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ payment Service start "+System.currentTimeMillis()+"□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");



        try {
            Payment paymentObj = new Payment();

/*
            try {
                System.out.println("\n\n\n\n\n\nWAITINGWAITINGWAITINGWAITINGWAITINGWAITINGWAITINGWAITINGWAITINGWAITINGWAITINGWAITINGWAITING");

                Thread.currentThread().sleep((long) (400 + Math.random() * 220));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

*/


            paymentObj.setRenterName(payMadeObj.getRenterName());
            paymentObj.setCardNo(payMadeObj.getCardNo());
            paymentObj.setRentFee(payMadeObj.getRentFee());
            paymentObj.setBookId(payMadeObj.getBookId());
            paymentObj.setBookTitle(payMadeObj.getBookTitle());
            paymentObj.setRentId(payMadeObj.getId());
            paymentObj.setPayResult("Pay Made");

            System.out.println(" Input paymentObj :  " + paymentObj.toString());

            paymentRepository.save(paymentObj);

            System.out.println("Payment saved.");

            //System.out.println(" Payment data all :  " + paymentRepository.findAll().toString());

            //return "Payment success";

            return paymentObj;

        } catch (Exception e) {
            System.out.println("save Payment Error" +e.getStackTrace() +e.getMessage());
            return null;
        }

    }

    @Transactional
    public Iterable<Payment> paymentListService() throws Exception {

        System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ payment List start "+System.currentTimeMillis()+"□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");

        try {
            System.out.println("□□□payment Repository.findAll()□□□" + paymentRepository.findAll());

            return paymentRepository.findAll();

        } catch (Exception e) {

            System.out.println("Payment List Error" +e.getStackTrace());

            return null;
        }

    }

}
