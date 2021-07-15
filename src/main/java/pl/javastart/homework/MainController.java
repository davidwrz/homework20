package pl.javastart.homework;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    UserRepository userRepository;

    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    @ResponseBody
    public String list() {
        List<User> userList = userRepository.getAll();
        String result = "";
        for (User user1 : userList) {
            result += " " + user1.toString() + "<br/>";
        }
        return result;
    }

    @RequestMapping("/add")
    public String hello(@RequestParam(name = "imie") String firstName,
                        @RequestParam(name = "nazwisko") String lastName,
                        @RequestParam(name = "wiek", defaultValue = "0") int age) {
        if (firstName.equals("") || lastName.equals("")) {
            User user = new User(firstName, lastName, age);
            userRepository.add(user);
            return "success.html";
        } else {
            return "err.html";
        }
    }
}
