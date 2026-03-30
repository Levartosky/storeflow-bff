package br.com.storeflow.bff.service;

import br.com.storeflow.bff.client.ProductClient;
import br.com.storeflow.bff.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import  java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductClient productClient;

    public ProductResponse getProductById(Long id) {
        return productClient.getProductById(id);
    }

    public List<ProductResponse> getAllProducts(Long categoryId, int page, int size) {
        return productClient.getAllProducts(categoryId, page, size);
    }
}