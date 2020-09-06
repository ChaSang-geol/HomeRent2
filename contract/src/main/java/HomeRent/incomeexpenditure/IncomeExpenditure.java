package HomeRent.incomeexpenditure;

import HomeRent.auditing.CommonDateEntity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="IncomeExpenditure_table")
public class IncomeExpenditure extends CommonDateEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long Id;
    private String classification;
    private Date occurrenceDate;
    private String correspondent;
    private String summary;
    private Integer amount;
    private String accountSubject;
    private String dongNumber;
    private String hoNumber;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public Date getOccurrenceDate() {
        return occurrenceDate;
    }

    public void setOccurrenceDate(Date occurrenceDate) {
        this.occurrenceDate = occurrenceDate;
    }

    public String getCorrespondent() {
        return correspondent;
    }

    public void setCorrespondent(String correspondent) {
        this.correspondent = correspondent;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getAccountSubject() {
        return accountSubject;
    }

    public void setAccountSubject(String accountSubject) {
        this.accountSubject = accountSubject;
    }

    public String getDongNumber() {
        return dongNumber;
    }

    public void setDongNumber(String dongNumber) {
        this.dongNumber = dongNumber;
    }

    public String getHoNumber() {
        return hoNumber;
    }

    public void setHoNumber(String hoNumber) {
        this.hoNumber = hoNumber;
    }

    public IncomeExpenditure() {}
    public IncomeExpenditure(Long id, String classification, Date occurrenceDate, String correspondent, String summary, Integer amount, String accountSubject, String dongNumber, String hoNumber, Date createDate, Date updateDate, String createUser, String updateUser) {
        this.Id = id;
        this.classification = classification;
        this.occurrenceDate = occurrenceDate;
        this.correspondent = correspondent;
        this.summary = summary;
        this.amount = amount;
        this.accountSubject = accountSubject;
        this.dongNumber = dongNumber;
        this.hoNumber = hoNumber;
    }
}
