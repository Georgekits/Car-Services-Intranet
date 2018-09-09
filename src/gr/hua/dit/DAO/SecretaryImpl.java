package gr.hua.dit.DAO;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import gr.hua.dit.entity.CarDB;
import gr.hua.dit.entity.Client;
import gr.hua.dit.entity.ManagingSystem;

@Repository
public class SecretaryImpl implements SecretaryDAO {

	// inject the session factory
    @Autowired
    private SessionFactory sessionFactory;
    
	@Override
	public void AddAuto(String plate,String owner,Date lastCheck,String model,String auto_type) {
		Session currentSession = sessionFactory.getCurrentSession();
		ManagingSystem newAuto = new ManagingSystem(plate,owner,lastCheck,model,auto_type,null,null);
		Query<Client> query = currentSession.createQuery("from Client c where c.username = ?",Client.class).setParameter(0 ,owner);
		List<Client> result = query.getResultList();
		Client client = result.get(0);
		client.addCar(newAuto);
		newAuto.setClient(client);
		currentSession.save(newAuto);
	}
	
	@Override
	public void DeleteAuto(String plate) {
		//create a new session
    	Session currentSession = sessionFactory.getCurrentSession();
    	
    	Query<ManagingSystem> car = currentSession.createQuery("from ManagingSystem c where c.plate= ?", ManagingSystem.class).setParameter(0,plate);
		List<ManagingSystem> result = car.getResultList();
		try {
			currentSession.delete(result.get(0));
		}catch (Exception e) {
            e.printStackTrace();
		}
	}

	@Override
	public void UpdateAuto(String column, String newValue, String existAuto) {
		// create a new session
		Session currentSession = sessionFactory.getCurrentSession();
		String q = null;
		if (column.equals("plate")) {
			q = "update ManagingSystem set plate = ? where plate = ?";
		} else if (column.equals("owner")) {
			q = "update ManagingSystem set owner = ? where plate = ?";
		} else if (column.equals("auto_type")) {
			q = "update ManagingSystem set auto_type = ? where plate = ?";
		} else if (column.equals("model")) {
			q = "update ManagingSystem set model = ? where plate = ?";
		} else if (column.equals("last_check")) {
			q = "update ManagingSystem set last_check = ? where plate = ?";
		}
		currentSession.createQuery(q).setParameter(0, newValue).setParameter(1, existAuto).executeUpdate();
	}

	@Override
	public String CheckInsurance(String plateDB) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<CarDB> query = currentSession.createQuery("from CarDB c where c.plateDB= ?",CarDB.class).setParameter(0, plateDB);
		List<CarDB> autoList = query.getResultList();
		String answer;
		if(autoList.isEmpty()) {
			return answer = "This plate isn't registered in our database.";
		} 
		String insurance = autoList.get(0).getInsurance();
		if(insurance.equals("yes")) {
			answer = "Car has insurance.";
		} else {
			answer = "Car does not have insurance.";
		}
		return answer;		
	}
	
	@Override
	public String CheckPlate(String plate) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<ManagingSystem> query = currentSession.createQuery("from ManagingSystem m where m.plate =?",ManagingSystem.class).setParameter(0,plate);
		List<ManagingSystem> autoList = query.getResultList();
		String exist;
		if(autoList.isEmpty()) {
			exist = "Car does not exists";
		} else {
			exist = "Car exists";
		}
		return exist;
	}
		
	@Override
	public String CheckArrival(String plate){
		Session currentSession = sessionFactory.getCurrentSession();		
		//get current date from system
		LocalDate temp = LocalDate.now();		
		//convert localDate to Date
		Date today = Date.valueOf(temp);
		
		Query<ManagingSystem> query = currentSession.createQuery("from ManagingSystem c where c.plate=?",ManagingSystem.class).setParameter(0, plate);
		List<ManagingSystem> result = query.getResultList();
		
		String answer;
		try {
			Date sqlDate = result.get(0).getNext_check();
			if(today.compareTo(sqlDate) == 0) {
				answer= "You arrived on time";
			} else if(today.compareTo(sqlDate) > 0){			
				answer= "You have arrived late";
			} else {
				answer= "You have arrived before the check's date.";
			}
			
		}catch (Exception e) {
			answer = "We do not have an appointment for your car."
					+ "Make an appointment with our engineer.";
		}
		
		
		return answer;
	}

	@Override
	public int CalculateDebt(String plate) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<ManagingSystem> query = currentSession.createQuery("from ManagingSystem m where m.plate =?",ManagingSystem.class).setParameter(0,plate);
		ManagingSystem result = query.getResultList().get(0);
		
		String autoType = result.getAuto_type();
		System.out.println("autotype :"+autoType);
		Client client = result.getClient();
		System.out.println("client :"+client);
		int debt = client.getDebt();
		
		if (CheckPlate(plate).equals("Car exists")) {
			// add 200 to client's debt if he does not have insurance
			if (CheckInsurance(plate).equals("Car does not have insurance")) {
				debt = debt + 200;
			}
			//change variable 'ar' depending on client's arrival
			double ar;
			if(CheckArrival(plate).equals("You have arrived late")) {
				ar = 1.5;
			} else if (CheckArrival(plate).equals("You have arrived before the check's date.")){
				ar = 0;
			} else {
				ar = 1;
			}
			//calculate debt depending on car's auto type
			if(autoType.equals("Car <= 1800cc")) {
				debt = (int) (debt + (50*ar));
			}else if(autoType.equals("Car > 1800cc")) {
				debt = (int) (debt + (80*ar));
			}else if(autoType.equals("Truck <= 3t")) {
				debt = (int) (debt + (100*ar));
			}else if(autoType.equals("Truck > 3t")) {
				debt = (int) (debt + (150*ar));
			}
		}
		//set client's debt and return it
		client.setDebt(debt);
		return debt;
	
	}

	@Override
	public List<Client> GetClientTable() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Client> query = currentSession.createQuery("from Client", Client.class);

		// get all users from the table and add them to a list
		List<Client> clients = query.getResultList();

		// return the results
		return clients;
	}

	@Override
	public ManagingSystem getCar(String plate) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		ManagingSystem car = currentSession.get(ManagingSystem.class,plate);
		return car;
	}

	@Override
	public Client getClient(String username) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Client> query = currentSession.createQuery("from Client c where c.username=?",Client.class).setParameter(0,username);
		List<Client> clients = query.getResultList();
		Client client = clients.get(0);
		return client;	
	}

	@Override
	public List<ManagingSystem> GetCarTable(String owner) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<ManagingSystem> query = currentSession.createQuery("from ManagingSystem m where m.owner=?", ManagingSystem.class).setParameter(0, owner);

		// get all users from the table and add them to a list
		List<ManagingSystem> cars = query.getResultList();
		// return the results
		return cars;
	}

	@Override
	public void makeApp(Date date,String username) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		String q = "update Client set appointment = ? where username = ?";
		
		currentSession.createQuery(q).setParameter(0, date).setParameter(1, username).executeUpdate();
	}
	
	@Override
	public CarDB CheckPlateDB(String plate) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<CarDB> query = currentSession.createQuery("from CarDB m where m.plateDB =?",CarDB.class).setParameter(0,plate);
		List<CarDB> autoList = query.getResultList();
		if(autoList.isEmpty()) {
			return null;
		} else {
			return autoList.get(0);
		}
	}

	
}
		
