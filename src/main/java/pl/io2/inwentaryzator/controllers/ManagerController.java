package pl.io2.inwentaryzator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.io2.inwentaryzator.product.Product;
import pl.io2.inwentaryzator.product.ProductService;
import pl.io2.inwentaryzator.user.WorkerService;

import java.util.List;

@Controller
public class ManagerController {

    @Autowired
    private ProductService productService;

    @Autowired
    private WorkerService workerService;

    @GetMapping("/manager")
    public String manager(Model model){

        model.addAttribute("products", productService.findAllProducts());
        model.addAttribute("workers", workerService.findAllWorkers());

        return "manager";
    }
}
