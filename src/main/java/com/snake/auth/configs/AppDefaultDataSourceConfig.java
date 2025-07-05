package com.snake.auth.configs;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef = "defaultEntityManagerFactory",
    transactionManagerRef = "defaultTransactionManager",
    basePackages = {"com.snake.auth.repositories"}
)

@Slf4j
public class AppDefaultDataSourceConfig {

  @Bean(name = {"defaultDataSourceProperties"})
  @Primary
  public DataSourceProperties dataSourceProperties() {
    return new DataSourceProperties();
  }

  @Bean(name = {"defaultDataSource"})
  @Primary
  public DataSource dataSource() {
    return this.dataSourceProperties()
        .initializeDataSourceBuilder()
        .type(HikariDataSource.class)
        .build();
  }

  @Bean(name = {"defaultPropertiesHibernate"})
  public Map<String, String> dataProperties() {
    return new HashMap<>();
  }

  @Bean(name = {"defaultEntityManagerFactory"})
  @Primary
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(
      EntityManagerFactoryBuilder builder
  ) {
    return builder
        .dataSource(this.dataSource())
        .properties(this.dataProperties())
        .packages("com.snake.auth.entities")
        .build();
  }

  @Bean(name = {"defaultTransactionManager"})
  @Primary
  public PlatformTransactionManager transactionManager(
      @Qualifier("defaultEntityManagerFactory") EntityManagerFactory entityManagerFactory
  ) {
    return new JpaTransactionManager(entityManagerFactory);
  }
}
