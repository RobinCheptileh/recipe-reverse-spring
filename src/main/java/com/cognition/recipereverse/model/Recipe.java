package com.cognition.recipereverse.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@ApiModel(description = "Details of the recipe")
@Data
@Entity
public class Recipe {
    @ApiModelProperty(notes = "Database generated id for the recipe")
    @Id
    @GeneratedValue
    private Long id;

    @ApiModelProperty(notes = "Name of the recipe")
    @NotBlank
    private String name;

    @ApiModelProperty(notes = "Url to the recipe")
    @NotBlank
    private String url;

    @ApiModelProperty(notes = "List of the recipe's ingredients")
    @NotEmpty
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
