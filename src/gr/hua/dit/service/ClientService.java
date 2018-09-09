package gr.hua.dit.service;

import java.sql.Date;

import gr.hua.dit.entity.CarDB;
import gr.hua.dit.entity.Client;
import gr.hua.dit.entity.ManagingSystem;

public interface ClientService {
	//list of methods
	public ManagingSystem getCar(String plate);
	public Client getClient(String username);
	public void makeApp(Date date, String username);
	public CarDB CheckPlateDB(String plate);
}
