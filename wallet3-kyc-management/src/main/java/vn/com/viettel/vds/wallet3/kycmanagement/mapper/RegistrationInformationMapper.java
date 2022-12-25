package vn.com.viettel.vds.wallet3.kycmanagement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import vn.com.viettel.vds.wallet3.kycmanagement.dto.request.RegistrationInformationRequestDto;
import vn.com.viettel.vds.wallet3.kycmanagement.dto.response.RegistrationInformationResponseDto;
import vn.com.viettel.vds.wallet3.kycmanagement.entity.RegistrationInformation;

@Mapper
public interface RegistrationInformationMapper extends EntityMapper<RegistrationInformationRequestDto, RegistrationInformation, RegistrationInformationResponseDto> {

    @Mapping(target = "categoryCode", source = "category.code")
    @Override
    RegistrationInformationResponseDto toDTO(RegistrationInformation entity);
}
