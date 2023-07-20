package com.tennis.tennis_break_academy.domain;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;


@Entity
public class Coach {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCoach;

    @Column
    private String coachName;

    @Column
    private Integer age;

    @Column
    private String cin;

    @Column
    private String mailAddress;

    @Column
    private String phoneNumber;
    
    @Lob
    @Column(length = 20480)
    private byte[] image;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_cours_id")
    private ReservationCours reservationCoursId;

    public Integer getIdCoach() {
        return idCoach;
    }

    public void setIdCoach(final Integer idCoach) {
        this.idCoach = idCoach;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(final String coachName) {
        this.coachName = coachName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(final Integer age) {
        this.age = age;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(final String cin) {
        this.cin = cin;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(final String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ReservationCours getReservationCoursId() {
        return reservationCoursId;
    }

    public void setReservationCoursId(final ReservationCours reservationCoursId) {
        this.reservationCoursId = reservationCoursId;
    }

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
    

}
