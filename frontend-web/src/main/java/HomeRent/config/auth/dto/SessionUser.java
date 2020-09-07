package HomeRent.config.auth.dto;

import HomeRent.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;
    private String status;

    public SessionUser(User user) {
        this.name = user.getUserName();
        this.email = user.getUserId();
        this.status = user.getUserStatus();
        //this.picture = user.getPicture();
    }
}