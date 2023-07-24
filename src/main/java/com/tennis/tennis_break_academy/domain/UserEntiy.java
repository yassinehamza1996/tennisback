package com.tennis.tennis_break_academy.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="user")
public class UserEntiy {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private Integer age;

    @Column(nullable = false)
    private String cin;

    @Column
    private String phoneNumber;

    @Column
    private String mailAddress;
    
    @Column(unique = true) 
    private String username;
    
    @Column(name = "\"role\"")
    private String role;
    @Column
    private String password ;
    
    @Lob
    @Column(length = 5242880) 
    private byte[] image;
    
    @OneToMany(mappedBy = "userId")
    private Set<Reservation> reservationList;
    
    @ManyToMany(fetch = FetchType.EAGER , cascade = CascadeType.MERGE)
    @JoinTable( name = "T_Users_Roles_Associations")
    private List<Role> roles = new ArrayList<>();
    
    

    
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserEntiy() {
		super();
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(final Integer idUser) {
        this.idUser = idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(final String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getRole() {
        return role;
    }

    public void setRole(final String role) {
        this.role = role;
    }

    public Set<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(final Set<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    

}
