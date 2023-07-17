package com.tennis.tennis_break_academy.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.Set;


@Entity
public class Terrain {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTerrain;

    @Column(nullable = false)
    private Integer capacity;

    @Column
    private String status;

    @Column
    private Double price;

    @Column
    private String name ; 
    
    @Column
    private String type;
    
    @Column(name = "\"description\"")
    private String description;

    @OneToMany(mappedBy = "idTerrain")
    private Set<Reservation> reservations;

    @OneToMany(mappedBy = "terrainId")
    private Set<CourtTimeAvailability> courtTimeList;

    @OneToMany(mappedBy = "idTerrain")
    private Set<ClosedCourt> closedCourtList;

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

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(final Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Set<CourtTimeAvailability> getCourtTimeList() {
        return courtTimeList;
    }

    public void setCourtTimeList(final Set<CourtTimeAvailability> courtTimeList) {
        this.courtTimeList = courtTimeList;
    }

    public Set<ClosedCourt> getClosedCourtList() {
        return closedCourtList;
    }

    public void setClosedCourtList(final Set<ClosedCourt> closedCourtList) {
        this.closedCourtList = closedCourtList;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
    

}
