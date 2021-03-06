package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.Role;
import web.model.User;
import web.service.UserService;

import java.util.*;


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
	public String formAddUser(ModelMap model) {
		model.addAttribute("listOfRoles", userService.listRoles());
		return "user_form";
	}

	@PostMapping("/admin/save")
	public String addUser(@RequestParam(value = "id") String id, @RequestParam(value = "name") String name,
						  @RequestParam(value = "password") String password, ModelMap model, @RequestParam("roles")String[] roles) {
		Set<Role> tempRole = new HashSet<>();
		for (int i = 0; i < roles.length; i++) {
			tempRole.add(userService.getRoleByName(roles[i]));
		}
		User user;
		if (id.isEmpty()) {
			userService.addUser(new User(name, password, tempRole));
		} else {
			user = new User(Long.valueOf(id), name, password, tempRole);
			userService.updateUser(user);
		}
		return "redirect:/admin";
	}

	@GetMapping("/admin/updateUser/{id}")
	public String formUpdateUser(@PathVariable("id") long id, ModelMap model) {
		model.addAttribute("user", userService.getUserById(id));
		model.addAttribute("listOfRoles", userService.listRoles());
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