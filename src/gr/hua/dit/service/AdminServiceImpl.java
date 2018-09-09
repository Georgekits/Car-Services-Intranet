package gr.hua.dit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.entity.Permissions;
import gr.hua.dit.entity.User;
import gr.hua.dit.DAO.AdminDAO;

//service implementation connects service with DAO.
@Service
public class AdminServiceImpl implements AdminService {

	// inject the CustomerDAO
	@Autowired
	private AdminDAO AdminDAO;
	
	@Override
	@Transactional
	public void AddUser(String username, String password, short enabled,String role) {
		AdminDAO.AddUser(username,password,enabled,role);
	}

	@Override
	@Transactional
	public void DeleteUser(String username) {
		AdminDAO.DeleteUser(username);	
	}

	@Override
	@Transactional
	public void UpdateUser(String column, String newValue, String existUser) {
		AdminDAO.UpdateUser(column, newValue, existUser);	
	}

	@Override
	@Transactional
	public List<User> GetUserTable() {
		return AdminDAO.GetUserTable();
	}

	@Override
	@Transactional
	public List<Permissions> GetPermissionsTable() {
		return AdminDAO.GetPermissionsTable();
	}

	@Override
	@Transactional
	public void AddService(String service, String secretary, String engineer, String administrator) {
		AdminDAO.AddService(service, secretary, engineer, administrator);
		
	}

	@Override
	@Transactional
	public void DeleteService(String service) {
		AdminDAO.DeleteService(service);
		
	}

	@Override
	@Transactional
	public void UpdateService(String column, String newValue, String existService) {
		AdminDAO.UpdateService(column, newValue, existService);
		
	}

	@Override
	@Transactional
	public String CheckUser(String username) {
		return AdminDAO.CheckUser(username);
	}
	
	@Override
	@Transactional
	public User getUser(int id) {
		return AdminDAO.getUser(id);
	}

	@Override
	public void saveRole(User user, String role) {
		AdminDAO.saveRole(user, role);
	}


}
