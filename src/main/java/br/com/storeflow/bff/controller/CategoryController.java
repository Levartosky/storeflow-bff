package br.com.storeflow.bff.controller;

import br.com.storeflow.bff.dto.CategoryResponse;
import br.com.storeflow.bff.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("bff/categories")   
@RequiredArgsConstructor
public class CategoryController {
    

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryResponse> getAllCategories() {
        return categoryService.getAllCategories();
    }

}
