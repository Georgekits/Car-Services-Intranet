package gr.hua.dit.service;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.entity.Client;
import gr.hua.dit.entity.ManagingSystem;
import gr.hua.dit.DAO.SecretaryDAO;

//service implementation connects service with DAO.
@Service
public class SecretaryServiceImpl implements SecretaryService {

	@Autowired
	private SecretaryDAO SecretaryDAO;
	@Override
	@Transactional
	public void AddAuto(String plate, String owner, Date lastCheck, String model, String auto_type) {
		SecretaryDAO.AddAuto(plate, owner, lastCheck, model, auto_type);		
	}

	@Override
	@Transactional
	public void DeleteAuto(String plate) {
		SecretaryDAO.DeleteAuto(plate);
	}

	@Override
	@Transactional
	public void UpdateAuto(String column, String newValue, String existAuto) {
		SecretaryDAO.UpdateAuto(column, newValue, existAuto);
	}

	@Override
	@Transactional
	public String CheckInsurance(String insurance) {
		return SecretaryDAO.CheckInsurance(insurance);
	}

	@Override
	@Transactional
	public String CheckPlate(String plate) {
		return SecretaryDAO.CheckPlate(plate);
	}

	@Override
	@Transactional
	public String CheckArrival(String plate) {
		return SecretaryDAO.CheckArrival(plate);
	}

	@Override
	@Transactional
	public int CalculateDebt(String plate) {
		return SecretaryDAO.CalculateDebt(plate);
	}

	@Override
	@Transactional
	public List<Client> GetClientTable() {
		return SecretaryDAO.GetClientTable();
	}

	@Override
	@Transactional
	public List<ManagingSystem> GetCarTable(String owner) {
		return SecretaryDAO.GetCarTable(owner);
	}

}
