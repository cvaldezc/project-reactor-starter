package io.chris.rxproduct.repository.entity;

import org.springframework.data.repository.reactive.RxJava3CrudRepository;

public interface ProductRepository extends RxJava3CrudRepository<ProductEntity, Long> {
}
