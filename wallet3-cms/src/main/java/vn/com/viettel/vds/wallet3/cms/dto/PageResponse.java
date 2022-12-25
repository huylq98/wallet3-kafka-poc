package vn.com.viettel.vds.wallet3.cms.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PageResponse<T extends Serializable> implements Serializable {
    private List<T> content;
    private Integer totalElements;
    private Integer totalPages;
    private Integer numberOfElements;
}
