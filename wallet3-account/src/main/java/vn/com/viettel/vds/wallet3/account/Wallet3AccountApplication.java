package vn.com.viettel.vds.wallet3.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"vn.com.viettel.vds.wallet3.account.repository"})
public class Wallet3AccountApplication {
    public static void main(String[] args) {
        SpringApplication.run(Wallet3AccountApplication.class, args);
    }
}
