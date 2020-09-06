package HomeRent.contract;

import HomeRent.auditing.CommonDateEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConstructorBinding;

import javax.persistence.*;
import java.sql.Date;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Contract_table")
public class Contract extends CommonDateEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long Id;
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
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)//
    private Tenant tenant;
    Contract() {}

}
