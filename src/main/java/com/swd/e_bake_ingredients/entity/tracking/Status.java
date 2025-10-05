package com.swd.e_bake_ingredients.entity.tracking;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Status {
    private Integer id;
    private String description;
    private LocalDateTime timestamp;
}
