package gr.hua.dit.service;

import java.sql.Date;
import java.util.List;

import gr.hua.dit.entity.Client;
import gr.hua.dit.entity.ManagingSystem;

public interface SecretaryService {
	//list of methods
	public void AddAuto(String plate,String owner,Date lastCheck,String model,String auto_type);
	public void DeleteAuto(String plate);
	public void UpdateAuto(String column, String newValue, String existAuto);
	public String CheckInsurance(String insurance);
	public String CheckPlate(String plate);
	public String CheckArrival(String plate);
	public int CalculateDebt(String plate);
	public List<Client> GetClientTable();
	public List<ManagingSystem> GetCarTable(String owner);
}
