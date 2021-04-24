package com.tcs.UserApplication.Entities;
//import javax.validation.contstraints.NotEmpty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="User_Table")
public class UserEntity {
    @Id 
    @GeneratedValue
	private Long ID ;
    
    @NotEmpty(message="Username canot be empty")
    @Column(name="user_name", length=50,nullable=false,unique=true)
	private String username;
    
    @Size(min=2,message="First name should be minimum of 2 letter")
    @Column(name="first_name", length=50,nullable=false)
	private String firstName;
    
    @Column(name="last_name", length=50,nullable=false)
	private String lastName;
    
    @Column(name="email_address", length=50,nullable=false)
	private String email;
    
    @Column(name="role", length=50,nullable=false)
	private String role;
    
    @Column(name="SSN", length=50,nullable=false,unique=true)
	private String SSN;

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String sSN) {
		SSN = sSN;
	}

  

	public UserEntity(Long iD, String username, String firstName, String lastName, String email, String role,
			String sSN) {
		super();
		ID = iD;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		SSN = sSN;
	}

	public UserEntity() {
	
	}

	@Override
	public String toString() {
		return "UserEntity [ID=" + ID + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", role=" + role + ", SSN=" + SSN + "]";
	}


   // ------------
    
    
	
	
	
	
	
	
	
	
	
}
