package io.naren.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import io.naren.model.Users;
import io.naren.repo.ListRepo;


@Controller
public class ListController {

	@Autowired	
	private ListRepo listrepo;
	
    @RequestMapping(value = "/welcome" , method = RequestMethod.GET)
    public String welcome() {
        return "greetings";
    }
    
    @GetMapping(path="/signup")
    public String signupnewuser(Model model)
    {
    	model.addAttribute("users", new Users());
    	return "logging";
    }
    
    @PostMapping(path="/signup")
	public ModelAndView addNewUser (@RequestParam("username") String username
			, @RequestParam("password") String password)
    {
    	Users userobj =listrepo.findByUsername(username);
    	if(userobj==null)
    	{
		Users n = new Users();
		n.setUsername(username);
		n.setPassword(password);
		listrepo.save(n);
		return new ModelAndView("redirect:/todo");
		}
    	System.out.println("user name already exit");
    	return new ModelAndView("redirect:/errorthrown");
	}
  
	@RequestMapping(value = "/successful" , method = RequestMethod.GET)
    public String registered() {
        return "success";
    }
	
	@RequestMapping(value = "/errorthrown" , method = RequestMethod.GET)
    public String alreadyexits() {
        return "errors";
    }
    
}
