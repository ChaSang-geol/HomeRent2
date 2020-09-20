package HomeRent.user;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class CustomUserService implements UserDetailsService {
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        Optional<User> userEntityWrapper = userRepository.findByUserId(userEmail);
        User userEntity = userEntityWrapper.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        //authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        authorities.add(new SimpleGrantedAuthority(userEntity.getRole().getName()));
        log.debug ("###비밀번호 : " + userEntity.getPassword());
        return new org.springframework.security.core.userdetails.User(userEntity.getUserId(), userEntity.getPassword(), authorities);
    }
}
