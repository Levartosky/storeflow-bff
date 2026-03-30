package br.com.storeflow.bff.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.storeflow.bff.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import br.com.storeflow.bff.dto.ProductResponse;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;



@RestController
@RequestMapping("/bff/products")
@RequiredArgsConstructor
public class ProductController {
    
    private final ProductService productService;

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @GetMapping
    public List<ProductResponse> getAllProducts(
        @RequestParam(required = false) Long categoryId,
        @RequestParam(defaultValue = "0") int page,     
        @RequestParam(defaultValue = "10") int size
    ) {
        return productService.getAllProducts(categoryId, page, size);
    };
    
}
