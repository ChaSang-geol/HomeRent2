package HomeRent.contract;

import HomeRent.auditing.AuditableUser;
import HomeRent.auditing.CommonDateEntity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="Tenant_table")
public class Tenant {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long Id;
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
    @JoinColumn(name = "contractId")
    private Contract contract;

    @OneToOne(mappedBy = "tenant")
    private Contract contract;
*/
    public Tenant() {}

    public Tenant(Long id, String name, String phoneNumber, String address, String birthDate, String registrationNumber//, Contract contract
    ) {
        this.Id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.birthDate = birthDate;
        this.registrationNumber = registrationNumber;
       // this.contract = contract;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
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

}
