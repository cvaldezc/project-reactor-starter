package io.chris.rxproduct.expose.web;

import io.chris.rxproduct.model.Product;
import io.chris.rxproduct.service.ProductService;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class RxProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Single<Product> createEndpoint(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping(produces = MediaType.APPLICATION_NDJSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Flowable<Product> getProductsEndpoint() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Maybe<Product> findProductEndpoint(@PathVariable("id") Long id) {
        return productService.getProduct(id);
    }
}
