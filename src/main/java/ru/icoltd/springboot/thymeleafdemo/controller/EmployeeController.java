package ru.icoltd.springboot.thymeleafdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.icoltd.springboot.thymeleafdemo.entity.Employee;
import ru.icoltd.springboot.thymeleafdemo.service.EmployeeService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // add mapping for '/list'
    @GetMapping("/list")
    public String listEmployees(Model model) {

        // get employees from db
        List<Employee> theEmployees = employeeService.findAll();

        // add to the entity
        model.addAttribute("employees", theEmployees);

        return "list-employees";
    }

}
