package example.sweater.controllers;

import example.sweater.models.User;
import example.sweater.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class GreetingController {
    private UserRepository userRepository;

    public GreetingController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping()
    public ModelAndView main(Map<String, Object> model) {
        Iterable<User> users = userRepository.findAll();
        model.put("users", new Object());
        return new ModelAndView("greeting", model);
    }

    @GetMapping("/greeting")
    public ModelAndView greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Map<String, String> model) {
        model.put("name", name);
        return new ModelAndView("greeting", model);
    }
}
