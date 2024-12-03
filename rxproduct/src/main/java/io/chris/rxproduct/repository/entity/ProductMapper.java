package io.chris.rxproduct.repository.entity;

import io.chris.rxproduct.model.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    ProductEntity toEntity(Product product);

    @InheritInverseConfiguration
    Product toProduct(ProductEntity productEntity);
}
