package org.aomr.desc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class DescApplication {

    public static void main(String[] args) {
        SpringApplication.run(DescApplication.class, args);
    }

}
