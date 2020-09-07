package HomeRent.user;

import HomeRent.util.StringEncryptConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "user")
@Data
@ToString(exclude = {"password"})
@EqualsAndHashCode(of = {"userId"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo;

    private String userId;

    @JsonIgnore
    @Convert(converter = StringEncryptConverter.class)
    private String password;

    private String userName;
    private String userStatus;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public User update(String userName) {
        this.userName = userName;

        return this;
    }



}