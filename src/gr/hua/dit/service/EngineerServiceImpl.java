package gr.hua.dit.service;

import java.text.ParseException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gr.hua.dit.DAO.EngineerDAO;

//service implementation connects service with DAO.
@Service
public class EngineerServiceImpl implements EngineerService {

	@Autowired
	private EngineerDAO EngineerDAO;
	@Override
	@Transactional
	public void SubmitNextCheck(String plate, String nextCheck) throws ParseException {
		EngineerDAO.SubmitNextCheck(plate, nextCheck);	
	}

	@Override
	@Transactional
	public void HasDamage(String plate, String damage) {
		EngineerDAO.HasDamage(plate, damage);
	}

}
