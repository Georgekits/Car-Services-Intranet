package gr.hua.dit.service;

import java.text.ParseException;

public interface EngineerService {
	//list of methods
	public void SubmitNextCheck(String plate,String nextCheck) throws ParseException;
	public void HasDamage(String plate,String damage);
}
