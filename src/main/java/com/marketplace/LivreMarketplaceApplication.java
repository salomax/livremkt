package com.marketplace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author salomao.marcos@gmail.com
 * @since 21/05/17
 */
@SpringBootApplication(exclude = JmxAutoConfiguration.class)
public class LivreMarketplaceApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(LivreMarketplaceApplication.class);
        application.run(args);
    }

//    @Bean
//    public DataSource dataSource() {
//
//        String url = "jdbc:google:mysql://salomax-livremkt:livremarketplace/livremarketplace?user=root";
//        String username = "root";
//        String password = "rollback";
//        String className = "com.mysql.jdbc.GoogleDriver";
//
////        String url = "jdbc:mysql://localhost:3306/livremarketplace";
////        String username = "root";
////        String password = "";
////        String className = "com.mysql.jdbc.Driver";
//
//        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//
//        driverManagerDataSource.setDriverClassName(className);
//        driverManagerDataSource.setUrl(url);
//        driverManagerDataSource.setUsername(username);
//        driverManagerDataSource.setPassword(password);
//
//        return driverManagerDataSource;
//    }


}