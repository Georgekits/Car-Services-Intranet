package gr.hua.dit.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
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
import gr.hua.dit.service.SecretaryService;
import gr.hua.dit.entity.Client;

//each method calls a jsp that may return user given parameters
@Controller
@RequestMapping("/secretary")
public class SecretaryController {
	
	// inject the Managing dao
    @Autowired
    private SecretaryService SecretaryService;
    
    
    @RequestMapping("/SecretaryMenu")
	public String AdminMenu() {
		return "Secretary/SecretaryMenu";
	}
    
    @GetMapping("/AddAuto")
	public String AddAuto() {
		return "Secretary/AddAuto";
	}
    
    @PostMapping("/SaveAuto")
	public String SaveAuto(HttpServletRequest request,HttpServletResponse res) throws ServletException,IOException{
    	//get parameters from jsp 
    	String plate = request.getParameter("plate");
		String owner = request.getParameter("owner");
		String last_ckeck = request.getParameter("last_check");
		Date lastCheck = Date.valueOf(last_ckeck);
		String model = request.getParameter("model");
		String auto_type = request.getParameter("auto_type");
		SecretaryService.AddAuto(plate,owner,lastCheck,model,auto_type);
		
		return "redirect:/secretary/AddAuto";
	}
    
    @GetMapping("/DeleteAuto")
	public String DeleteAutoMenu() {
		return "Secretary/DeleteAuto";
	}
    
    @PostMapping("/DeletedAuto")
    public String DeletedAuto(HttpServletRequest request,HttpServletResponse res) throws ServletException,IOException{
    	String plate = request.getParameter("plate");
		if(!plate.equals("null")) {
			SecretaryService.DeleteAuto(plate);
		}
		return "redirect:/secretary/DeleteAuto";
	}
    
    @GetMapping("/UpdateAuto")
    public String UpdateAuto(){
		return "Secretary/UpdateAuto";
	}
    
    @PostMapping("/UpdatedAuto")
    public String UpdatedAuto(HttpServletRequest request,HttpServletResponse res) throws ServletException,IOException{
    	String column = request.getParameter("column");
    	String newValue = request.getParameter("value");
    	String existAuto = request.getParameter("plate");
    	SecretaryService.UpdateAuto(column,newValue,existAuto);
		return "redirect:/secretary/UpdateAuto";
	}
   
    @GetMapping("/CheckInsurance")
    public String CheckInsurance(){
		return "Secretary/CheckInsurance";
	}
    
    @PostMapping("/CheckedInsurance")
    public String CheckedInsurance(HttpServletRequest request,HttpServletResponse res,Model model) throws ServletException,IOException{
    	String plateDB = request.getParameter("plateDB");
    	String answer=SecretaryService.CheckInsurance(plateDB);
    	model.addAttribute("answer",answer);
		return "redirect:/secretary/CheckInsurance";
	}
    
    @GetMapping("/CheckPlate")
	public String CheckPlate() {
		return "Secretary/CheckPlate";
	}
	
	@PostMapping("/CheckedPlate")
	public String CheckedPlate(HttpServletRequest request,HttpServletResponse res,Model model) throws ServletException,IOException{
		// get Users from DAO
		String plate = request.getParameter("plate");
		String exist = SecretaryService.CheckPlate(plate);
		model.addAttribute("exist",exist);
		return "redirect:/secretary/CheckPlate";
	}
    
	@GetMapping("/CheckArrival")
	public String CheckArrival() {
		return "Secretary/CheckArrival";
	}
    @PostMapping("/CheckedArrival")
    public String CheckedArrival(HttpServletRequest request,HttpServletResponse res,Model model) throws ServletException,IOException{
    	String plate = request.getParameter("plate");
    	String answer = SecretaryService.CheckArrival(plate);
    	model.addAttribute("answer",answer);
		return "redirect:/secretary/CheckArrival";
	}
    
    @RequestMapping("/GetClientTable")
	public String GetUserTable(Model model) {
		// get Users from DAO
		List<Client> Secretary = SecretaryService.GetClientTable();

		// add the Users to the model
		model.addAttribute("secretary", Secretary);

		return "Secretary/GetClientTable";
	}
    
    @GetMapping("/CalculateDebt")
    public String CalculateDebt() {
		return "Secretary/CalculateDebt";
	}
    
    @PostMapping("/CalculatedDebt")
    public String CalculatedDebt(HttpServletRequest request,HttpServletResponse res,Model model) throws ServletException,IOException, ParseException{
    	String plate = request.getParameter("plate");
    	int result = SecretaryService.CalculateDebt(plate);
    	model.addAttribute("result",result);
		return "redirect:/secretary/CalculateDebt";
    }
    
}
