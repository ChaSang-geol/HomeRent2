package HomeRent.contract;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import HomeRent.contract.Contract;
import HomeRent.contract.ContractRepository;


@RestController

public class ContractController {

    @Autowired
    ContractRepository contractRepository;

    @GetMapping("/Contracts")
    public ResponseEntity<List<Contract>> getAllContracts(@RequestParam(required = false) String honumber) {
        try {
            List<Contract> contracts = new ArrayList<Contract>();

            if (honumber == null)
                contractRepository.findAll().forEach(contracts::add);
            else
                contractRepository.findByHoNumber(honumber).forEach(contracts::add);

            if (contracts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(contracts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/Contracts/{id}")
    public ResponseEntity<Contract> getContractById(@PathVariable("id") long id) {
        Optional<Contract> ContractData = contractRepository.findById(id);

        if (ContractData.isPresent()) {
            return new ResponseEntity<>(ContractData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/Contracts")
    public ResponseEntity<Contract> createContract(@RequestBody Contract Contract) {
        try {
            Contract _Contract = contractRepository
                    .save(new Contract(Contract.getId(), Contract.getTenant()));
            return new ResponseEntity<>(_Contract, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/Contracts/{id}")
    public ResponseEntity<Contract> updateContract(@PathVariable("id") long id, @RequestBody Contract contract) {
        Optional<Contract> ContractData = contractRepository.findById(id);

        if (ContractData.isPresent()) {
            Contract _Contract = ContractData.get();
            _Contract.setBalance(contract.getBalance());
            _Contract.setBalancePaymentDate(contract.getBalancePaymentDate());
            _Contract.setContractDate(contract.getContractDate());
            _Contract.setContractNumber(contract.getContractNumber());
            _Contract.setContractPeriodEnd(contract.getContractPeriodEnd());
            _Contract.setContractPeriodStart(contract.getContractPeriodStart());
            _Contract.setContractYear(contract.getContractYear());
            _Contract.setDeposit(contract.getDeposit());
            _Contract.setDongNumber(contract.getDongNumber());
            _Contract.setEarnest(contract.getEarnest());
            _Contract.setEarnestPaymentDate(contract.getEarnestPaymentDate());
            _Contract.setHoNumber(contract.getHoNumber());
            _Contract.setMonthlyRent(contract.getMonthlyRent());
            _Contract.setRentalType(contract.getRentalType());
            _Contract.setRentPaymentDate(contract.getRentPaymentDate());
            _Contract.setSecondPayment(contract.getSecondPayment());
            _Contract.setSecondPaymentDate(contract.getSecondPaymentDate());
            _Contract.setSpecialContract(contract.getSpecialContract());

            _Contract.setTenant(contract.getTenant());

            return new ResponseEntity<>(contractRepository.save(_Contract), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/Contracts/{id}")
    public ResponseEntity<HttpStatus> deleteContract(@PathVariable("id") long id) {
        try {
            contractRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/Contracts")
    public ResponseEntity<HttpStatus> deleteAllContracts() {
        try {
            contractRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

    }
 /*
    @GetMapping("/Contracts/published")
    public ResponseEntity<List<Contract>> findByPublished() {
        try {
            List<Contract> Contracts = contractRepository.findByPublished(true);

            if (Contracts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(Contracts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
 */

}