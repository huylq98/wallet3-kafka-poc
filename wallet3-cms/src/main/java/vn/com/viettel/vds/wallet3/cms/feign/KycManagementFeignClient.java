package vn.com.viettel.vds.wallet3.cms.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import vn.com.viettel.vds.wallet3.cms.dto.PageResponse;
import vn.com.viettel.vds.wallet3.cms.entity.RegistrationInformation;

@FeignClient(name = "kyc-management-service", url = "${feign.client.kyc-management-service.host}", path = "/registration-informations")
public interface KycManagementFeignClient {

    @GetMapping
    PageResponse<RegistrationInformation> findAllRegistrationInformations(Pageable pageable);
}
