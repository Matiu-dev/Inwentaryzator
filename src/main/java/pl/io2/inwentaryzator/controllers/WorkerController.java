package pl.io2.inwentaryzator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//po zalogowaniu
@Controller
public class WorkerController {

    @GetMapping("/")
    public String index(){
        return "worker";
    }


}
