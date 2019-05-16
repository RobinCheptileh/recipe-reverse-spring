package com.cognition.recipereverse;

import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
public class Recipe {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String url;
    @ElementCollection
    private List<String> ingredients;

    public Recipe() {
    }

    public Recipe(String name, String url, List<String> ingredients) {
        this.name = name;
        this.url = url;
        this.ingredients = ingredients;
    }
}
