package io.chris.rxproduct.service;

import io.chris.rxproduct.model.Product;
import io.chris.rxproduct.repository.entity.ProductMapper;
import io.chris.rxproduct.repository.entity.ProductRepository;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Single<Product> createProduct(Product product) {
        return Single.fromCallable(() -> productMapper.toEntity(product))
                .map(entity -> {
                    entity.setCreateAt(LocalDateTime.now());
                    return entity;
                })
                .flatMap(productRepository::save)
                .map(productMapper::toProduct);
    }

    @Override
    public Flowable<Product> getProducts() {
        return productRepository.findAll()
                .map(productMapper::toProduct)
                .zipWith(Flowable.interval(2, TimeUnit.SECONDS), (product, time) -> product)
                .doOnComplete(() -> log.info("getProducts done"));
    }

    @Override
    public Maybe<Product> getProduct(Long productId) {
        return Maybe.just(productId)
                .flatMap(productRepository::findById)
                .map(productMapper::toProduct)
                .doOnSuccess((s) -> log.info("getProduct success: {}", s));
    }
}
