package gr.hua.dit.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;


@XmlRootElement(name = "Client")
@Entity
@Table(name = "CLIENT")
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4310661683443846471L;

	/**
	 * 
	 */

	//Fields
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "debt")
	private int debt;

	@Column(name = "appointment")
	private Date appointment;

	// one to many mapping with table 'ManagingSystem'
	@OneToMany(fetch = FetchType.EAGER,mappedBy="client",cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})  
	@JsonIgnore
	private List<ManagingSystem> cars;

	//Constructors
	public Client() {

	}

	public Client(int id, String username, String password, int debt) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.debt = debt;
	}

	//Getters Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public int getDebt() {
		return debt;
	}

	public void setDebt(int debt) {
		this.debt = debt;
	}
	
	//We had a problem with graph cycle
	@XmlTransient							
	public List<ManagingSystem> getCars() {
		return cars;
	}
	
	public void setCars(List<ManagingSystem> cars) {
		this.cars = cars;
	}

	public Date getAppointment() {
		return appointment;
	}

	public void setAppointment(Date appointment) {
		this.appointment = appointment;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", username=" + username + ", password=" + password + ", debt=" + debt
				+ ", appointment=" + appointment + "]";
	}

	// add a convenience method
	public void addCar(ManagingSystem car) {
		if (cars == null) {
			cars = new ArrayList<>();
		}
		cars.add(car);
	}

}
