package fr.maximedzn.microservice;

import fr.maximedzn.microservice.domain.Account.Account;
import fr.maximedzn.microservice.domain.User.User;
import fr.maximedzn.microservice.enums.AccountType;
import fr.maximedzn.microservice.enums.Role;
import fr.maximedzn.microservice.repository.AccountRepository;
import fr.maximedzn.microservice.repository.UserRepository;
import fr.maximedzn.microservice.security.PasswordConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class MicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(AccountRepository accountRepository, RepositoryRestConfiguration repositoryRestConfiguration, UserRepository userRepository, PasswordConfig passwordConfig) {
        return args -> {
            repositoryRestConfiguration.exposeIdsFor(Account.class);
            userRepository.save(User.builder().username("admin").password(passwordConfig.passwordEncoder().encode("admin")).role(Role.ROLE_ADMIN).build());
            userRepository.save(User.builder().username("user").password(passwordConfig.passwordEncoder().encode("user")).role(Role.ROLE_USER).build());
            accountRepository.save(Account.builder().balance(92.0).createdAt(new Date()).accountType(AccountType.COURANT).build());
            accountRepository.save(Account.builder().balance(100.0).createdAt(new Date()).accountType(AccountType.EPARGNE).build());
            accountRepository.save(Account.builder().balance(0.0).createdAt(new Date()).accountType(AccountType.COURANT).build());
            accountRepository.findAll().forEach(cp -> {
                System.out.println(cp);
            });
        };
    }
}
