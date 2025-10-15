package com.swd.e_bake_ingredients.entity.order;

import java.util.List;

import com.swd.e_bake_ingredients.entity.media.FeedbackImage;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int vote;

    private String comment;

    @ManyToOne
    private Item item;

    @OneToMany(mappedBy = "feedback")
    List<FeedbackImage> images;
}
