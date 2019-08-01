package pwater.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pwater.form.LoginForm;
import pwater.model.Account;
import pwater.service.AccountService;

@Controller
public class Login {
	
	@Autowired
    private AccountService accountService;
	
    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login(
    		LoginForm loginForm
    ) {    	
        return "_layout";
    }
    
    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String checkLogin(
    	@RequestParam(required = false) String email,
    	@RequestParam(required = false) String password,
    	@RequestParam(required = false) String remmeber,
		@Valid LoginForm loginForm, 
		BindingResult bindingResult,
		Model model
    ) {	
    	if (bindingResult.hasErrors()) {
            return "_layout";
        }else {
        	Account loginAcc = new Account();
        	loginAcc.setEmail(email);
        	loginAcc.setPassword(password);
        	Account acc	= accountService.findAccById(email);
//        	System.out.println(acc.getId());
//        	System.out.println(acc.getEmail());
//        	System.out.println(acc.getPassword());
//        	System.out.println(password);
//        	System.out.println(acc.getGender());
        	if(password.equals(acc.getPassword())) {
        		return "redirect:/home";
        	}else {
        		model.addAttribute("loginError","Your account's information is not found!");
        		return "_layout";
        	}
        	
        }
    }
}