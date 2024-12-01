package com.FullStack.Publicissapient.Entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {

    @Id
    private Long id;

//    @Version
//    private Long version;

    private String name;
    private String cuisine;
    private String difficulty;
    private int prepTimeMinutes;
    private int cookTimeMinutes;
    private int servings;
    private int caloriesPerServing;
    private double rating;
    private int reviewCount;

    @ElementCollection
    @CollectionTable(name = "recipe_ingredients", joinColumns = @JoinColumn(name = "recipe_id"))
    @Column(name = "ingredients")
    private List<String> ingredients;

    @ElementCollection()
    @CollectionTable(name = "recipe_instructions", joinColumns = @JoinColumn(name = "recipe_id"))
    @Column(name = "instructions")
    private List<String> instructions;

    @ElementCollection
    @CollectionTable(name = "recipe_tags", joinColumns = @JoinColumn(name = "recipe_id"))
    @Column(name = "tag")
    private List<String> tags;

    private String image;

    @ElementCollection
    @CollectionTable(name = "recipe_mealtype", joinColumns = @JoinColumn(name = "recipe_id"))
    @Column(name = "mealType")
    private List<String> mealType;

    // Getters and setters

}