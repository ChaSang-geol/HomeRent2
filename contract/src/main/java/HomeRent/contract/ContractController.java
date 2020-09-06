package HomeRent.contract;

import java.sql.Date;
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
@RequestMapping("/v2/contracts")
public class ContractController {

    @Autowired
    ContractRepository contractRepository;

    @GetMapping
    public ResponseEntity<List<Contract>> getAllContracts(@RequestParam(required = false) String hoNumber) {
        try {
            List<Contract> contracts = new ArrayList<Contract>();

            if (hoNumber == null)
                contractRepository.findAll().forEach(contracts::add);
            else
                contractRepository.findByHoNumber(hoNumber).forEach(contracts::add);

            if (contracts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(contracts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contract> getContractById(@PathVariable("id") long id) {
        Optional<Contract> ContractData = contractRepository.findById(id);

        if (ContractData.isPresent()) {
            return new ResponseEntity<>(ContractData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Contract> createContract(@RequestBody Contract contract) {
        try {
            Contract _Contract = contractRepository
                    .save(new Contract(getContract(contract).getId(),
                            //contract.getId(),
                            getContract(contract).getContractNumber(),
                            getContract(contract).getContractYear(),
                            getContract(contract).getDongNumber(),
                            getContract(contract).getHoNumber(),
                            getContract(contract).getContractDate(),
                            getContract(contract).getRentalType(),
                            getContract(contract).getDeposit(),
                            getContract(contract).getMonthlyRent(),
                            getContract(contract).getContractPeriodStart(),
                            getContract(contract).getContractPeriodEnd(),
                            getContract(contract).getEarnestPaymentDate(),
                            getContract(contract).getEarnest(),
                            getContract(contract).getSecondPayment(),
                            getContract(contract).getSecondPaymentDate(),
                            getContract(contract).getBalance(),
                            getContract(contract).getBalancePaymentDate(),
                            getContract(contract).getRentPaymentDate(),
                            getContract(contract).getSpecialContract(),
                            getContract(contract).getTenant()
                            )
                    );



            return new ResponseEntity<>(getContract(_Contract), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    private Contract getContract(@RequestBody Contract contract) {
        return contract;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contract> updateContract(@PathVariable("id") long id, @RequestBody Contract contract) {
        Optional<Contract> ContractData = contractRepository.findById(id);

        if (ContractData.isPresent()) {
            Contract _Contract = ContractData.get();
            getContract(_Contract).setBalance(getContract(contract).getBalance());
            getContract(_Contract).setBalancePaymentDate(getContract(contract).getBalancePaymentDate());
            getContract(_Contract).setContractDate(getContract(contract).getContractDate());
            getContract(_Contract).setContractNumber(getContract(contract).getContractNumber());
            getContract(_Contract).setContractPeriodEnd(getContract(contract).getContractPeriodEnd());
            getContract(_Contract).setContractPeriodStart(getContract(contract).getContractPeriodStart());
            getContract(_Contract).setContractYear(getContract(contract).getContractYear());
            getContract(_Contract).setDeposit(getContract(contract).getDeposit());
            getContract(_Contract).setDongNumber(getContract(contract).getDongNumber());
            getContract(_Contract).setEarnest(getContract(contract).getEarnest());
            getContract(_Contract).setEarnestPaymentDate(getContract(contract).getEarnestPaymentDate());
            getContract(_Contract).setHoNumber(getContract(contract).getHoNumber());
            getContract(_Contract).setMonthlyRent(getContract(contract).getMonthlyRent());
            getContract(_Contract).setRentalType(getContract(contract).getRentalType());
            getContract(_Contract).setRentPaymentDate(getContract(contract).getRentPaymentDate());
            getContract(_Contract).setSecondPayment(getContract(contract).getSecondPayment());
            getContract(_Contract).setSecondPaymentDate(getContract(contract).getSecondPaymentDate());
            getContract(_Contract).setSpecialContract(getContract(contract).getSpecialContract());

            //_Contract.setTenant(contract.getTenant());

            return new ResponseEntity<>(contractRepository.save(getContract(_Contract)), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteContract(@PathVariable("id") long id) {
        try {
            contractRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAllContracts() {
        try {
            contractRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

    }
 /*
    @GetMapping("/published")
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
