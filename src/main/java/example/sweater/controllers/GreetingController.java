package example.sweater.controllers;

import example.sweater.models.User;
import example.sweater.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
    private final UserRepository userRepository;

    public GreetingController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String index(Model model) {
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "greeting";
    }

    @GetMapping("/search")
    public String greeting(@RequestParam String filter, Model model) {
        User users = userRepository.findByUsername(filter);
        model.addAttribute("users", users);
        return "greeting";
    }

    @PostMapping("/create")
    public String create(@RequestParam String name, @RequestParam String email) {
        userRepository.save(new User(name, email));
        return "redirect:/";
    }
}
