package com.tennis.tennis_break_academy.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.Set;


@Entity
public class ReservationCours {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservationCours;


    @OneToOne(mappedBy = "reservationCoursId")
    private Cours course;   
    @OneToOne(mappedBy = "reservationCoursId")
    private Coach coach;

    
    
    public Integer getIdReservationCours() {
        return idReservationCours;
    }

    public void setIdReservationCours(final Integer idReservationCours) {
        this.idReservationCours = idReservationCours;
    }

    public Cours getCour() {
        return course;
    }

    public void setCoursList(final Cours course) {
        this.course = course;
    }

    public Coach getCoachList() {
        return coach;
    }

    public void setCoachList(final Coach coach) {
        this.coach = coach;
    }

}
