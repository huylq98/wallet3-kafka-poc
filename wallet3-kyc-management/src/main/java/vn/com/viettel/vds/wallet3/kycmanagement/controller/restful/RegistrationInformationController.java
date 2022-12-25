package vn.com.viettel.vds.wallet3.kycmanagement.controller.restful;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.com.viettel.vds.wallet3.kycmanagement.dto.response.RegistrationInformationResponseDto;
import vn.com.viettel.vds.wallet3.kycmanagement.service.RegistrationInformationService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/registration-informations")
public class RegistrationInformationController {

    private final RegistrationInformationService registrationInformationService;

    @GetMapping
    public Page<RegistrationInformationResponseDto> findAll(Pageable pageable) {
        return registrationInformationService.findAll(pageable);
    }
}
