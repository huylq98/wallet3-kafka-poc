package vn.com.viettel.vds.wallet3.kycmanagement.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.com.viettel.vds.wallet3.kycmanagement.dto.request.RegistrationInformationRequestDto;
import vn.com.viettel.vds.wallet3.kycmanagement.dto.response.RegistrationInformationResponseDto;
import vn.com.viettel.vds.wallet3.kycmanagement.entity.Category;
import vn.com.viettel.vds.wallet3.kycmanagement.entity.RegistrationInformation;
import vn.com.viettel.vds.wallet3.kycmanagement.mapper.RegistrationInformationMapper;
import vn.com.viettel.vds.wallet3.kycmanagement.repository.CategoryRepository;
import vn.com.viettel.vds.wallet3.kycmanagement.repository.RegistrationInformationRepository;
import vn.com.viettel.vds.wallet3.kycmanagement.service.RegistrationInformationService;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class RegistrationInformationServiceImpl implements RegistrationInformationService {

    private final RegistrationInformationRepository registrationInformationRepository;
    private final RegistrationInformationMapper registrationInformationMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public Page<RegistrationInformationResponseDto> findAll(Pageable pageable) {
        Page<RegistrationInformation> registrationInformations = registrationInformationRepository.findAll(pageable);
        return new PageImpl<>(
                registrationInformationMapper.toDTOs(registrationInformations.getContent()),
                pageable,
                registrationInformations.getTotalElements()
        );
    }

    @Transactional(rollbackOn = {Exception.class})
    @Override
    public RegistrationInformationResponseDto save(RegistrationInformationRequestDto request) {
        Category category = categoryRepository.findByCode(request.getCategoryCode())
                                              .orElseThrow(EntityNotFoundException::new);
        RegistrationInformation registrationInformation = registrationInformationMapper.toEntity(request);
        registrationInformation.setCategory(category);
        registrationInformation = registrationInformationRepository.saveAndFlush(registrationInformation);
        return registrationInformationMapper.toDTO(registrationInformation);
    }

    @Transactional(rollbackOn = {Exception.class})
    @Override
    public RegistrationInformationResponseDto save(Long id, RegistrationInformationRequestDto request) {
        RegistrationInformation registrationInformation = registrationInformationRepository.findById(id)
                                                                                           .orElseThrow(
                                                                                                   EntityNotFoundException::new);
        Category category = categoryRepository.findByCode(request.getCategoryCode())
                                              .orElseThrow(EntityNotFoundException::new);
        registrationInformation.setCode(request.getCode());
        registrationInformation.setName(request.getName());
        registrationInformation.setCategory(category);
        return registrationInformationMapper.toDTO(registrationInformation);
    }

    @Transactional(rollbackOn = {Exception.class})
    @Override
    public void delete(Long id) {
        registrationInformationRepository.findById(id)
                                         .ifPresent(registrationInformation -> {
                                             registrationInformation.setIsDeleted(true);
                                             registrationInformationRepository.save(registrationInformation);
                                         });
    }
}
