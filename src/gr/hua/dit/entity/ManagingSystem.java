package gr.hua.dit.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement(name = "ManagingSystem")
@Entity
@Table(name = "MANAGINGSYSTEM")
public class ManagingSystem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4310661683443846471L;

	/**
	 * 
	 */
	
	
	//Fields
	@Id
	@Column(name = "plate")
    private String plate;
	
    @Column(name = "owner")
    private String owner;

    @Column(name = "last_check")
    private Date last_check;

    @Column(name = "model")
    private String model;
    
    @Column(name = "auto_type")
    private String auto_type;
    
    @Column(name = "next_check")
    private Date next_check;
    
    @Column(name = "damage")
    private String damage;
   
    //many to one mapping with table 'client' 
    @ManyToOne(fetch = FetchType.EAGER, cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})  
    @JoinColumn(name="client_id")
    @JsonIgnore
    private Client client;
    
    //Constructors
    public ManagingSystem() {
    	
    }
    
	public ManagingSystem(String plate, String owner, Date last_check, String model, String auto_type,Date next_check,String damage ) {
		super();
		this.plate = plate;
		this.owner = owner;
		this.last_check = last_check;
		this.model = model;
		this.auto_type = auto_type;
		this.next_check = next_check;
		this.damage = damage;
	}
	
	//Getters Setters
	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Date getLast_check() {
		return last_check;
	}

	public void setLast_check(Date last_check) {
		this.last_check = last_check;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getAuto_type() {
		return auto_type;
	}

	public void setAuto_type(String auto_type) {
		this.auto_type = auto_type;
	}

	public Date getNext_check() {
		return next_check;
	}

	public void setNext_check(Date next_check) {
		this.next_check = next_check;
	}
	
	public String getDamage() {
		return damage;
	}

	public void setDamage(String damage) {
		this.damage = damage;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	

	@Override
	public String toString() {
		return "ManagingSystem [plate=" + plate + ", owner=" + owner + ", last_check=" + last_check + ", model=" + model
				+ ", auto_type=" + auto_type + ", next_check=" + next_check + "]";
	}
}