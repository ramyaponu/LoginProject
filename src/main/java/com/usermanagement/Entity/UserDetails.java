package com.usermanagement.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table
public class UserDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int userId ;
	@NotNull(message="user name shouldn't be null")
	String userName;
	@Pattern(regexp = "^\\d{10}$",message="invlid mobile number")
	String userPhoneNumber;
   @NotNull
	String userEmail;
    @NotNull
	String userPassword;
	
	public int getUserId() {
		return userId;
	}	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}
	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + ", userPhoneNumber=" + userPhoneNumber
				+ ", userEmail=" + userEmail + ", userPassword=" + userPassword + "]";
	}
	
}
