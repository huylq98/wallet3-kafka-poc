package vn.com.viettel.vds.wallet3.account.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import vn.com.viettel.vds.wallet3.account.dto.request.CategoryRequestDto;
import vn.com.viettel.vds.wallet3.account.dto.response.CategoryResponseDto;
import vn.com.viettel.vds.wallet3.account.entity.Category;
import vn.com.viettel.vds.wallet3.account.mapper.CategoryMapper;
import vn.com.viettel.vds.wallet3.account.repository.CategoryRepository;
import vn.com.viettel.vds.wallet3.account.service.CategoryService;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final KafkaTemplate<Integer, Category> kafkaTemplate;

    @Override
    public Page<CategoryResponseDto> findAll(Pageable pageable) {
        List<CategoryResponseDto> responseDtos = categoryMapper.toDTOs(
                categoryRepository.findAll(pageable).getContent());
        return new PageImpl<>(responseDtos, pageable, responseDtos.size());
    }

    @Transactional(rollbackOn = {Exception.class})
    @Override
    public CategoryResponseDto save(CategoryRequestDto request) {
        Category savedCategory = categoryRepository.saveAndFlush(categoryMapper.toEntity(request));
        kafkaTemplate.sendDefault(savedCategory);
        return categoryMapper.toDTO(savedCategory);
    }

    @Transactional(rollbackOn = {Exception.class})
    @Override
    public CategoryResponseDto save(Long id, CategoryRequestDto request) {
        Category category = categoryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        category.setCode(request.getCode());
        category.setName(request.getName());
        kafkaTemplate.sendDefault(category);
        return categoryMapper.toDTO(categoryRepository.saveAndFlush(category));
    }

    @Transactional(rollbackOn = {Exception.class})
    @Override
    public void delete(Long id) {
        categoryRepository.findById(id).ifPresent(category -> {
            category.setIsDeleted(true);
            kafkaTemplate.sendDefault(categoryRepository.saveAndFlush(category));
        });
    }
}
