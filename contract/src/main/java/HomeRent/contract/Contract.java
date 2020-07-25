package HomeRent.contract;

import HomeRent.auditing.AuditableUser;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="Contract_table")
public class Contract extends AuditableUser {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    /*
        private Long tenantId;
        private String name;
        private String phoneNumber;
        private String address;
        private String birthDate;
        private String registrationNumber;
    */
    private String contractNumber;
    private String contractYear;
    private String dongNumber;
    private String hoNumber;
    private Date contractDate;
    private String rentalType;
    private Integer deposit;
    private Integer monthlyRent;
    private Date contractPeriodStart;
    private Date contractPeriodEnd;
    private Date earnestPaymentDate;
    private Integer earnest;
    private Integer secondPayment;
    private Date secondPaymentDate;
    private Integer balance;
    private Date balancePaymentDate;
    private String rentPaymentDate;
    private String specialContract;
/*
    private Date createDate;
    private Date updateDate;
    private String createUser;
    private String updateUser;
*/
/*
    @OneToOne(mappedBy = "contract")
    private Tenant tenant;
 */
    @OneToOne
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;

    public Contract() {}
    public Contract(Long id, Tenant tenant) {
        this.id = id;
        this.tenant = tenant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getContractYear() {
        return contractYear;
    }

    public void setContractYear(String contractYear) {
        this.contractYear = contractYear;
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

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    public Integer getDeposit() {
        return deposit;
    }

    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }

    public Integer getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(Integer monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public Date getContractPeriodStart() {
        return contractPeriodStart;
    }

    public void setContractPeriodStart(Date contractPeriodStart) {
        this.contractPeriodStart = contractPeriodStart;
    }

    public Date getContractPeriodEnd() {
        return contractPeriodEnd;
    }

    public void setContractPeriodEnd(Date contractPeriodEnd) {
        this.contractPeriodEnd = contractPeriodEnd;
    }

    public Date getEarnestPaymentDate() {
        return earnestPaymentDate;
    }

    public void setEarnestPaymentDate(Date earnestPaymentDate) {
        this.earnestPaymentDate = earnestPaymentDate;
    }

    public Integer getEarnest() {
        return earnest;
    }

    public void setEarnest(Integer earnest) {
        this.earnest = earnest;
    }

    public Integer getSecondPayment() {
        return secondPayment;
    }

    public void setSecondPayment(Integer secondPayment) {
        this.secondPayment = secondPayment;
    }

    public Date getSecondPaymentDate() {
        return secondPaymentDate;
    }

    public void setSecondPaymentDate(Date secondPaymentDate) {
        this.secondPaymentDate = secondPaymentDate;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Date getBalancePaymentDate() {
        return balancePaymentDate;
    }

    public void setBalancePaymentDate(Date balancePaymentDate) {
        this.balancePaymentDate = balancePaymentDate;
    }

    public String getRentPaymentDate() {
        return rentPaymentDate;
    }

    public void setRentPaymentDate(String rentPaymentDate) {
        this.rentPaymentDate = rentPaymentDate;
    }

    public String getSpecialContract() {
        return specialContract;
    }

    public void setSpecialContract(String specialContract) {
        this.specialContract = specialContract;
    }
/*
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

*/
    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }
}
