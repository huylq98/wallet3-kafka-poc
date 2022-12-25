package vn.com.viettel.vds.wallet3.account.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.com.viettel.vds.wallet3.account.dto.request.CategoryRequestDto;
import vn.com.viettel.vds.wallet3.account.dto.response.CategoryResponseDto;


public interface CategoryService {
    Page<CategoryResponseDto> findAll(Pageable pageable);

    CategoryResponseDto save(CategoryRequestDto request);

    CategoryResponseDto save(Long id, CategoryRequestDto request);

    void delete(Long id);
}
