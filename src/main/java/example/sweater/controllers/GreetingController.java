package example.sweater.controllers;

import example.sweater.models.User;
import example.sweater.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {
    private final UserRepository userRepository;

    public GreetingController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public ModelAndView index(Map<String, Object> model) {
        Iterable<User> users = userRepository.findAll();
        model.put("users", users);
        return new ModelAndView("greeting", model);
    }

    @GetMapping("/search")
    public ModelAndView greeting(@RequestParam String filter, Map<String, Object> model) {
        List<User> users = userRepository.findByName(filter);
        model.put("users", users);
        return new ModelAndView("greeting", model);
    }

    @PostMapping("/create")
    public String create(@RequestParam String name, @RequestParam String email) {
        userRepository.save(new User(name, email));
        return "redirect:/";
    }
}
