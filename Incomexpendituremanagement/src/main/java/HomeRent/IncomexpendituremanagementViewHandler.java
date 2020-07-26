package HomeRent;

import HomeRent.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class IncomexpendituremanagementViewHandler {


    @Autowired
    private IncomexpendituremanagementRepository IncomexpendituremanagementRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenImportsAmountRegistered_then_CREATE_1 (@Payload IncomsAmountRegistered incomsAmountRegistered) {
        try {
            if (incomsAmountRegistered.isMe()) {
                // view 객체 생성
                Incomexpendituremanagement Incomexpendituremanagement = new Incomexpendituremanagement();
                // view 객체에 이벤트의 Value 를 set 함
                Incomexpendituremanagement.setDongNumber(incomsAmountRegistered.getDongNumber());
                Incomexpendituremanagement.setHoNumber(incomsAmountRegistered.getHoNumber());
                Incomexpendituremanagement.setClassification(incomsAmountRegistered.getClassification());
                Incomexpendituremanagement.setOccurrenceDate(incomsAmountRegistered.getOccurrenceDate());
                Incomexpendituremanagement.setCorrespondent(incomsAmountRegistered.getCorrespondent());
                Incomexpendituremanagement.setSummary(incomsAmountRegistered.getSummary());
                Incomexpendituremanagement.setAmount(incomsAmountRegistered.getAmount());
                Incomexpendituremanagement.setAccountSubject(incomsAmountRegistered.getAccountSubject());
                // view 레파지 토리에 save
                IncomexpendituremanagementRepository.save(Incomexpendituremanagement);
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
                Incomexpendituremanagement Incomexpendituremanagement = new Incomexpendituremanagement();
                // view 객체에 이벤트의 Value 를 set 함
                Incomexpendituremanagement.setDongNumber(expenseAmountRegistered.getDongNumber());
                Incomexpendituremanagement.setHoNumber(expenseAmountRegistered.getHoNumber());
                Incomexpendituremanagement.setClassification(expenseAmountRegistered.getClassification());
                Incomexpendituremanagement.setOccurrenceDate(expenseAmountRegistered.getOccurrenceDate());
                Incomexpendituremanagement.setCorrespondent(expenseAmountRegistered.getCorrespondent());
                Incomexpendituremanagement.setSummary(expenseAmountRegistered.getSummary());
                Incomexpendituremanagement.setAmount(expenseAmountRegistered.getAmount());
                Incomexpendituremanagement.setAccountSubject(expenseAmountRegistered.getAccountSubject());
                // view 레파지 토리에 save
                IncomexpendituremanagementRepository.save(Incomexpendituremanagement);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}