/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tradeworks.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author YNZ
 */
@Entity
public class Step implements Serializable {

    @Id
    @Column(name = "STEP_ID_PK")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private long id;

    @Column(name = "SEQUENCE_NUM")
    private String number;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(optional = false)
    @JoinColumn(name = "RECIPE_ID_PK", referencedColumnName = "RECIPE_ID_PK")
    @JsonIgnore
    protected Recipe recipe;

    public Step() {
    }
    
    public long getId(){
        return id; 
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

}
