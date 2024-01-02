package com.ken.springboot.thymeleafdemo.controller;

import com.ken.springboot.thymeleafdemo.entity.Employee;
import com.ken.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService; // inject service

    @Autowired
    public EmployeeController(EmployeeService es) {  // inject service
        employeeService = es;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());

        return "employees/employee-form"; // resources/templates/employees/employee-form
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);

        return "redirect:/employees/list"; // use redirect to request mapping to avoid duplicate submissions
    }

    @GetMapping("/showFormForUpdate")
    public String updateEmployee(@RequestParam("employeeId") int employeeId, Model model) {
        Employee employee = employeeService.findById(employeeId);
        model.addAttribute("employee", employee);

        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int employeeId, Model model) {
        employeeService.deleteById(employeeId);

        return "redirect:/employees/list";
    }
}
