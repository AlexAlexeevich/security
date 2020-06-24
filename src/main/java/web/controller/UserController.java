package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
@RequestMapping("/")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/admin")
	public String showUsers(ModelMap model) {
		model.addAttribute("list", userService.listUsers());
		return "user_list";
	}

	@GetMapping("/admin/addUser")
	public String formAddUser() {
		return "user_form";
	}

	@PostMapping("/admin/save")
	public String addUser(@ModelAttribute User user) {
		if(user != null && user.getId() != null){
			userService.updateUser(user);
		} else {
			userService.addUser(user);
		}
		return "redirect:/admin";
	}

	@GetMapping("/admin/updateUser/{id}")
	public String formUpdateUser(@PathVariable("id") long id, ModelMap model) {
		model.addAttribute("user", userService.getUserById(id));
		return "user_form";
	}

	@GetMapping("/admin/deleteUser/{id}")
	public String deleteUser(@PathVariable("id") long id) {
		userService.deleteUser(id);
		return "redirect:/admin";
	}

	@GetMapping("/user")
	public String userHome(ModelMap model) {
		model.addAttribute("user", SecurityContextHolder
				.getContext().getAuthentication().getPrincipal());
		return "user_home";
	}

	//////////////////////////////////

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

}