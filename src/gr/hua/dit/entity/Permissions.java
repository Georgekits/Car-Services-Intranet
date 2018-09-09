package gr.hua.dit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERMISSIONS")
public class Permissions {

	//Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "services")
	private String services;

	@Column(name = "secretary")
	private String secretary;

	@Column(name = "engineer")
	private String engineer;

	@Column(name = "administrator")
	private String administrator;

	//Constructors
	public Permissions() {

	}

	public Permissions(String services, String secretary, String engineer, String administrator) {
		super();
		this.services = services;
		this.secretary = secretary;
		this.engineer = engineer;
		this.administrator = administrator;
	}

	public String getServices() {
		return services;
	}

	public void setServices(String services) {
		this.services = services;
	}

	public String getSecretary() {
		return secretary;
	}

	public void setSecretary(String secretary) {
		this.secretary = secretary;
	}

	public String getEngineer() {
		return engineer;
	}

	public void setEngineer(String engineer) {
		this.engineer = engineer;
	}

	public String getAdministrator() {
		return administrator;
	}

	public void setAdministrator(String administrator) {
		this.administrator = administrator;
	}

	@Override
	public String toString() {
		return "Permissions [id=" + id + ", services=" + services + ", secretary=" + secretary + ", engineer="
				+ engineer + ", administrator=" + administrator + "]";
	}

}
