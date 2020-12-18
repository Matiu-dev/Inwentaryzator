package pl.io2.inwentaryzator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.io2.inwentaryzator.user.WorkerService;

@Controller
public class LoginController {

    @Autowired
    private WorkerService workerService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
