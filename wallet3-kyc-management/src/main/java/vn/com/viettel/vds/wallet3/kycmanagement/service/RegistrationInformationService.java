package vn.com.viettel.vds.wallet3.kycmanagement.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.com.viettel.vds.wallet3.kycmanagement.dto.response.RegistrationInformationResponseDto;

public interface RegistrationInformationService {
    Page<RegistrationInformationResponseDto> findAll(Pageable pageable);
}
