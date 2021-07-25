package letbook;

import java.util.Optional;

import letbook.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired
    private BookStoreRepository bookStoreRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPayMade_BookExport(@Payload PayMade payMade){

       if(!payMade.validate()) return;

       // if(payMad.isMe()) {

            System.out.println("\n\n##### listener BookExport : " + payMade.toJson() + "\n\n");

            BookStore bookStore = new BookStore();

            bookStore.setBookId(payMade.getBookId());
            bookStore.setBookGenre("Novel");
            bookStore.setBookName(payMade.getBookTitle());
            bookStore.setPayId(payMade.getRentId());
            bookStore.setBookStatus("Book Rented");

            bookStoreRepository.save(bookStore);

       // }

        // Sample Logic //
        // BookStore bookStore = new BookStore();
        // bookStoreRepository.save(bookStore);

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverBookReturned_BookImport(@Payload BookReturned bookReturned){

        if(!bookReturned.validate()) return;

        System.out.println("\n\n##### listener BookImport : " + bookReturned.toJson() + "\n\n");

        try {

            Optional<BookStore> bookStore = bookStoreRepository.findByBookId(bookReturned.getBookId());

            //BookStore bookStore = new BookStore();

            bookStore.get().setBookStatus("Book Ready");

            bookStoreRepository.save(bookStore.get());

        } catch (Exception e) {
            e.printStackTrace();
        }


        // Sample Logic //
        // BookStore bookStore = new BookStore();
        // bookStoreRepository.save(bookStore);

    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
