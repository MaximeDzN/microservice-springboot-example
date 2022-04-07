package fr.maximedzn.microservice.domain.Account;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p1",types = Account.class)
public interface AccountProjection1 {
    Long getCode();
    double getBalance();
}
