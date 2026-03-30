package br.com.storeflow.bff.service;

import br.com.storeflow.bff.client.CategoryClient;
import br.com.storeflow.bff.dto.CategoryResponse;
import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
    
    private final CategoryClient categoryClient;

    public List<CategoryResponse> getAllCategories() {
        return categoryClient.getAllCategories();
    }

}
