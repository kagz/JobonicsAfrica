package com.example.jobonics.Web.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.jobonics.Persistence.model.CompanyAccount;
import com.example.jobonics.service.CompanyAccountService;

@Controller

public class CompanyAccountController {

	@Autowired
	private CompanyAccountService CAS;

	@RequestMapping(value = "/kompanyaccount", method = RequestMethod.GET)
	public String newRegistration(ModelMap model) {
		CompanyAccount createprofile = new CompanyAccount();
		model.addAttribute("kompanyacc", createprofile);
		return "kampunaccount";
	}

	
	///saving company account list
	@RequestMapping(value = "/savekompanyaccount", method = RequestMethod.POST)
	public String saveRegistration(@Valid CompanyAccount createprofile, BindingResult result, ModelMap model,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			System.out.println("has errors");
			return "kampunaccount";
		}

		CAS.save(createprofile);

		return "redirect:/viewkompanyaccount";
	}

	
	//company accounts list
	@RequestMapping(value = "/viewkompanyaccount")
	public ModelAndView getAll() {

		List<CompanyAccount> list = CAS.findAll();
		return new ModelAndView("viewkompanyaccount", "list", list);
	}

	
	
	
	
	
	
	
	
	
	
}
