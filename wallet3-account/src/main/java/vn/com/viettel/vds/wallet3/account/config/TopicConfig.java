package vn.com.viettel.vds.wallet3.account.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {
    @Value("${spring.kafka.template.default-topic}")
    private String defaultTopic;

    @Bean
    public NewTopic libraryEvents() {
        return TopicBuilder.name(defaultTopic)
                           .partitions(3)
                           .build();
    }
}
