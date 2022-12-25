package vn.com.viettel.vds.wallet3.kycmanagement.dto.response;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RegistrationInformationResponseDto implements Serializable {
    private Long id;
    private String code;
    private String name;
    private String categoryCode;
}