package fr.maximedzn.microservice.domain.Account;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p2",types = Account.class)
public interface AccountProjection2 {
    double getBalance();
    Long getAccountType();
}
