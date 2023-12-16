package com.deevscale.principalapi.service.account;

import com.deevscale.principalapi.entity.account.Account;
import com.deevscale.principalapi.entity.login.AccountApplicationLogin;
import com.deevscale.principalapi.repository.account.AccountRepository;
import com.deevscale.principalapi.repository.auth.AuthPasswordRepository;
import com.deevscale.principalmodel.api.request.account.NewAccountRequest;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountSecurityService accountSecurityService;
    private final AccountRepository accountRepository;
    private final AuthPasswordRepository authPasswordRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String newAccountTopicName;
    private final SessionFactory sessionFactory;

    public AccountService(
            AccountRepository accountRepository,
            AccountSecurityService accountSecurityService,
            AuthPasswordRepository authPasswordRepository,
            KafkaTemplate<String, String> kafkaTemplate,
            SessionFactory sessionFactory,
            @Value(value = "${principal.kafka.topicNames.account.addNew}")
            String newAccountTopicName
    ) {
        this.accountRepository = accountRepository;
        this.accountSecurityService = accountSecurityService;
        this.authPasswordRepository = authPasswordRepository;
        this.kafkaTemplate = kafkaTemplate;
        this.sessionFactory = sessionFactory;
        this.newAccountTopicName = newAccountTopicName;

    }

    public Account addNew(NewAccountRequest newAccountRequest) {

        String hashedPassword = newAccountRequest.getLogin().getPassword() != null ? accountSecurityService.hashPassword(newAccountRequest.getLogin().getPassword()) : null;

        Account account = accountRepository.save(Account.builder()
                .build());


        authPasswordRepository.save(AccountApplicationLogin.AccountLoginAuthPassword.builder()
                .accountId(account.getId())
                .password(hashedPassword)
                .build());

        return account;
    }


    private void sendNewAccountMessage(Account account) {
        kafkaTemplate.send(newAccountTopicName, account.getId().toString());
    }

}
