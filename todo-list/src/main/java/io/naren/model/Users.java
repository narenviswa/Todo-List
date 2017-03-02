package io.naren.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String username;
	
	@NotNull
	private String password;
	
	public Users(){}
	
	
	public Users(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(unique=true)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
