package vn.com.viettel.vds.wallet3.cms.entity;

import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@JmixEntity
public class RegistrationInformation implements Serializable {
    private Long id;
    private String categoryCode;
    private String code;
}
