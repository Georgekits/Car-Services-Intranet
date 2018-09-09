package gr.hua.dit.controller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import gr.hua.dit.service.EngineerService;

//each method calls a jsp that may return user given parameters
@Controller
@RequestMapping("/engineer")
public class EngineerController {

	// inject the Managing DAO
    @Autowired
    private EngineerService EngineerService;
    
    @RequestMapping("/EngineerMenu")
	public String EngineerMenu() {
		return "Engineer/EngineerMenu";
	}
     
    @GetMapping("/SubmitNextCheck")
    public String SubmitNextCheck() {
		return "Engineer/SubmitNextCheck";
	}
    
    @PostMapping("/SubmittedNextCheck")
    public String SubmittedNextCheck(HttpServletRequest request,HttpServletResponse res,Model model) throws ServletException,IOException, ParseException{
    	String plate = request.getParameter("plate");
    	String nextCheck = request.getParameter("nextCheck");
    	EngineerService.SubmitNextCheck(plate,nextCheck);
		return "redirect:/engineer/SubmitNextCheck";
    }
    
    
    @GetMapping("/HasDamage")
    public String HasDamage() {
		return "Engineer/HasDamage";
	}
    
    @PostMapping("/UpdatedDamage")
    public String UpdatedDamage(HttpServletRequest request,HttpServletResponse res,Model model) throws ServletException,IOException{
    	String plate = request.getParameter("plate");
    	String damage = request.getParameter("damage");
    	EngineerService.HasDamage(plate,damage);
		return "redirect:/engineer/HasDamage";
    }
    
   
}
