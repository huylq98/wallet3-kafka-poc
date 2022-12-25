package vn.com.viettel.vds.wallet3.kycmanagement.mapper;

import org.mapstruct.Mapper;
import vn.com.viettel.vds.wallet3.kycmanagement.entity.Category;

@Mapper
public interface CategoryMapper {
    Category toEntity(vn.com.viettel.vds.wallet3.account.entity.Category request);
}
