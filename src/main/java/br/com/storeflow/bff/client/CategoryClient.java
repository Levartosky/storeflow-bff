package br.com.storeflow.bff.client;

import br.com.storeflow.bff.dto.CategoryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@FeignClient(
    name = "storeflowSrvCategoryClient",
    url = "${storeflow.srv.url}"
)

public interface CategoryClient {
    
    @GetMapping("/categories")
    List<CategoryResponse> getAllCategories();
}
