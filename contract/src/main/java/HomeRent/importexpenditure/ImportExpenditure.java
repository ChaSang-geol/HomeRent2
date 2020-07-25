package HomeRent.importexpenditure;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class ImportExpenditure {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String classification;
    private Date occurrenceDate;
    private String correspondent;
    private String summary;
    private Integer amount;
    private String accountSubject;
    private String dongNumber;
    private String hoNumber;

    private Date createDate;
    private Date updateDate;
    private String createUser;
    private String updateUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public ImportExpenditure(Long id, String classification, Date occurrenceDate, String correspondent, String summary, Integer amount, String accountSubject, String dongNumber, String hoNumber, Date createDate, Date updateDate, String createUser, String updateUser) {
        this.id = id;
        this.classification = classification;
        this.occurrenceDate = occurrenceDate;
        this.correspondent = correspondent;
        this.summary = summary;
        this.amount = amount;
        this.accountSubject = accountSubject;
        this.dongNumber = dongNumber;
        this.hoNumber = hoNumber;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.createUser = createUser;
        this.updateUser = updateUser;
    }
}
