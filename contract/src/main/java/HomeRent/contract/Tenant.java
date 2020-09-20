package HomeRent.contract;

import HomeRent.util.AttributeEncryptor;
//import HomeRent.util.StringEncryptConverter;
//import com.fasterxml.jackson.annotation.JsonIgnore;
import HomeRent.util.CryptoStringConverter;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Tenant_table")
//@ToString(exclude = {"phoneNumber", "birthDate", "registrationNumber"}) // toString 처리에서 제외할 때
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String name;

    @Convert(converter = CryptoStringConverter.class) // 해당 attribute를 Seed로 암호화
    private String phoneNumber;
    private String address;

    @Convert(converter = CryptoStringConverter.class)
    private String birthDate;

    @Convert(converter = CryptoStringConverter.class)
    private String registrationNumber;

}
