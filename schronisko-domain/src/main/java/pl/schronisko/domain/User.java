package pl.schronisko.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Column(name="id_user")
	@Id
	//@GeneratedValue
	int idUser;
	@Column(name="user_name")
	String userName;
	String password;
	String role;
	int enabled;
	
	public User() {
		
	}
	public User(String name, String password, String role) {
	
		this.userName = name;
		this.password = password;
		this.role = role;
	}
	public User(int idUser, String userName, String password, String role, int enabled) {
		super();
		this.idUser = idUser;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.enabled = enabled;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String name) {
		this.userName = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int isEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
}
