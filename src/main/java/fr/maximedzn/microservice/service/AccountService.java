package fr.maximedzn.microservice.service;

public interface AccountService {

    void transfer(Long codeFrom,Long codeTo, double balance);

}
