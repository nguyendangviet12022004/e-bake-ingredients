package com.swd.e_bake_ingredients.entity.auth;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Token {
    private String id;

    private String code;

    private LocalDateTime createdAt;

    private LocalDateTime expiredAt;

    private Account account;

}
