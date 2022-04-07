package fr.maximedzn.microservice.repository;

import fr.maximedzn.microservice.domain.Account.Account;
import fr.maximedzn.microservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface AccountRepository extends JpaRepository<Account, Long> {

    @RestResource(path = "/byType")
    List<Account> findByAccountType(@Param(value = "type") AccountType accountType);

}
