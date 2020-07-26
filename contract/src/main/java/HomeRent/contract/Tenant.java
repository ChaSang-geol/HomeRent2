package HomeRent.contract;

import HomeRent.auditing.AuditableUser;
import HomeRent.auditing.CommonDateEntity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="Tenant_table")
public class Tenant extends CommonDateEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String phoneNumber;
    private String address;
    private String birthDate;
    private String registrationNumber;
/*
    private Date createDate;
    private Date updateDate;
    private String createUser;
    private String updateUser;
 */
/*
    @OneToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;
*/
    @OneToOne(mappedBy = "tenant")
    private Contract contract;

    public Tenant() {}
    public Tenant(Long id, Contract contract) {
        this.id = id;
        this.contract = contract;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
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
    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
