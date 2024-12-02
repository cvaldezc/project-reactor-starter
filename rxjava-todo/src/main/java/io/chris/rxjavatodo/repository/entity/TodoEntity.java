package io.chris.rxjavatodo.repository.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "todo")
public class TodoEntity {
    @Id
    private Long id;
    private String task;
    private String description;
    private Boolean completed;
}
