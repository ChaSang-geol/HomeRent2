package HomeRent;

public class ImportsAmountRegistered extends AbstractEvent {

    private Long id;
    private String classification;
    private Date occurrenceDate;
    private String correspondent;
    private String summary;
    private Integer amount;
    private String accountSubject;
    private String dongNumber;
    private String hoNumber;

    public ImportsAmountRegistered(){
        super();
    }

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
}
