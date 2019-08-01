package pwater.controller;

import org.springframework.ui.Model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pwater.model.Account;
import pwater.service.AccountService;

import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Home {
	
	@Autowired
    private AccountService accountService;
	
    @RequestMapping(value = {"/","/home{name}"}, method = RequestMethod.GET)
    public String home(@PathVariable(required = false) String name, Model model) {
    	List<Account> Accounts = accountService.findAll();
    	model.addAttribute("accounts",Accounts);	
        return "_layout";
    }

}