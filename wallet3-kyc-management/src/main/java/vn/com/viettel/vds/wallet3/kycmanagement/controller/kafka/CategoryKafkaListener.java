package vn.com.viettel.vds.wallet3.kycmanagement.controller.kafka;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import vn.com.viettel.vds.wallet3.account.entity.Category;
import vn.com.viettel.vds.wallet3.kycmanagement.service.CategoryService;

@Component
@RequiredArgsConstructor
public class CategoryKafkaListener {

    private final CategoryService categoryService;

    @KafkaListener(topics = {"${spring.kafka.template.default-topic}"})
    public void synchronizeCategory(ConsumerRecord<Integer, Category> consumerRecord) {
        categoryService.save(consumerRecord.value());
    }
}
