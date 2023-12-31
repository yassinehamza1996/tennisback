package com.tennis.tennis_break_academy.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.time.LocalDateTime;


@Entity
public class Reservation {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;

    @Column
    private String idUser;

    @Column
    private LocalDateTime startDate;

    @Column
    private LocalDateTime endDate;
    
    @Column
    private String description;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_terrain_id")
    private Terrain idTerrain;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id_id")
    private UserEntiy userId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_course_id")
    private ReservationCours reservationCoursId;
    
    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(final Integer idReservation) {
        this.idReservation = idReservation;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(final String idUser) {
        this.idUser = idUser;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(final LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(final LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Terrain getIdTerrain() {
        return idTerrain;
    }

    public void setIdTerrain(final Terrain idTerrain) {
        this.idTerrain = idTerrain;
    }

    public UserEntiy getUserId() {
        return userId;
    }

    public void setUserId(final UserEntiy userId) {
        this.userId = userId;
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ReservationCours getReservationCoursId() {
		return reservationCoursId;
	}

	public void setReservationCoursId(ReservationCours reservationCoursId) {
		this.reservationCoursId = reservationCoursId;
	}
    

}
