package vn.com.viettel.vds.wallet3.kycmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"vn.com.viettel.vds.wallet3.kycmanagement.repository"})
@EnableKafka
public class Wallet3KycManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(Wallet3KycManagementApplication.class, args);
    }
}
