package vn.com.viettel.vds.wallet3.account.dto.request;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CategoryRequestDto implements Serializable {

    private String code;
    private String name;
}
