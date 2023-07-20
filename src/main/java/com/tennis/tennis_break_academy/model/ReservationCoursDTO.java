package com.tennis.tennis_break_academy.model;

import jakarta.persistence.Column;

public class ReservationCoursDTO {

    private Integer idReservationCours;
 
    private Integer courseId;
    
    private Integer coachId;
    
    private Integer reservationId;
    
    
    public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public Integer getCoachId() {
		return coachId;
	}

	public void setCoachId(Integer coachId) {
		this.coachId = coachId;
	}

	public Integer getReservationId() {
		return reservationId;
	}

	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}

	public Integer getIdReservationCours() {
        return idReservationCours;
    }

    public void setIdReservationCours(final Integer idReservationCours) {
        this.idReservationCours = idReservationCours;
    }

}
