package letbook;

import letbook.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class RentalHistViewHandler {


    @Autowired
    private RentalHistRepository rentalHistRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPayMade_then_CREATE_1 (@Payload PayMade payMade) {
        try {

            if (!payMade.validate()) return;

            // view 객체 생성
            RentalHist rentalHist = new RentalHist();
            // view 객체에 이벤트의 Value 를 set 함
            rentalHist.setId(payMade.getId());
            rentalHist.setRenterName(payMade.getRenterName());
            rentalHist.setBookTitle(payMade.getBookTitle());
            rentalHist.setCardNo(payMade.getCardNo());
            rentalHist.setRentalResult(payMade.getPayResult());
            rentalHist.setRentFee(payMade.getRentFee());
            // view 레파지 토리에 save
            rentalHistRepository.save(rentalHist);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenBookExported_then_UPDATE_1(@Payload BookExported bookExported) {
        try {
            if (!bookExported.validate()) return;
                // view 객체 조회
            Optional<RentalHist> rentalHistOptional = rentalHistRepository.findById(bookExported.getId());

            if( rentalHistOptional.isPresent()) {
                 RentalHist rentalHist = rentalHistOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                 rentalHist.setRentalResult(bookExported.getBookStatus());
                // view 레파지 토리에 save
                 rentalHistRepository.save(rentalHist);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenBookImported_then_UPDATE_2(@Payload BookImported bookImported) {
        try {
            if (!bookImported.validate()) return;
            // view 객체 조회
            Optional<RentalHist> rentalHistOptional = rentalHistRepository.findById(bookImported.getPayId());

            if( rentalHistOptional.isPresent()) {
                RentalHist rentalHist = rentalHistOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                rentalHist.setRentalResult(bookImported.getBookStatus());
                // view 레파지 토리에 save
                rentalHistRepository.save(rentalHist);
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

