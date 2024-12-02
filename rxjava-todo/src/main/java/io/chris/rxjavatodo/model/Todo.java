package io.chris.rxjavatodo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Todo {
    private Long id;
    private String task;
    private String description;
    private Boolean completed;
}
