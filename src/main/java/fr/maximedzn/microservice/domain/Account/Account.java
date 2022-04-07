package fr.maximedzn.microservice.domain.Account;

import fr.maximedzn.microservice.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long code;

    double balance;

    Date createdAt;
    @Enumerated(EnumType.STRING)
    AccountType accountType;

}
