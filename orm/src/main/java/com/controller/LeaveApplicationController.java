package com.controller;

import com.domain.LeaveApplication;
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
@RequestMapping("/Applicaiton")
public class LeaveApplicationController {
    private LeaveApplicationService leaveApplicationService;

    public LeaveApplicationController(LeaveApplicationService leaveApplicationService) {
        this.leaveApplicationService = leaveApplicationService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/show")
    public String show(Model model) {
        LeaveApplication leaveApplication = new LeaveApplication();
        model.addAttribute("leaveApplication", leaveApplication);
        return "registration";
    }

    @RequestMapping("/submit")
    public String submit(@Valid @ModelAttribute("leaveApplication") LeaveApplication leaveApplication,
                         BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        else {
            leaveApplicationService.insert(leaveApplication);
            return "confirmation";
        }
    }
}
