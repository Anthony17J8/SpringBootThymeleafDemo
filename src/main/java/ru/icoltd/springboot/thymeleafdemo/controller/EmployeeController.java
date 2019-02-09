package ru.icoltd.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.icoltd.springboot.thymeleafdemo.model.Employee;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    // load employee data
    private List<Employee> theEmployees;

    @PostConstruct
    private void loadData() {

        // create employees
        Employee emp1 = new Employee(1, "Lesley", "Snejder", "snejder@gmail.com");
        Employee emp2 = new Employee(2, "Paolo", "Maldini", "paolo@gmail.com");
        Employee emp3 = new Employee(3, "Rui", "Costa", "costa@gmail.com");

        // create the list
        theEmployees = new ArrayList<>();

        // add to the list
        theEmployees.add(emp1);
        theEmployees.add(emp2);
        theEmployees.add(emp3);

    }

    // add mapping for '/list'
    @GetMapping("/list")
    public String listEmployees(Model model) {

        // add to the model
        model.addAttribute("employees", theEmployees);

        return "list-employees";
    }

}
