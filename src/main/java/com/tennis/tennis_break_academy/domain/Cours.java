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


@Entity
public class Cours {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCours;

    @Column
    private String courseName;

    @Column(name = "\"description\"")
    private String description;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_cours_id")
    private ReservationCours reservationCoursId;

    public Integer getIdCours() {
        return idCours;
    }

    public void setIdCours(final Integer idCours) {
        this.idCours = idCours;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(final String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public ReservationCours getReservationCoursId() {
        return reservationCoursId;
    }

    public void setReservationCoursId(final ReservationCours reservationCoursId) {
        this.reservationCoursId = reservationCoursId;
    }

}
