package com.codegym.controller;

import com.codegym.model.Employee;
import com.codegym.model.EmployeeForm;
import com.codegym.service.EmployeeService;
import com.codegym.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/demo")
public class EmployeeController {
    private IEmployeeService employeeService = new EmployeeService();

    @GetMapping("")
    public ModelAndView showListEmployee() {
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("employee", employeeService.listEmployees());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView ShowFormCreate() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("employeeForm", new EmployeeForm());
        return modelAndView;
    }

    @Value("${file_upload}")
    private String fileUpload;

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute EmployeeForm employeeForm) {
        MultipartFile multipartFile = employeeForm.getImage();
        String file = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(employeeForm.getImage().getBytes(), new File(fileUpload + "/" + file));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Employee employee = new Employee(employeeForm.getId(), employeeForm.getName(), employeeForm.getAddress(), employeeForm.getNumber(), employeeForm.getSalary(), file);
        employeeService.saveEmployee(employee);
     ModelAndView modelAndView=new ModelAndView("/create");
     modelAndView.addObject("employee",employee);
     return modelAndView;
    }
}
