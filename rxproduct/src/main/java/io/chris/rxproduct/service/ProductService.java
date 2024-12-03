package io.chris.rxproduct.service;

import io.chris.rxproduct.model.Product;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

public interface ProductService {

    Single<Product> createProduct(Product product);
    Flowable<Product> getProducts();
    Maybe<Product> getProduct(Long productId);
}
