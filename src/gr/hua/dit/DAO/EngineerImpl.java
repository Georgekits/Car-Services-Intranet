package gr.hua.dit.DAO;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EngineerImpl implements EngineerDAO {


	// inject the session factory
    @Autowired
    private SessionFactory sessionFactory;
    
	@Override
	public void SubmitNextCheck(String plate, String nextCheck) throws ParseException {
		Session currentSession = sessionFactory.getCurrentSession();		
		Query query = currentSession.createQuery("update ManagingSystem set next_check= ? where plate= ?");
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(nextCheck);
		query.setParameter(0, date).setParameter(1,plate).executeUpdate();
			
	}

	@Override
	public void HasDamage(String plate, String damage) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("update ManagingSystem set damage = ? where plate= ?");
		query.setParameter(0, damage).setParameter(1,plate).executeUpdate();
	}


}
