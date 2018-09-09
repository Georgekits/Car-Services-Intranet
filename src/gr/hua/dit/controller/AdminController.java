package gr.hua.dit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.entity.Permissions;
import gr.hua.dit.entity.User;
import gr.hua.dit.service.AdminService;

//each method calls a jsp that may return user given parameters
@Controller
@RequestMapping("/admin")
public class AdminController {

	// inject the User DAO
	@Autowired
	private AdminService AdminService;

	@RequestMapping("/AdminMenu")
	public String AdminMenu() {
		return "Admin/AdminMenu";
	}

	@GetMapping("/AddUser")
	public String AddUser() {
		return "Admin/AddUser";
	}

	@PostMapping("/SaveUser")
	public String SaveUser(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		short enabled = 1;
		AdminService.AddUser(username, password, enabled,role);
		return "redirect:/admin/AddUser";
	}

	@GetMapping("/DeleteUser")
	public String DeleteUser() {
		return "Admin/DeleteUser";
	}

	@PostMapping("/RemoveUser")
	public String DeleteUser(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
		String username = request.getParameter("username");
		if (!username.equals("null")) {
			AdminService.DeleteUser(username);
		}
		return "redirect:/admin/DeleteUser";
	}

	@GetMapping("/UpdateUser")
	public String UpdateUser() {
		return "Admin/UpdateUser";
	}

	@PostMapping("/ModifiedUser")
	public String ModifiedUser(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
		String column = request.getParameter("column");
		String newValue = request.getParameter("value");
		String existUser = request.getParameter("existUsername");
		AdminService.UpdateUser(column, newValue, existUser);
		return "redirect:/admin/UpdateUser";
	}

	@RequestMapping("/GetUserTable")
	public String GetUserTable(Model model) {
		// get Users from DAO
		List<User> Admin = AdminService.GetUserTable();

		// add the Users to the model
		model.addAttribute("admin", Admin);

		return "Admin/GetUserTable";
	}

	@RequestMapping("/GetPermissionsTable")
	public String GetPermissionsTable(Model model) {
		// get Users from DAO
		List<Permissions> Admin = AdminService.GetPermissionsTable();

		// add the permissions to the model
		model.addAttribute("admin", Admin);

		return "Admin/GetPermissionsTable";
	}

	@GetMapping("/CheckUser")
	public String CheckUser() {
		return "Admin/CheckUser";
	}

	@PostMapping("/CheckedUser")
	public String CheckedUser(HttpServletRequest request, HttpServletResponse res, Model model)
			throws ServletException, IOException {
		// get Users from DAO
		String username = request.getParameter("username");
		String exist = AdminService.CheckUser(username);
		model.addAttribute("exist", exist);
		return "redirect:/admin/CheckUser";
	}

	@GetMapping("/AddService")
	public String AddService() {
		return "Admin/AddService";
	}

	@PostMapping("/AddedService")
	public String AddedService(HttpServletRequest request, HttpServletResponse res)
			throws ServletException, IOException {
		String service = request.getParameter("service");
		String secretary = request.getParameter("secretary");
		String engineer = request.getParameter("engineer");
		String administrator = request.getParameter("administrator");
		AdminService.AddService(service, secretary, engineer, administrator);
		return "redirect:/admin/AddService";
	}

	@GetMapping("/DeleteService")
	public String DeleteService() {
		return "Admin/DeleteService";
	}

	@PostMapping("/DeletedService")
	public String DeletedService(HttpServletRequest request, HttpServletResponse res)
			throws ServletException, IOException {
		String service = request.getParameter("service");
		if (!service.equals("null")) {
			AdminService.DeleteService(service);
		}
		return "redirect:/admin/DeleteService";
	}

	@GetMapping("/UpdateService")
	public String UpdateService() {
		return "Admin/UpdateService";
	}

	@PostMapping("/UpdatedService")
	public String UpdatedService(HttpServletRequest request, HttpServletResponse res)
			throws ServletException, IOException {
		String column = request.getParameter("column");
		String newValue = request.getParameter("value");
		String existService = request.getParameter("existService");
		AdminService.UpdateService(column, newValue, existService);
		return "redirect:/admin/UpdateService";
	}


}
