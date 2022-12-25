package vn.com.viettel.vds.wallet3.cms.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import vn.com.viettel.vds.wallet3.cms.dto.PageResponse;
import vn.com.viettel.vds.wallet3.cms.entity.Category;

@FeignClient(name = "account-service", url = "${feign.client.account-service.host}", path = "/categories")
public interface AccountFeignClient {

    @GetMapping
    PageResponse<Category> findAllCategories(Pageable pageable);

    @PostMapping
    Category save(@RequestBody Category category);

    @PutMapping("/{id}")
    Category save(@PathVariable("id") Long id, @RequestBody Category category);

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Long id);
}
