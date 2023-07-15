package com.tennis.tennis_break_academy.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class TerrainDTO {

    private Integer idTerrain;

    @NotNull
    private Integer capacity;

    @Size(max = 255)
    private String status;

    private Double price;

    @Size(max = 255)
    private String description;

    public Integer getIdTerrain() {
        return idTerrain;
    }

    public void setIdTerrain(final Integer idTerrain) {
        this.idTerrain = idTerrain;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(final Integer capacity) {
        this.capacity = capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(final Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

}
