package fr.maximedzn.microservice.service;

import fr.maximedzn.microservice.domain.Account.Account;
import fr.maximedzn.microservice.repository.AccountRepository;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@ManagedResource(objectName = "fr.maximedzn.microservice:name=AccountServiceImpl")
public class AccountServiceImpl implements AccountService{

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void transfer(Long codeFrom, Long codeTo, double balance) {
        Account c1 = accountRepository.getById(codeFrom);
        Account c2 = accountRepository.getById(codeTo);
        c1.setBalance(c1.getBalance()-balance);
        c2.setBalance(c2.getBalance()+balance);
        accountRepository.save(c1);
        accountRepository.save(c2);
    }
}
