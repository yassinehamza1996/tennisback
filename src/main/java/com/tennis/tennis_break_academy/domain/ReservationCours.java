package com.tennis.tennis_break_academy.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

    @Column
    private Integer courseId;
    
    @Column
    private Integer coachId;
    
    @Column
    private Integer reservationId;
    
    @OneToOne(mappedBy = "reservationCoursId")
    private Cours course;   
    @OneToOne(mappedBy = "reservationCoursId")
    private Coach coach;
    @OneToOne(mappedBy = "reservationCoursId")
    private Reservation reservation;
    
    
    public ReservationCours() {
		super();
	}


	public ReservationCours( Cours course, Coach coach , Reservation reservation) {
		this.courseId = this.course.getIdCours();
		this.coachId = this.coach.getIdCoach();
		this.reservationId = this.reservation.getIdReservation();
	}

    
	public Integer getReservationId() {
		return reservation.getIdReservation();
	}


	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}


	public Reservation getReservation() {
		return reservation;
	}


	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}


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

	public Integer getCourseId() {
		return course.getIdCours();
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public Integer getCoachId() {
		return coach.getIdCoach();
	}

	public void setCoachId(Integer coachId) {
		this.coachId = coachId;
	}

	public Cours getCourse() {
		return course;
	}

	public void setCourse(Cours course) {
		this.course = course;
	}

	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}
    
    

}
