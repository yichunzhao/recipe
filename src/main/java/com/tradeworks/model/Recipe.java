/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tradeworks.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author YNZ
 */
@Entity
@Table(name = "RECIPES")
public class Recipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RECIPE_ID_PK")
    @JsonIgnore
    private long id;

    @Column(name = "TITLE")
    private String title;

    @Lob
    @Basic(fetch = FetchType.LAZY, optional = true)
    @Column(name = "PHOTO", nullable = true)
    private byte[] photo;

    @OneToMany(mappedBy = "recipe", orphanRemoval = true, cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties( value = "recipe" ,allowSetters = true)
    private List<Ingredient> ingredients;

    @OneToMany(mappedBy = "recipe", orphanRemoval = true, cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties( value = "recipe" ,allowSetters = true)
    private List<Step> instructions;

    public Recipe() {
        this.instructions = new ArrayList<>();
        this.ingredients = new ArrayList<>();
    }

    public long getId() {
        return id;
    }
    
    public void SetId(long id){
        this.id = id; 
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Step> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<Step> instructions) {
        this.instructions = instructions;
    }

}
