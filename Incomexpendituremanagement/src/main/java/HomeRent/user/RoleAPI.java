package HomeRent.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class RoleAPI {

    private final RoleRepository roleRepository;

    public RoleAPI(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @GetMapping("roles")
    public List<Role> list() {
        return roleRepository.findAll();
    }

    @PostMapping("roles")
    public Role save(@RequestBody Role role) {
        return roleRepository.save(role);
    }

    @DeleteMapping("roles/{id}")
    public void delete(@PathVariable Long id) {
        roleRepository.deleteById(id);
    }
}