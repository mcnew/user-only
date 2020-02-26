package com.github.mcnew.user.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.github.mcnew.user.repository")
class ApplicationConfiguration {

}