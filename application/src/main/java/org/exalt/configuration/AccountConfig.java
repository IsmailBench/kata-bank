package org.exalt.configuration;

import org.exalt.adapters.AccountJpaAdapter;
import org.modelmapper.ModelMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.exalt.repository.AccountEntityJpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
public class AccountConfig {
    @Bean
    public ModelMapper mapper() {return new ModelMapper();}


}
