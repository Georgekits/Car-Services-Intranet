package gr.hua.dit.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Authorities;
import gr.hua.dit.entity.Permissions;
import gr.hua.dit.entity.User;

@Repository
public class AdminImpl implements AdminDAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public void AddUser(String username, String password, short enabled,String role) {
		// create a new session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a User object using constructor
		password = BCrypt.hashpw(password, BCrypt.gensalt());
		User myUser = new User(username, password, enabled);
		// add user to the table
		Authorities myAuthority = new Authorities(username,role);
		currentSession.save(myUser);
		currentSession.save(myAuthority);
	}

	@Override
	public void DeleteUser(String username) {
		// create a new session
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Authorities> authorities = currentSession.createQuery("from Authorities u where u.username =?",Authorities.class).setParameter(0,username);;
		List<Authorities> result = authorities.getResultList();
		currentSession.delete(result.get(0));
		
		Query<User> user = currentSession.createQuery("from User c where c.username= ?", User.class).setParameter(0,username);
		List<User> result1 = user.getResultList();
		currentSession.delete(result1.get(0));
//		result1.get(0).setEnabled((short) 0);
//		try {
//			//delete user
//			currentSession.delete(result.get(0));
//		}catch (Exception e) {
//            e.printStackTrace();
//		}
	}

	@Override
	public void UpdateUser(String column, String newValue, String existUser) {
		// create a new session
		Session currentSession = sessionFactory.getCurrentSession();
		String q = null;
		//update user depending on admin's option given by jsp
		if (column.equals("password")) {
			newValue = BCrypt.hashpw(newValue, BCrypt.gensalt());
			q = "update User set password = ? where username = ?";
		} else if (column.equals("role")) {
			q = "update Authorities set authority = ? where username = ?";
		}
		currentSession.createQuery(q).setParameter(0, newValue).setParameter(1, existUser).executeUpdate();
	}

	@Override
	public List<User> GetUserTable() {
		// create a new session
		Session currentSession = sessionFactory.getCurrentSession();

		Query<User> query = currentSession.createQuery("from User", User.class);

		// get all users from the table and add them to a list
		List<User> users = query.getResultList();

		// return the results
		return users;
	}
	
	@Override
	public void saveRole(User user, String role) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		NativeQuery sql=currentSession.createNativeQuery("INSERT INTO authorities(username,authority) VALUES('"+ user.getUsername() +"', '"+ role + "')");
		sql.executeUpdate();

	}

	@Override
	public List<Permissions> GetPermissionsTable() {
		// create a new session
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Permissions> query = currentSession.createQuery("from Permissions", Permissions.class);

		// get all users from the table and add them to a list
		List<Permissions> permissions = query.getResultList();
		System.out.println(permissions);
		// return the results
		return permissions;
	}

	@Override
	public void AddService(String service,String secretary,String engineer,String administrator) {
		// create a new session
		Session currentSession = sessionFactory.getCurrentSession();
		
		Permissions permission = new Permissions(service,secretary,engineer,administrator);
		
		currentSession.save(permission);
	}

	@Override
	public void DeleteService(String service) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Permissions> q = currentSession.createQuery("from Permissions where services = ?",Permissions.class).setParameter(0,service);
		List<Permissions> result = q.getResultList();
		try {
			currentSession.delete(result.get(0));
		}catch (Exception e) {
	        e.printStackTrace();
		}
	}

	@Override
	public void UpdateService (String column, String newValue, String existService) {
		Session currentSession = sessionFactory.getCurrentSession();
		String queryStr = null;
		if(column.equals("service")) {
			queryStr = "update from Permissions set services = ? where services = ?";
		} else if(column.equals("secretary")) {
			queryStr = "update from Permissions set secretary = ? where services = ?";
		} else if(column.equals("engineer")) {
			queryStr = "update from Permissions set engineer = ? where services = ?";
		} else if(column.equals("administrator")) {
			queryStr = "update from Permissions set administrator = ? where services = ?";
		}
		currentSession.createQuery(queryStr).setParameter(0,newValue).setParameter(1,existService).executeUpdate();
	}
	
	//check if a user exists in User table
	@Override
	public String CheckUser(String username) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<User> q = currentSession.createQuery("from User u where u.username = ?",User.class).setParameter(0,username);
		List<User> userList = q.getResultList();
		String exist;
		if(userList.isEmpty()) {
			exist = "User does not exist";
		} else {
			exist = "User exists";
		}
		return exist;
	}
	
	// return user with given id
	@Override
	public User getUser(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		User user = currentSession.get(User.class,id);
		return user;
	}


}
