package HomeRent.contract;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/v1/contracts")
@Slf4j
@RequiredArgsConstructor
public class ContractAPI {
    private final ContractService contractService;

    @GetMapping
    public ResponseEntity<List<Contract>> findAll() {
        return ResponseEntity.ok(contractService.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Contract contract) {
        return ResponseEntity.ok(contractService.save(contract));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contract> findById(@PathVariable Long id) {
        Optional<Contract> stock = contractService.findById(id);
        if (!stock.isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(stock.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contract> update(@PathVariable Long id, @Valid @RequestBody Contract contract) {
        if (!contractService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(contractService.save(contract));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!contractService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        contractService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
