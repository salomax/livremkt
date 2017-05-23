package com.marketplace;

import com.google.appengine.api.utils.SystemProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

/**
 * @author salomao.marcos@gmail.com
 * @since 22/05/17
 */
@Configuration
@EnableAutoConfiguration(exclude=DataSourceAutoConfiguration.class)
public class RepositoryConfig {

    @Bean
    public DataSource dataSource() {

        String url;
        String username;
        String password;
        String className;

        // TODO do it by properties file
        if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {

            url = "jdbc:google:mysql://salomax-livremkt:livremarketplace/livremarketplace?user=root";
            username = "root";
            password = "";
            className = "com.mysql.jdbc.GoogleDriver";

        } else {

            url = "jdbc:mysql://localhost:3306/livremarketplace";
            username = "root";
            password = "";
            className = "com.mysql.jdbc.Driver";

        }

        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();

        driverManagerDataSource.setDriverClassName(className);
        driverManagerDataSource.setUrl(url);
        driverManagerDataSource.setUsername(username);
        driverManagerDataSource.setPassword(password);

        return driverManagerDataSource;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        jpaTransactionManager.setJpaDialect(new HibernateJpaDialect());
        return jpaTransactionManager;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setGenerateDdl(false);
        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
        jpaVendorAdapter.setDatabase(Database.MYSQL);
        return jpaVendorAdapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan("com.marketplace.entity", "com.marketplace.repository");
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        return factoryBean;
    }

}
