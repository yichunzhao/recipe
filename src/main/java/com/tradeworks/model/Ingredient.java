/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tradeworks.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author YNZ
 */
@Entity
@Table(name = "INGREDIENT")
public class Ingredient implements Serializable {

    @Id
    @Column(name = "INGREDIENT_ID_PK")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    @Column(name = "Amount_Of_Ingredient")
    private String amount;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(optional = false)
    @JoinColumn(name = "RECIPE_ID_FK", referencedColumnName = "RECIPE_ID_PK", nullable = false)
    //@JsonIgnore
    //@JsonIgnoreProperties( value = "ingredients" ,allowSetters = true)
    protected Recipe recipe;

    public Ingredient() {
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public String toString() {
        return "Amount: " + this.amount + " DESCRIPTION: " + this.description;
    }

}
