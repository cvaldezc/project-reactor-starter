package io.chris.rxproduct.repository.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table("product")
public class ProductEntity {

    @Id
    private Long id;
    private String name;
    @Column("createAt")
    private LocalDateTime createAt;
    private boolean enabled;
}
