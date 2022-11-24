package com.controller;

import com.domain.Currency;
import com.domain.LeaveApplication;
import com.domain.LeaveType;
import com.domain.Student;
import com.service.LeaveApplicationService;
import com.service.LeaveTypeService;
import com.service.StudentService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDate;

@Controller
@RequestMapping("/leaveApplications")
public class LeaveApplicationController {

    private LeaveApplicationService leaveApplicationService;

    private LeaveTypeService leaveTypeService;

    private StudentService studentService;

    public LeaveApplicationController(LeaveApplicationService leaveApplicationService, LeaveTypeService leaveTypeService, StudentService studentService) throws Exception {
        this.leaveApplicationService = leaveApplicationService;
        this.leaveTypeService = leaveTypeService;
        this.studentService = studentService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/create")
    public void create() throws Exception {
        LeaveType leaveType = leaveTypeService.get(1L);
        Student student = studentService.get(4L);

        LeaveApplication leaveApplication = new LeaveApplication();
        leaveApplication.setStudent(student);
        leaveApplication.setLeaveType(leaveType);

        leaveApplication.setFromDate(LocalDate.of(2022, 10, 20));
        leaveApplication.setToDate(LocalDate.of(2022, 10, 28));
        leaveApplication.setTotalDays(9);
        leaveApplication.setReason("High Fever");
        boolean result = leaveApplicationService.insert(leaveApplication);
        if (!result) {
            throw new Exception("Constraint Violation");
        }
    }

    @GetMapping("/api/leaveApplications/{id}")
    public void get(@PathVariable("id") String id) {
        LeaveApplication leaveApplication = leaveApplicationService.get(Long.valueOf(id));
        System.out.println(leaveApplication.getId() + " " + leaveApplication.getLeaveType().getCategory() + " " + leaveApplication.getTotalDays() + " " + leaveApplication.getReason());
    }

    @GetMapping("/api/leaveApplications")
    public void list() {
        LeaveApplication leaveApplication = leaveApplicationService.List();
        System.out.println(leaveApplication);
    }

    @GetMapping("/api/leaveApplication/{id}")
    public void delete(@PathVariable("id") String id) {
        leaveApplicationService.delete(Long.valueOf(id));
        System.out.println("Deleted!");
    }

    @PostMapping(path = "/api/leaveApplication")
    public void insert(@Valid @RequestBody LeaveApplication leaveApplication) throws Exception {

        LeaveType leaveType = leaveTypeService.get(leaveApplication.getId());
        Student student = studentService.get(leaveApplication.getId());

        leaveApplication.setStudent(student);
        leaveApplication.setLeaveType(leaveType);

        leaveApplication.setFromDate(leaveApplication.getFromDate());
        leaveApplication.setToDate(leaveApplication.getToDate());
        leaveApplication.setTotalDays(leaveApplication.getTotalDays());
        leaveApplication.setReason(leaveApplication.getReason());

        boolean result = leaveApplicationService.insert(leaveApplication);

        if (!result) {
            throw new Exception("Constraint Violation");
        }

    }

    @PostMapping(path = "/api/leaveApplication/update/{id}")
    public void update(@Valid @RequestBody LeaveApplication leaveApplication) throws Exception {

        LeaveType leaveType = leaveTypeService.get(leaveApplication.getId());
        Student student = studentService.get(leaveApplication.getId());

        leaveApplication.setStudent(student);
        leaveApplication.setLeaveType(leaveType);

        leaveApplication.setFromDate(leaveApplication.getFromDate());
        leaveApplication.setToDate(leaveApplication.getToDate());
        leaveApplication.setTotalDays(leaveApplication.getTotalDays());
        leaveApplication.setReason(leaveApplication.getReason());

        boolean result = leaveApplicationService.insert(leaveApplication);

        if (!result) {
            throw new Exception("Constraint Violation");
        }

    }
}

