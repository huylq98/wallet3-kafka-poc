package vn.com.viettel.vds.wallet3.kycmanagement.dto.request;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RegistrationInformationRequestDto implements Serializable {
    private String code;
    private String name;
    private String categoryCode;
}
