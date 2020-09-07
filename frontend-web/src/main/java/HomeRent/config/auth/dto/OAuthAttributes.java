package HomeRent.config.auth.dto;

import HomeRent.user.Role;
import HomeRent.user.RoleRepository;
import HomeRent.user.User;
import HomeRent.user.UserDto;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes,
                           String nameAttributeKey, String name,
                           String email, String picture) {
        this.attributes = attributes;
        this.nameAttributeKey= nameAttributeKey;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    public static OAuthAttributes of(String registrationId,
                                     String userNameAttributeName,
                                     Map<String, Object> attributes) {
        return ofGoogle(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName,
                                            Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .picture((String) attributes.get("picture"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private RoleRepository roleRepository;
    public User toEntity() {
        Role role = new Role();
        role = roleRepository.findByRoleName("ROLE_USER");
        //Long role_id = role.getId();
        return User.builder()
                .userName(name)
                .userId(email)
                //.picture(picture)
                .role(role)
                .userStatus("N")
                .build();
    }
}