package gr.hua.dit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CARDB")
public class CarDB {
	
	//Fieldss
	@Id	
	@Column(name = "plateDB")
    private String plateDB;

    @Column(name = "insurance")
    private String insurance;

    @Column(name = "owner")
    private String owner;
    
    //Constructors
    public CarDB() {
    	
    }

	public CarDB(String plateDB, String insurance, String owner) {
		super();
		this.plateDB = plateDB;
		this.insurance = insurance;
		this.owner = owner;
	}

	//Getters Setters
	public String getPlateDB() {
		return plateDB;
	}

	public void setPlateDB(String plateDB) {
		this.plateDB = plateDB;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "CarDB [plate=" + plateDB + ", insurance=" + insurance + ", owner=" + owner + "]";
	}
}
