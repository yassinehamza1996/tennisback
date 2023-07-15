package com.tennis.tennis_break_academy.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("com.tennis.tennis_break_academy.domain")
@EnableJpaRepositories("com.tennis.tennis_break_academy.repos")
@EnableTransactionManagement
public class DomainConfig {
}
