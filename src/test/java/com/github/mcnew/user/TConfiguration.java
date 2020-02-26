package com.github.mcnew.user;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;

@Configuration
@ActiveProfiles("test")
@EnableJpaRepositories("com.github.mcnew.user.repository")
@ComponentScan(basePackages = { "com.github.mcnew.user.service.impl" })
public class TConfiguration {

}
