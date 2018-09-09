package gr.hua.dit.DAO;

import java.text.ParseException;

public interface EngineerDAO {
	public void SubmitNextCheck(String plate,String nextCheck) throws ParseException;
	public void HasDamage(String plate,String damage);
}
