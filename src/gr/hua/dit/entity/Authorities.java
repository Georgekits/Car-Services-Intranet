package gr.hua.dit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AUTHORITIES")
public class Authorities {

	//Fields
	@Id
	@Column(name = "username", unique = true, nullable = false)
	private String username;
	
	@Column(name = "authority")
	private String authority;
	
	//Getters Setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	//Constructors
	public Authorities() {
		
	}
	
	public Authorities(String username,String authority) {
		this.username = username;
		this.authority = authority;
	}
	
	
	@Override
	public String toString() {
		return "Authorities [username=" + username + ", authority=" + authority + "]";
	}

}
