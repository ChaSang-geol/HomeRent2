package HomeRent.contract;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(as = Contract.class)
//@Entity
//@Table(name="Contract_table")
public class Contract {
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

    @CreatedDate // Entity 생성시 자동으로 날짜세팅
    private LocalDateTime createDate;
    @LastModifiedDate // Entity 수정시 자동으로 날짜세팅
    private LocalDateTime updateDate;
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
