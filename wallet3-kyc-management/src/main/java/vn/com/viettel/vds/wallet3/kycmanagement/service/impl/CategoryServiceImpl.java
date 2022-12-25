package vn.com.viettel.vds.wallet3.kycmanagement.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.com.viettel.vds.wallet3.account.entity.Category;
import vn.com.viettel.vds.wallet3.kycmanagement.mapper.CategoryMapper;
import vn.com.viettel.vds.wallet3.kycmanagement.repository.CategoryRepository;
import vn.com.viettel.vds.wallet3.kycmanagement.service.CategoryService;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Transactional(rollbackOn = {Exception.class})
    @Override
    public void save(Category request) {
        if (Boolean.TRUE.equals(request.getIsDeleted())) {
            categoryRepository.deleteById(request.getId());
        } else {
            categoryRepository.save(categoryMapper.toEntity(request));
        }
    }
}
