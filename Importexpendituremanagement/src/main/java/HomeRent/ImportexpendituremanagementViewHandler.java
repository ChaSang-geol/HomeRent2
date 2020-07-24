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
public class ImportexpendituremanagementViewHandler {


    @Autowired
    private ImportexpendituremanagementRepository importexpendituremanagementRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenImportsAmountRegistered_then_CREATE_1 (@Payload ImportsAmountRegistered importsAmountRegistered) {
        try {
            if (importsAmountRegistered.isMe()) {
                // view 객체 생성
                Importexpendituremanagement importexpendituremanagement = new Importexpendituremanagement();
                // view 객체에 이벤트의 Value 를 set 함
                importexpendituremanagement.setDongNumber(importsAmountRegistered.getDongNumber());
                importexpendituremanagement.setHoNumber(importsAmountRegistered.getHoNumber());
                importexpendituremanagement.setClassification(importsAmountRegistered.getClassification());
                importexpendituremanagement.setOccurrenceDate(importsAmountRegistered.getOccurrenceDate());
                importexpendituremanagement.setCorrespondent(importsAmountRegistered.getCorrespondent());
                importexpendituremanagement.setSummary(importsAmountRegistered.getSummary());
                importexpendituremanagement.setAmount(importsAmountRegistered.getAmount());
                importexpendituremanagement.setAccountSubject(importsAmountRegistered.getAccountSubject());
                // view 레파지 토리에 save
                importexpendituremanagementRepository.save(importexpendituremanagement);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenExpenseAmountRegistered_then_CREATE_2 (@Payload ExpenseAmountRegistered expenseAmountRegistered) {
        try {
            if (expenseAmountRegistered.isMe()) {
                // view 객체 생성
                Importexpendituremanagement importexpendituremanagement = new Importexpendituremanagement();
                // view 객체에 이벤트의 Value 를 set 함
                importexpendituremanagement.setDongNumber(expenseAmountRegistered.getDongNumber());
                importexpendituremanagement.setHoNumber(expenseAmountRegistered.getHoNumber());
                importexpendituremanagement.setClassification(expenseAmountRegistered.getClassification());
                importexpendituremanagement.setOccurrenceDate(expenseAmountRegistered.getOccurrenceDate());
                importexpendituremanagement.setCorrespondent(expenseAmountRegistered.getCorrespondent());
                importexpendituremanagement.setSummary(expenseAmountRegistered.getSummary());
                importexpendituremanagement.setAmount(expenseAmountRegistered.getAmount());
                importexpendituremanagement.setAccountSubject(expenseAmountRegistered.getAccountSubject());
                // view 레파지 토리에 save
                importexpendituremanagementRepository.save(importexpendituremanagement);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}