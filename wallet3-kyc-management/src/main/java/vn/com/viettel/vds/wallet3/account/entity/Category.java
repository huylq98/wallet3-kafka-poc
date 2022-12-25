package vn.com.viettel.vds.wallet3.account.entity;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Category implements Serializable {

    private Long id;
    private String code;
    private String name;
    private Boolean isDeleted;
}
