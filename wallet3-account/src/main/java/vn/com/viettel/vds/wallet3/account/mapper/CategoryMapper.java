package vn.com.viettel.vds.wallet3.account.mapper;

import org.mapstruct.Mapper;
import vn.com.viettel.vds.wallet3.account.dto.request.CategoryRequestDto;
import vn.com.viettel.vds.wallet3.account.dto.response.CategoryResponseDto;
import vn.com.viettel.vds.wallet3.account.entity.Category;

@Mapper
public interface CategoryMapper extends EntityMapper<CategoryRequestDto, Category, CategoryResponseDto> {
}
