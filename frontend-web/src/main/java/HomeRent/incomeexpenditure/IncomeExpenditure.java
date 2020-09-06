package HomeRent.incomeexpenditure;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.time.LocalDateTime;

public class IncomeExpenditure {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String classification; // 구분 : 수입/지출
    private Date occurrenceDate; // 발생일
    private String correspondent; // 거래처
    private String summary; // 적요
    private Integer amount; // 금액
    private String accountSubject; // 계정과목
    private String dongNumber; // 동
    private String hoNumber; // 호
    //@CreatedDate // Entity 생성시 자동으로 날짜세팅
    private LocalDateTime createDate;
    //@LastModifiedDate // Entity 수정시 자동으로 날짜세팅
    private LocalDateTime updateDate;

}