package HomeRent.contract;



import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

@RequiredArgsConstructor
public class ContractService {
    private final ContractRepository contractRepository;
/*
    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

 */
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    public Optional<Contract> findById(Long id) {
        return contractRepository.findById(id);
    }

    public Contract save(Contract stock) {
        return contractRepository.save(stock);
    }

    public void deleteById(Long id) {
        contractRepository.deleteById(id);
    }
}