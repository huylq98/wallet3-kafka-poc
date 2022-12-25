package vn.com.viettel.vds.wallet3.account.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vn.com.viettel.vds.wallet3.account.dto.request.CategoryRequestDto;
import vn.com.viettel.vds.wallet3.account.dto.response.CategoryResponseDto;
import vn.com.viettel.vds.wallet3.account.service.CategoryService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public Page<CategoryResponseDto> findAll(Pageable pageable) {
        return categoryService.findAll(pageable);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CategoryResponseDto save(@RequestBody CategoryRequestDto request) {
        return categoryService.save(request);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{id}")
    public CategoryResponseDto save(@PathVariable("id") Long id, @RequestBody CategoryRequestDto request) {
        return categoryService.save(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        categoryService.delete(id);
    }
}
