package HomeRent.user;

import lombok.Data;

@Data
public class UserDto {

    private Long userNo;
    private String userId;
    private String password;
    private String userName;
    private String userStatus;
    private Long roleId;
}
