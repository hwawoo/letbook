package letbook.external;

public class PaymentServiceFallback {

    public void makePay() {

        System.out.println("Circuit breaker has been opened. Fallback returned instead.");

    }

}

/*

package fooddelivery.external;

lass 결제이력ServiceFallback implements 결제이력Service {
    @Override
    public void 결제(결제이력 주문) {
        //do nothing if you want to forgive it

        System.out.println("Circuit breaker has been opened. Fallback returned instead.");
    }
}
*/