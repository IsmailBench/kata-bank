package org.exalt.configuration;


import org.exalt.adapters.AccountJpaAdapter;
import org.modelmapper.ModelMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.exalt.repository.AccountEntityJpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableJpaRepositories
public class AccountConfig {
    @Bean
    public ModelMapper mapper() {return new ModelMapper();}

    @Bean
    public AccountJpaAdapter accountPersistence(AccountEntityJpaRepository accountEntityJpaRepository, ModelMapper modelMapper){
        return new AccountJpaAdapter(accountEntityJpaRepository,mapper()); }

}
