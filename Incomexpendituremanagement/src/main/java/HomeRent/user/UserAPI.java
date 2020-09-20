package HomeRent.user;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@RequiredArgsConstructor
public class UserAPI {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Value("${my.test.encValue:}")
    private String testValue;

    @GetMapping
    public Flux<User> getAllUsers() {

        return
                Flux.defer(() -> Flux.fromIterable(userRepository.findAll()))
                        .subscribeOn(Schedulers.elastic())
                ;
    }

    @GetMapping(path = "/{userId}")
    public Mono<User> getUser(@PathVariable String userId) {
        return
                Mono.defer(() -> userRepository.findByUserId(userId).map(Mono::just).orElseGet(Mono::empty))
                        .subscribeOn(Schedulers.elastic())
                        .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not Found user for " + userId)))
                ;
    }

    @PostMapping
    public User save(@RequestBody @NotNull UserDto userDto) {
        Optional<Role> role = roleRepository.findById(userDto.getRoleId());

        if (role.isPresent()) {
            User user = new User();
            if (userDto.getUserNo() != null) {
                user.setUserNo(userDto.getUserNo());
                if (userDto.getPassword() != null) {
                    user.setPassword(userDto.getPassword());
                } else { // 비번입력값이 null 이면
                    user.setPassword(userRepository.findById(userDto.getUserNo()).get().getPassword());
                }
            } else { // 수정일 때
                user.setPassword(userDto.getPassword());
            }
            user.setUserId(userDto.getUserId());
            
            user.setUserName(userDto.getUserName());
            user.setUserStatus(userDto.getUserStatus());
            user.setRole(role.get());

            return userRepository.save(user);
        }

        return null;
    }

    @DeleteMapping("/{userNo}")
    public void delete(@PathVariable Long userNo) {
        userRepository.deleteById(userNo);
    }

    @GetMapping(path = "/encValue")
    public Mono<String> getEncValue() {
        return
                Mono.just(testValue);
    }

}
