package br.com.storeflow.bff.service;

import br.com.storeflow.bff.client.ProductClient;
import br.com.storeflow.bff.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductBffService {

    private final ProductClient productClient;

    public ProductResponse getProductById(Long id) {
        return productClient.getProductById(id);
    }
}