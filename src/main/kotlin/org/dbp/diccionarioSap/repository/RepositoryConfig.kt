package org.dbp.diccionarioSap.repository

import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableJpaRepositories(basePackages = ["org.dbp.diccionarioSap.repository"])
@EnableTransactionManagement
internal class RepositoryConfig()