package HomeRent.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private Long userNo;
    private String userId;
    private String password;
    private String userName;
    private String userStatus;
    private Long roleId;
}
