package HomeRent;

import HomeRent.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ContractmanagementViewHandler {


    @Autowired
    private ContractmanagementRepository contractmanagementRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenContracted_then_CREATE_1 (@Payload Contracted contracted) {
        try {
            if (contracted.isMe()) {
                // view 객체 생성
                Contractmanagement contractmanagement = new Contractmanagement();
                // view 객체에 이벤트의 Value 를 set 함
                contractmanagement.setId(contracted.getId());
                // view 레파지 토리에 save
                contractmanagementRepository.save(contractmanagement);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}