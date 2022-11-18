package com.controller;

import com.domain.Employee;
import com.service.EmployeeService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.sql.SQLException;

@Controller
@RequestMapping("/employee")

public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/form")
    public String show(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "form";
    }

    @RequestMapping("/submit")
    public String submit(@Valid @ModelAttribute("employee") Employee employee,
                         BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        else {
            employeeService.insert(employee);
            return "confirmation";
        }
    }

}
