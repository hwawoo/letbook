
package letbook.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

//@FeignClient(name="Payment", url="http://Payment:8080")
@FeignClient(name="Payment", url="http://localhost:8084") //, fallback = PaymentServiceFallback.class) // local 환경 테스트
public interface PaymentService {
    @RequestMapping(method= RequestMethod.POST, path="/payments")
    public Payment makePay(@RequestBody Payment payment);

}

