package vn.com.viettel.vds.wallet3.kycmanagement.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.com.viettel.vds.wallet3.kycmanagement.dto.response.RegistrationInformationResponseDto;
import vn.com.viettel.vds.wallet3.kycmanagement.entity.RegistrationInformation;
import vn.com.viettel.vds.wallet3.kycmanagement.mapper.RegistrationInformationMapper;
import vn.com.viettel.vds.wallet3.kycmanagement.repository.RegistrationInformationRepository;
import vn.com.viettel.vds.wallet3.kycmanagement.service.RegistrationInformationService;

@Service
@RequiredArgsConstructor
public class RegistrationInformationServiceImpl implements RegistrationInformationService {

    private final RegistrationInformationRepository registrationInformationRepository;
    private final RegistrationInformationMapper registrationInformationMapper;

    @Override
    public Page<RegistrationInformationResponseDto> findAll(Pageable pageable) {
        Page<RegistrationInformation> registrationInformations = registrationInformationRepository.findAll(pageable);
        return new PageImpl<>(
                registrationInformationMapper.toDTOs(registrationInformations.getContent()),
                pageable,
                registrationInformations.getTotalElements()
        );
    }
}
