package com.tennis.tennis_break_academy.model;


public class CoursDTO {

    private Integer idCours;
    private String courseName;
    private String description;
    private Integer reservationCoursId;
    private byte[] image;
    
    public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Integer getIdCours() {
        return idCours;
    }

    public void setIdCours(Integer idCours) {
        this.idCours = idCours;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getReservationCoursId() {
        return reservationCoursId;
    }

    public void setReservationCoursId(Integer reservationCoursId) {
        this.reservationCoursId = reservationCoursId;
    }

    @Override
    public String toString() {
        return "CoursDTO{" +
                "idCours=" + idCours +
                ", courseName='" + courseName + '\'' +
                ", description='" + description + '\'' +
                ", reservationCoursId=" + reservationCoursId +
                '}';
    }
}
