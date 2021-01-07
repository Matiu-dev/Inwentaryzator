package pl.io2.inwentaryzator.controllers;

import pl.io2.inwentaryzator.product.ProductService;
import pl.io2.inwentaryzator.worker.Worker;
import pl.io2.inwentaryzator.worker.WorkerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManagerController {

    @Autowired
    private ProductService productService;

    @Autowired
    private WorkerService workerService;

    private Worker myWorker;

    @GetMapping("/manager")
    public String manager(Model model){

        model.addAttribute("products", productService.findAllProducts());
        model.addAttribute("workers", workerService.findAllWorkers());

        Object worker = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(worker instanceof UserDetails){
            myWorker = new Worker(((UserDetails) worker).getUsername(),
                    ((UserDetails) worker).getPassword(),
                    ((UserDetails) worker).getAuthorities().toString());
        }else {
            //To-Do
        }
        model.addAttribute("myWorker", myWorker);

        return "manager";
    }
}
