package br.com.storeflow.bff.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import br.com.storeflow.bff.dto.ProductResponse;

@FeignClient(
    name = "storeflowSrvProductClient",
    url = "${storeflow.srv.url}"
)

public interface ProductClient {

@GetMapping("/products/{id}")
ProductResponse getProductById(@PathVariable Long id);

@GetMapping("/products")
List<ProductResponse> getAllProducts(
@RequestParam(required = false) Long categoryId,
@RequestParam(defaultValue = "0") int page,
@RequestParam(defaultValue = "10") int size);


}
