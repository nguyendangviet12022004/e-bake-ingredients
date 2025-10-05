package com.swd.e_bake_ingredients.entity.media;

import com.swd.e_bake_ingredients.entity.order.Feedback;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class FeedbackImage extends Image {
    private Feedback feedback;
}
