package com.swd.e_bake_ingredients.entity.media;

import com.swd.e_bake_ingredients.entity.auth.AccountProfile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ProfileImage extends Image {
    private AccountProfile accountProfile;
}
