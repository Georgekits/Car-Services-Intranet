package gr.hua.dit.service;

import java.sql.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.DAO.SecretaryDAO;
import gr.hua.dit.entity.CarDB;
import gr.hua.dit.entity.Client;
import gr.hua.dit.entity.ManagingSystem;

//service implementation connects service with DAO.
@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private SecretaryDAO SecretaryDAO;
	
	@Override
	@Transactional
	public ManagingSystem getCar(String plate) {
		return SecretaryDAO.getCar(plate);	
	}
	
	@Override
	@Transactional
	public Client getClient(String username) {
		return SecretaryDAO.getClient(username);
	}

	@Override
	@Transactional
	public void makeApp(Date date,String username) {
		SecretaryDAO.makeApp(date,username);
	}

	@Override
	@Transactional
	public CarDB CheckPlateDB(String plate) {
		return SecretaryDAO.CheckPlateDB(plate);
	}

}
