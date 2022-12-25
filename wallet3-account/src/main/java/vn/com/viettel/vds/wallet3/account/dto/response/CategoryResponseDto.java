package vn.com.viettel.vds.wallet3.account.dto.response;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CategoryResponseDto implements Serializable {
    private Long id;
    private String code;
    private String name;
}
